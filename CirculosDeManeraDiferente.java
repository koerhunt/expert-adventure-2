/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opengl_java_awt;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
//import javax.media.opengl;

import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

/**
 *
 * @author shikami
 */

//Cambiar las dimenciones del entorno
//GLFrustum::SetOrthographic(GLfloat xMin, GLfloat xMax, GLfloat yMin,
//GLfloat yMax, GLfloat zMin, GLfloat zMax);

//Cambiar la perspectiva 
//GLFrustum::SetPerspective(float fFov, float fAspect, float fNear, float fFar);


//shaderManager.InitializeStockShaders();



public class CirculosDeManeraDiferente implements GLEventListener{
    
    GL2 gl;
    
    
    public CirculosDeManeraDiferente(){
        
    }
    
    public static void main(String args[]){
        
        //Version de OpenGL a utilizar
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        
        //Capacidades disponibles del perfil
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        
        CirculosDeManeraDiferente mk = new CirculosDeManeraDiferente();
                
        glcanvas.addGLEventListener(mk);
        glcanvas.setSize(400, 400);
        
        //final Frame frame = new Frame("Basic Frame");
        final JFrame frame = new JFrame("Basic Frame ej3");
        //final GLJPanel frame = new GLJPanel();
        
        frame.add(glcanvas);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    //it is called by the object of GLAUTODRAWABLE interface inmediately after the OpenGL context
    //is initialized
    @Override
    public void init(GLAutoDrawable glad) {
        
        
        
        //Cambia color del fondo
        gl = glad.getGL().getGL2();
        gl.glClearColor(0,0,0,0);
    }
    
    
    //This method signals the listener to permorfm the release of all OpenGl resources per each GLContext, such as memory
    //buffers and GLSL programs
    @Override
    public void dispose(GLAutoDrawable glad) {
    }
    
    
    //It is called by the object of GLAutoDrawable interface to initiate Opengl rendering by the client.
    //This method contains the login used to draw graphical elements using OpenGL API.
    @Override
    public void display(GLAutoDrawable glad) {
        gl = glad.getGL().getGL2();
        
        gl.glColor3d(1,1,1);        
        
        //Dibuja ciculo relleno con lineas del centro a cada
        //punto de la circuferencias
        gl.glBegin(GL2.GL_TRIANGLES);
        calcularCircunferenciaT(gl,-0.5f,0.5f);
        gl.glEnd();
        
        //Dibuja circulo relleno por medio de lineas
        gl.glBegin(GL2.GL_POLYGON);
        calcularCircunferencia(gl,-0.5f,-0.5f);
        gl.glEnd();
        
        //Dibuja la circunferencia por medio de lineas
        gl.glBegin(GL2.GL_LINES);
        calcularCircunferencia(gl,0.5f,0.5f);
        gl.glEnd();
        
        //Dibuja la circunferencia por medio de lineas
        gl.glBegin(GL2.GL_LINE_LOOP     );
        calcularCircunferencia(gl,0.5f,-0.5f);
        gl.glEnd();
        
        
    }
    
    //It is called by the object of GLAutoDrawable interface during the first repaint afeter the component has been resized.
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
    // calcula solo un punto
    public void calcularCircunferencia(GL2 gl,float xc,float yc){
        for(double alpha = 0; alpha<360;alpha+=1){
            float dx = (float) ((.1)*Math.cos(alpha));
            float dy = (float) ((.1)*Math.sin(alpha));
            gl.glVertex3f(xc+dx,yc+dy,0);
        }  
    }
            
    //dibuja con triangulos (calcula tres puntos)
    public void calcularCircunferenciaT(GL2 gl,float xc,float yc){
        for(double alpha = 0; alpha<360;alpha+=1){
            float dx = (float) ((.1)*Math.cos(alpha));
            float dy = (float) ((.1)*Math.sin(alpha));
            gl.glVertex3f(xc,yc,0);
            gl.glVertex3f(xc+dx,yc+dy,0);
            dx = (float) ((.1)*Math.cos(alpha+30));
            dy = (float) ((.1)*Math.sin(alpha+30));
            gl.glVertex3f(xc+dx,yc+dy,0);
            
        }  
    }
    
    
}
