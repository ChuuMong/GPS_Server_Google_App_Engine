package com.gps.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JongHunLee on 2015-04-21.
 */

public class RequestUserId extends HttpServlet {
    private int userId = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userId += 4;
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        resp.setContentType("text/html");

        resp.getWriter().print(String.valueOf(userId));
    }
}
