<%-- 
    Document   : home
    Created on : 3 Sept 2022, 17:56:03
    Author     : rishuchowdhary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Application Form</title>

        <style>
            .body-container{
                width: 99%;
                height: 95vh;
                display:flex;
                justify-content: flex-start;
                align-items: center;
                flex-direction: column;
                background-color: ghostwhite;
            }
            .container{
                width:500px;
                height: 320px;
                margin-top: 50px;
                display:flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                box-shadow: 0px 0px 10px 0px lightgrey;
            }
            .input-box{
                border: 1px solid silver;
                background-color: lavender;
                outline-style: none;
            }
            .input-box:focus{
                background-color: yellow;
            }
            .button-design{
                border: none;
                background-color: dodgerblue;
                color: white;
                margin-top: 10px;
                padding: 10px;
                cursor: pointer;
            }
            .button-design:hover{
                background-color: #467cb1;
                transition: 0.3s all;
            }
            .each-row{
                /*do nothing*/
            }
            @media (max-width: 550px) {
                .container{
                    width: 420px;
                }
            }

            /*Footer*/
            .containerForLogo {
                width: 100%;
                font-family: system-ui,sans-serif;
                margin-top: 200px;

            }

            .containerForLogoTitle {
                width: 100%;
                height: 50%;
                color: #d49f00;
                display: flex;
                justify-content: center;
                align-items: flex-end;
            }

            .containerForLogoImage {
                width: 100%;
                height: 50%;
                display: flex;
                justify-content: center;
                align-items: center;

            }
        </style>

    </head>
    <body class="body-container">
        <div class="container">
            <h1 style="color: indianred;">Application Form</h1>
            <form  

                action="RegisterApplication" method="post"
                >
                <table>

                    <tr class="each-row">
                        <td>Enter your name:</td>
                        <td><input type="text" name="user_name" placeholder="Enter your name" class="input-box"/></td>
                    </tr>



                    <tr class="each-row">
                        <td>Enter your email:</td>
                        <td><input type="email" name="user_email" placeholder="Enter your email" class="input-box"/></td>
                    </tr>


                    <tr class="each-row">
                        <td>Gender:</td>
                        <td>
                            <input type="radio" name="user_gender" value="male" title="Male"/>
                            <label>Male</label>
                            <input type="radio" name="user_gender" value="female" title="Female"/>
                            <label>Female</label>
                        </td>
                    </tr>


                    <tr class="each-row">
                        <td>Course:</td>
                        <td>
                            <select name="user_course" class="input-box">
                                <option value="none">Select Course</option>
                                <option value="java">Java</option>
                                <option value="javascript">JavaScript</option>
                                <option value="python">Python</option>
                                <option value="typescript">TypeScript</option>
                            </select>
                        </td>
                    </tr>


                    <tr class="each-row">
                        <td style="text-align: right;">
                            <input type="checkbox" name="user_terms" value="checked" style="cursor:pointer;"/>
                        </td>
                        <td>
                            Agree our Terms & Condition.
                        </td>
                    </tr>


                    <tr class="each-row">
                        <td style="text-align: center;">
                            <input id="registerButton" type="submit" name="register" value="Register" class="button-design" style="background-color: #009688;"/>
                        </td>
                        <td style="text-align: center;">
                            <input id="resetButton" type="reset" name="reset" value="Reset" class="button-design" style="background-color: #c71e58;"/>
                            <a href="ShowData" class="button-design" style="text-decoration: none;">Show Data</a>
                        </td>
                    </tr>
                </table>

            </form>
        </div>

        <!-- Footer -->
        <div class="containerForLogo">
            <div class="containerForLogoTitle">from</div>
            <div class="containerForLogoImage">
                <Image src="public/myLogo.svg" alt="Rishu Chowdhary" width="40px" height="27px" priority="true" />
                <span style="font-size:18px;color:#112931;">
                    Rishu
                </span>
            </div>
        </div>
        <!-- Footer -->
        <br />
    </body>
    <script>
        //:: If user submit the form the details will be reset after user do back.
        let reset = document.getElementById("resetButton");
        let register = document.getElementById("registerButton");

        register.onclick = (e) => {
//            register.value = "Test";//::> Debug
            setTimeout(() => {
                reset.click();// reset Button auto
            }, [500]);
        }
    </script>
</html>
