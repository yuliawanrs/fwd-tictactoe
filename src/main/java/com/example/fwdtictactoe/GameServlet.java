package com.example.fwdtictactoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "gameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    GameState gameState;
    String fieldSize;

    public void init() { }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gameState.setStep(Integer.parseInt(req.getParameter("i")), Integer.parseInt(req.getParameter("j")));
        this.goToPage(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gameState = new GameState();
        fieldSize = "".equalsIgnoreCase(req.getParameter("fieldSize")) ? "0" : req.getParameter("fieldSize");
        gameState.setFieldSizes(Integer.parseInt(fieldSize));
        this.goToPage(req, resp);
    }

    private void goToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        req.setAttribute("fieldSize", fieldSize);
        req.setAttribute("status", gameState.getStatus());
        req.setAttribute("field", gameState.drawField());
        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    public void destroy() { }
}
