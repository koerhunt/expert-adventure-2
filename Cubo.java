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
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.JFrame;

/**
 *
 * @author shikami
 */


//shaderManager.InitializeStockShaders();

public class Cubo implements GLEventListener{
    
    GL2 gl;
    FPSAnimator fps;    
    
    public Cubo(){
        
    }
    
    public static void main(String args[]){
        
        //Version de OpenGL a utilizar
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        
        //Capacidades disponibles del perfil
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        
        Cubo mk = new Cubo();
                
        glcanvas.addGLEventListener(mk);
        glcanvas.setSize(400, 400);
        
        //final Frame frame = new Frame("Basic Frame");
        final JFrame frame = new JFrame("Basic Frame rotacion");
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
        
//        if(fps==null){
//            fps = new FPSAnimator(glad,1);
//            fps.start();
//        }
        
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
        
        //Obtener GL
        gl = glad.getGL().getGL2();
        
        //Limpiar graficos
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glFlush();
       
//        gl.glRotatef(45,-.5f,-0f,0f);
        gl.glRotatef(-45,-.5f,-.5f,0f);
//        gl.glRotatef(-45,0f,0f,-.5f);

      
      //TRASERA
      gl.glBegin(GL2.GL_POLYGON);
      gl.glColor3f( .5f,1f,1f );
      gl.glVertex3f( 0.5f, -0.5f, -0.5f );
      gl.glVertex3f( -0.5f, -0.5f, -0.5f );
      gl.glVertex3f( -0.5f, 0.5f, -0.5f );
      gl.glVertex3f( 0.5f, 0.5f, -0.5f );
      gl.glEnd();

      //ABAJO verde
      gl.glBegin(GL2.GL_POLYGON);
      gl.glColor3f( 0f,1f,0f );
      gl.glVertex3f( 0.5f, -0.5f, 0.5f );
      gl.glVertex3f( -0.5f, -0.5f, 0.5f );
      gl.glVertex3f( -0.5f, -0.5f, -0.5f );
      gl.glVertex3f( 0.5f, -0.5f, -0.5f );
      gl.glEnd();

      gl.glBegin(GL2.GL_POLYGON);
      gl.glColor3f( 1f,0f,1f ); 
      gl.glVertex3f( -0.5f, 0.5f, 0.5f );
      gl.glVertex3f( -0.5f, 0.5f, -0.5f );
      gl.glVertex3f( -0.5f, -0.5f, -0.5f );
      gl.glVertex3f( -0.5f, -0.5f, 0.5f );
      gl.glEnd();

      gl.glBegin(GL2.GL_POLYGON);
      gl.glColor3f( .87f,.35f,.1f );
      gl.glVertex3f( 0.5f, 0.5f, -0.5f );
      gl.glVertex3f( 0.5f, 0.5f, 0.5f );
      gl.glVertex3f( 0.5f, -0.5f, 0.5f );
      gl.glVertex3f( 0.5f, -0.5f, -0.5f );
      gl.glEnd();
      
       
      //Arriba amarilla
      gl.glBegin(GL2.GL_POLYGON);
      gl.glColor3f(1f,1f,0f);
      gl.glVertex3f(0.5f, 0.5f, -0.5f);
      gl.glVertex3f( -0.5f, 0.5f, -0.5f);
      gl.glVertex3f( -0.5f, 0.5f, 0.5f );
      gl.glVertex3f( 0.5f, 0.5f, 0.50f );
      gl.glEnd();
      
      //FRONTAL
      gl.glBegin(GL2.GL_POLYGON);
      gl.glColor3f( 0f,0f,1f );
      gl.glVertex3f( 0.5f, 0.5f, 0.5f );
      gl.glVertex3f( -0.5f, 0.5f, 0.5f );
      gl.glVertex3f( -0.5f, -0.5f, 0.5f );
      gl.glVertex3f( 0.5f, -0.5f, 0.5f );
      gl.glEnd();
        
        
//        gl.glPopMatrix();


    }
    
    //It is called by the object of GLAutoDrawable interface during the first repaint afeter the component has been resized.
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
    
    
}
