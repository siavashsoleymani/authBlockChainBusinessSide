package ir.example.businessside.controllers;

import ir.example.businessside.model.UserRepository;
import ir.example.businessside.model.dto.LidAndLinkDTO;
import ir.example.businessside.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UidController {

    RestTemplate restTemplate = new RestTemplate();

    private final UserRepository userRepository;

    @Autowired
    public UidController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/qrCode")
    public Map<String, String> getQrcodeLink() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "aaaa");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<LidAndLinkDTO> lidAndLinkDTOResponseEntity = restTemplate.exchange("http://localhost:8080/aaaa/generateQrCode" +
                                                                                          "?size=500" +
                                                                                          "&callBackUrl=http://localhost:8081/userReceived"
                , HttpMethod.GET, httpEntity, LidAndLinkDTO.class);
        Map<String, String> response = new HashMap<>();
        response.put("link", lidAndLinkDTOResponseEntity.getBody().getLink());
        response.put("lid", lidAndLinkDTOResponseEntity.getBody().getLid());
        return response;
    }

    @PostMapping("/userReceived")
    public void userReceived(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping(value = "/user", params = {"lid"})
    public ResponseEntity<User> getUser(@RequestParam("lid") String lid) {
        User byLid = userRepository.findByLid(lid);
        if (byLid == null)
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(byLid, HttpStatus.OK);

    }
}
