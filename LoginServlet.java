@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validar usuario en base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.validarUsuario(email, password);

        if (usuario != null) {
            // Si las credenciales son correctas, redirigir al header.html
            response.sendRedirect("header.html");
        } else {
            // Redirigir de vuelta a login.html si falla la autenticación
            response.sendRedirect("login.html?error=true");
        }
    }
}
