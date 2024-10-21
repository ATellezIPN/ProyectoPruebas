@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        // Verificar si el nombre de usuario ya existe
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean existeUsuario = usuarioDAO.existeUsuario(usuario);

        if (!existeUsuario) {
            // Si no existe, registrar el nuevo usuario
            Usuario nuevoUsuario = new Usuario(nombre, correo, usuario, password);
            usuarioDAO.registrarUsuario(nuevoUsuario);

            // Redirigir al header.html
            response.sendRedirect("header.html");
        } else {
            // Redirigir a signup.html si el usuario ya existe
            response.sendRedirect("signup.html?error=usuarioExiste");
        }
    }
}
