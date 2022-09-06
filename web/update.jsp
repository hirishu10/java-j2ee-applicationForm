<%-- 
    Document   : update
    Created on : 4 Sept 2022, 12:18:02
    Author     : rishuchowdhary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <title>Update Page</title>
        <style>
            *{
                margin:0px;
                padding:0px;
            }
        </style>
    </head>
    <body style="font-family: system-ui,sans-serif; background-color: ghostwhite;">
        <div style="width:100%;height:100px;display: flex;">
            <div style="width: 30%;
                 height: 100%;
                 font-size: 30px;
                 display: flex;
                 justify-content: center;
                 align-items: center;
                 font-weight: 200;
                 color: #0d2136;
                 "
                 >Update</div>
        </div>
        <hr/>
        <div style="
             width: 100%;
             height: 300px;
             ">

            <form  style="
                   width: 100%;
                   height: 100%;
                   "
                   action="UpdateData"
                   >

                <div style="
                     width: 100%;
                     height: 50%;
                     display: flex;
                     justify-content:center;
                     align-items: center;

                     ">

                    <label>User Id:</label>
                    <input type="number" name="user_id" placeholder="Id" value="0" style="margin-right:5px; width:80px;height:20px;"/>
                    <input type="text" name="user_name" placeholder="Name" style="margin-right:5px; height:20px;"/>
                    <input type="text" name="user_email" placeholder="Email" style="margin-right:5px; height:20px;"/>
                    <input type="text" name="user_gender" placeholder="Gender" style="margin-right:5px; height:20px;"/>
                    <input type="text" name="user_course" placeholder="Course" style="margin-right:5px; height:20px;"/>

                </div>

                <div style="
                     width: 100%;
                     height: 50%;
                     display: flex;
                     justify-content:center;
                     align-items: center;
                     ">

                    <input type="submit"
                           value="Update"
                           style="
                           border: none;
                           background-color: dodgerblue;
                           color: white;
                           margin-top: 10px;
                           padding: 10px;
                           cursor: pointer;
                           text-decoration: none;
                           margin-right:20px;
                           "

                           />
                    <input type="reset"  
                           value="Reset"
                           style="
                           border: none;
                           background-color: #c71e58;
                           color: white;
                           margin-top: 10px;
                           padding: 10px;
                           cursor: pointer;
                           text-decoration: none;
                           margin-right:20px;
                           "
                           />
                </div>
            </form>
        </div>
    </body>
</html>
