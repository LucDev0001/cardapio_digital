import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calculo")
public class Calculo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String v1 = request.getParameter("valor1");
        String v2 = request.getParameter("valor2");
        String operacao = request.getParameter("operacao");
        String resultado = "";

        try {
            if (v1 == null || v2 == null || v1.isEmpty() || v2.isEmpty()) {
                resultado = "Preencha todos os campos.";
            } else {
                float valor1 = Float.parseFloat(v1);
                float valor2 = Float.parseFloat(v2);

                switch (operacao) {
                    case "+":
                        resultado = valor1 + " + " + valor2 + " = " + (valor1 + valor2);
                        break;
                    case "-":
                        resultado = valor1 + " - " + valor2 + " = " + (valor1 - valor2);
                        break;
                    case "*":
                        resultado = valor1 + " * " + valor2 + " = " + (valor1 * valor2);
                        break;
                    case "/":
                        if (valor2 == 0) {
                            resultado = "Erro: Divisão por zero.";
                        } else {
                            resultado = valor1 + " / " + valor2 + " = " + (valor1 / valor2);
                        }
                        break;
                    default:
                        resultado = "Operação inválida.";
                }
            }
        } catch (NumberFormatException e) {
            resultado = "Erro: Entrada inválida.";
        }

        request.setAttribute("resultado", resultado);
        RequestDispatcher rd = request.getRequestDispatcher("calcula.jsp");
        rd.forward(request, response);
    }
}
