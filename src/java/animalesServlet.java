import database.Tbanimal;
import database.Tbtipo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicaDeNegocio.TbanimalFacade;
import logicaDeNegocio.TbtipoFacade;

@WebServlet(urlPatterns = {"/animalesServlet"})
public class animalesServlet extends HttpServlet {

    @EJB
    private TbtipoFacade tbtipoFacade;

    @EJB
    private TbanimalFacade tbanimalFacade;

    @PersistenceContext(unitName = "AnimalesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    protected void processTipoRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            List<Tbtipo> listaTipos = tbtipoFacade.findAll();
            request.setAttribute("listaTipos", listaTipos);
    
            RequestDispatcher requestDispatcher; 
            requestDispatcher = request.getRequestDispatcher("/tipos.jsp");
            requestDispatcher.forward(request, response);
    
    }
    protected void processAnimalesRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            int idTipo = Integer.parseInt(request.getParameter("tipo"));
            List<Tbanimal> listaAnimales = tbanimalFacade.findAllByIdTipo(idTipo);
            request.setAttribute("listaAnimales", listaAnimales);
    
            RequestDispatcher requestDispatcher; 
            requestDispatcher = request.getRequestDispatcher("/animales.jsp");
            requestDispatcher.forward(request, response);
    
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String tipo = request.getParameter("tipo");
        
        
        if (tipo==null) {
            processTipoRequest(request, response);
            
            
        }
        else {
            
            processAnimalesRequest(request, response);
            
        }
        
        String accion = request.getParameter("accion");
        
        if (accion.equals("insertar")){
            
            String  nombreanimal = request.getParameter("nombre_animal");
            String  descripcion = request.getParameter("descripcion");
            Integer  idtipo =Integer.parseInt (request.getParameter("id_tipo"));
        
             
            Tbanimal animal = new Tbanimal ();
            Tbtipo tipo1 = new Tbtipo(idtipo);
            
            animal.setNombre(nombreanimal);
            animal.setDescripcion(descripcion);
            animal.setIdTipo(tipo1);
            
            insertarAnimal(animal);
            
            
            request.setAttribute("resultados", "Inserción realizada");
      
        RequestDispatcher requestDispatcher; 
        requestDispatcher = request.getRequestDispatcher("/animales.jsp");
        requestDispatcher.forward(request, response);
        }
        
        if (accion.equals("buscar")){
            
             Integer idanimal =Integer.parseInt (request.getParameter("id_animal"));
             
             Tbanimal animal = new Tbanimal ();
             animal.setId(idanimal);
             
             animal = buscarAnimal(animal);
             
             request.setAttribute("id_animal", animal.getId());
             request.setAttribute("nombre_animal", animal.getNombre());
             request.setAttribute("descripcion", animal.getDescripcion());
             request.setAttribute("id_tipo", animal.getIdTipo().getId());

            RequestDispatcher requestDispatcher; 
            requestDispatcher = request.getRequestDispatcher("/form_update.jsp");
            requestDispatcher.forward(request, response);
        
        
        }
        
        
        
        if (accion.equals("actualizar")){
            
           
            Integer idanimal =Integer.parseInt (request.getParameter("id_animal"));
            String  nombreanimal = request.getParameter("nombre_animal");
            String  descripcion = request.getParameter("descripcion");
            Integer  idtipo =Integer.parseInt (request.getParameter("id_tipo"));
        
        
            
            Tbtipo tipo1 = new Tbtipo(idtipo);

            Tbanimal animal = new Tbanimal ();
            animal.setId(idanimal);
            animal.setNombre(nombreanimal);
            animal.setDescripcion(descripcion);
            animal.setIdTipo(tipo1);

            actualizarAnimal(animal);
           
             request.setAttribute("resultados", "Actualización realizada");
            RequestDispatcher requestDispatcher; 
        requestDispatcher = request.getRequestDispatcher("/animales.jsp");
        requestDispatcher.forward(request, response);
        
            
        }
       
        
        
    }

    
    
    public void insertarAnimal(Tbanimal animal) {
        
        try {
       utx.begin();
        
       em.createNativeQuery("INSERT INTO  Tbanimal(id,nombre,descripcion,id_tipo) VALUES (nextval('secuencia_main'),?,?,?)")
      .setParameter(1, animal.getNombre())
      .setParameter(2, animal.getDescripcion())
      .setParameter(3, animal.getIdTipo().getId())
      .executeUpdate();
       utx.commit();
       
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
    public void actualizarAnimal(Tbanimal animal) {
        
        try {
       utx.begin();
        
       em.createNativeQuery("UPDATE Tbanimal set nombre=?, descripcion=?, id_tipo=? where id = ?")
      .setParameter(1, animal.getNombre())
      .setParameter(2, animal.getDescripcion())
      .setParameter(3, animal.getIdTipo().getId())
      .setParameter(4, animal.getId())
      .executeUpdate();
       utx.commit();
       
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
    
     public Tbanimal buscarAnimal(Tbanimal animal) {
        
         Tbanimal animalB = new Tbanimal();
        try {
       
            
            
        utx.begin();
        
        // Parametro con un nombre en lugar de por posición 
       animalB=(Tbanimal)em.createQuery("SELECT a FROM Tbanimal a where a.id = :iden")
      .setParameter("iden", animal.getId())
      .getSingleResult();
      
       utx.commit();
       
       
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        
        
       return animalB;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }  
}