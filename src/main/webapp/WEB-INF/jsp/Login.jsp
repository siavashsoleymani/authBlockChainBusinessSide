<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        #container {
            width: 50%;
            height: 50%;
            border-radius: 30px;
            padding: 16px;
            background-color: #fefefe;
            margin: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }

        #qrcode_img {
            width: 40%;
            height: auto;
        }

        #logintext {
            margin-left: -25%;

        }

        #form {
            direction: rtl;
            display: inline;
            float: right;
            margin-right: 50px;
        }

        #user_image {
            width: 40%;
            height: auto;
            margin-right: 70px;
        }

        #login_btn {
            width: 250px;
            height: 30px;
            background-color: dodgerblue;
            border-radius: 10px;
            margin-top: 10px;
            margin-right: 25px;
        }

        .input {
            border-radius: 20px;
            width: 300px;
            height: 20px;
            background-color: lightskyblue;
            margin-top: 10px;
            padding: 10px;
            direction: ltr;
        }

        body {
            background-color: deepskyblue;
        }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $.getJSON({
                url: "http://localhost:8081/qrCode", success: function (result) {
                    console.log(result['link']);
                    console.log(result['lid']);
                    document.getElementById("qrcode_img").src = result['link'];
                    var refreshId = setInterval(function () {
                        $.getJSON({
                            url:"http://localhost:8081/user?lid="+result['lid'], success: function (result2) {
                                console.log(result2);
                                clearInterval(refreshId);
                                document.location.href = "http://localhost:8081/profile?name=نام: "+result2['name'] + "&dob=تاریخ تولد: "+result2['dob'] + "&sex=" + result2['sex'];
                            }
                        });
                    }, 1000);
                }
            });
        });
    </script>
</head>
<body>
<div id="container">
    <img id="qrcode_img" src="qrcode">
    <span id="logintext">ورود با رمزینه</span>
    <form id="form">
        <img id="user_image" src="user.png"><br>
        <input class="input" type="text"><br>
        <input class="input" type="password"><br>
        <button id="login_btn">ورود</button>
    </form>
</div>
</body>
</html>