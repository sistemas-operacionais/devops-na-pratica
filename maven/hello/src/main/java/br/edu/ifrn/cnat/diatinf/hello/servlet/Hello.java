package br.edu.ifrn.cnat.diatinf.hello.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by usta on 12.02.2017.
 */
@WebServlet(value = {"/oie"})
public class Hello extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (PrintWriter out = resp.getWriter();) {
            out.write("<html>" +
                    "<body><h1>Oie !!!</h1></body>" +
                    "</html>");
        }

    }
}
