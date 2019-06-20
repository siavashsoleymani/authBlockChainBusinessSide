<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <style>
        #container {
            width: 30%;
            height: 80%;
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
        #check_img{
            margin: 0;
            position: absolute;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            display: block;
        }
        #greeting_txt{
            display: block;
            direction: rtl;
            margin-right: 10%;
        }
        #username_txt{
            display: block;
            margin-top: 20%;
            direction: rtl;
            font-size: 22px;
            color: green;
        }
        #profile_info_txt{
            display: block;
            margin-top: 20%;
            direction: rtl;
            font-size: 22px;
            color: green;
        }

        .infos{
            display: block;
            margin-top: 5%;
            direction: rtl;
            font-size: 16px;
            color: black;
        }
        body {
            background-color: deepskyblue;
        }
    </style>
</head>
<body>
    <div id="container">
        <img id="check_img" src="check.png">
        <span id="username_txt">علی</span>
        <span id="greeting_txt">عزیز ورود شما با موفقیت انجام شد.</span>
        <span id="profile_info_txt">اطلاعات کاربری شما</span>
        <span class="infos" id="name">${name}</span>
        <span class="infos" id="dob">${dob}</span>
        <span class="infos" id="sex">جنسیت: ${sex}</span>
    </div>
</body>
</html>