/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(urlPatterns = {"/Personalidad"})
public class Personalidad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Personalidad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Personalidad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);  INITIAL CODE
        String CONTENT_TYPE = "text/html";
        response.setContentType(CONTENT_TYPE);  //let know that content will be in HTML
        ServletOutputStream out = response.getOutputStream();
        //retrieve variables
        String name = request.getParameter("name");
        String imageChosen = request.getParameter("image_chosen");
        
        String body;
        
        if (name.equals("")){
            body =  "            <h1>No ha escrito su nombre</h1>" +
                    "            <a href=\"test.html\"> Volver a realizar el test </a>";                    
        }
        else if (imageChosen == null){   
            body = "            <h1>Imagen no escogida</h1>" +
                   "            <a href=\"test.html\"> Volver a realizar el test </a>";
        }
        else{
            String personality = getPersonality(imageChosen);
            body =  "            <h2>Resultad de personalidad:<br></h2>"+
                    "            Hola " + name +", despues de realizar el test podemos aventurarnos a decir que su<br>" +
                    "            personalidad es la siguiente: <br><i>" + personality + "</i><br>" +
                    "            <a href=\"test.html\"> Volver a realizar el test </a>";
        }
            // open blank html file  via webpage: http://pojo.sodhanalibrary.com/ConvertToVariable
            
            
        String myvar = "<html>"+
        "    <head>"+
        "        <title>TODO supply a title</title>"+
        "        <meta charset=\"UTF-8\">"+
        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
        "    </head>"+
        "    <body bgcolor = \"#FFE4C4\">"+
        "        <center><div>"+
        body +
        "        </div></center>"+
        "    </body>"+
        "</html>";

        out.println(myvar);        
        
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

    
    String getPersonality(String imageChosen)
    {
        switch(imageChosen){
            case "image1":
                return "<img src=\"i1.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +      // doing \" to escape character "
                        "Te desentiendes de ti mismo y de tu entorno, en mayor medida que la mayoria<br>" +
                        "de las personas. Detestas superficialidades, prefieres permanecer aislado que sufrir el<br>" +
                        "impacto de un dialogo esteril. Pero las relaciones con amigos son intensas y profundas, lo<br>" +
                        "que te proporciona tranquilidad y armonia espiritual indispensable para que te sientas<br>" +
                        "bien. No te preocupas por el aislamiento, aunque sea durante largos periodos de tiempo. Es<br>" +
                        "una circunstancia que no te desagrada.<br>";
            case "image2":
                return "<img src=\"i2.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Exiges libertad y vida sin compromiso. Determinas tu destino. Tienes talento<br>" +
                        "artistico en el trabajo y en el ocio. Algunas veces, tu impulso por la libertad te lleva a<br>" +
                        "proceder de manera opuesta a lo que se espera de ti. Tu estilo de vida es altamente<br>" +
                        "individualista. Jamas imitas ciegamente lo que es convencional, al contrario, tratas de vivir<br>" +
                        "de acuerdo con tus propias ideas y convicciones, aunque esto signifique nadar contra<br>" +
                        "corriente.";
            case "image3":
                return "<img src=\"i3.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Estas muy inclinada a correr ciertos riesgos y asumir importantes compromisos a<br>" +
                        "cambio de tareas variadas e interesantes. En contraste, actividades rutinarias tienden a<br>" +
                        "ejercer efecto paralizante sobre ti. Lo que mas aprecias es desempenar un papel activo en<br>" +
                        "los acontecimientos. Procediendo asi, tu capacidad de iniciativa se torna significativamente<br>" +
                        "acentuada.";
            case "image4":
                return "<img src=\"i4.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Valoras el amor y un estilo de vida simple y sin complicaciones. Los que te<br>" +
                        "rodean te admiran porque tienes ambos pies firmemente plantados en el suelo y asi se<br>" +
                        "tornan dependientes de ti. Ofreces espacio y seguridad a los amigos íntimos. Tus dotes son<br>" +
                        "consideradas humanas y calidas. Rechazas lo trivial y extravagante. Tiendes a ser esceptico<br>" +
                        "en relación a fantasías y modismos. Tu indumentaria tiene que ser practica y discretamente<br>" +
                        "elegante.";
            case "image5":
                return "<img src=\"i5.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Tienes pleno dominio de la vida y depositas menos fe en la suerte que en tus<br>" +
                        "actos. Solucionas problemas de modo simple y practico. Tienes vision realista de los<br>" +
                        "acontecimientos cotidianos y los manipulas sin dudas. Gran parte de la responsabilidad en<br>" +
                        "el trabajo te es conferida porque todos saben que pueden depender de ti. Tu pronunciada<br>" +
                        "fuerza de voluntad transmite auto-confianza a los otros. Jamas te sentiras totalmente<br>" +
                        "satisfecho en cuanto no hayas realizado tus ideas.";
            case "image6":
                return "<img src=\"i6.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Menosprecias formalidades sin causar dificultades a otros. Tus amistadas son<br>" +
                        "hechas facilmente, pero aprecias la privacidad y la independencia. Gustas distanciarte de<br>" +
                        "todo y de todos, de tiempo en tiempo para contemplar el significado de la vida y alegrarte<br>" +
                        "contigo mismo. Necesitas espacio, y por eso te refugias en lugares solitarios y bonitos.<br>" +
                        "Pero, no eres una persona solitaria. Estas en paz contigo mismo y con el mundo, y gustas de<br>" +
                        "la vida y de los que ella tiene para ofrecerte.";
            case "image7":
                return "<img src=\"i7.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Amas una vida libre y espontanea, y tratas de disfrutarla en toda su plenitud, de<br>" +
                        "acuerdo con el refran: \"solo se vive una vez\". Te muestras interesado y abierto a todo lo<br>" +
                        "que es nuevo; los cambios alimentan tu espiritu. Nada es peor que cuando te sientes<br>" +
                        "privado de tu libertad. Vives tu ambiente como algo versatil y siempre en condiciones de<br>" +
                        "brindarte con una sorpresa diaria.";
            case "image8":
                return "<img src=\"i8.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Eres muy sensible. Rechazas analizar los acontecimientos solamente con un<br>" +
                        "punto de vista frio y racional. Solo te importa lo que los sentimientos te dicen. Como<br>" +
                        "efecto, avalas como significativo tener anhelos en la vida. Rechazas a quien desprecia el<br>" +
                        "romanticismo y te dejas guiar solamente por la racionalidad. Rechazas cualquier limitacion<br>" +
                        "a la rica variedad de tus impulsos y emociones.";
            case "image9":
                return "<img src=\"i9.png\" alt=\"HTML5 Icon\" style=\"width:128px;height:128px;\"><br>" +
                        "Tu sensibilidad representa lo que es duradero y de alta calidad. En consecuencia,<br>" +
                        "gustas de rodearte de pequenas preciosidades, que descubres donde quieres que sean<br>" +
                        "ignoradas por otros. Siendo asi, la cultura desempena un papel especial en tu vida. Tienes<br>" +
                        "un estilo personal elegante y exhaustivo, libre de las fantasias de los modismos. Lo ideal,<br>" +
                        "sobre lo cual basas tu vida, es el placer asociado a la cultura. Valorizas un cierto nivel de<br>" +
                        "cultura en las personas que quien te asocias.";
            default:
                return "";
        }    
    }
}
