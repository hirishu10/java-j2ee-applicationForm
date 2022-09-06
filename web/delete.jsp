<%-- 
    Document   : delete
    Created on : 4 Sept 2022, 12:18:53
    Author     : rishuchowdhary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
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
                 >Delete</div>
        </div>
        <hr/>
        <div style="
             width: 100%;
             height: 300px;
             ">

            <form style="
                  width: 100%;
                  height: 100%;
                  display: flex;
                  justify-content:center;
                  align-items: center;
                  "
                  action="DeleteData"
                  >

                <label>User Id:</label>
                <input type="number" name="user_id" placeholder="Id" value="0" style="margin-right:5px; width:80px;height:20px;"/>
                <input type="submit" 
                       value="Delete"
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
            </form>
        </div>
    </body>
</html>
