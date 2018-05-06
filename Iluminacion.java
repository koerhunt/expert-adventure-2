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


//tipos de luces
//gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, light_ambient, 0);
//gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, light_diffuse, 0);
//gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, light_specular, 0);
//gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light_position, 0);

/**
 *
 * @author shikami
 */
public class Iluminacion implements GLEventListener{
    
    GL2 gl;
    
    
    public Iluminacion(){
        
    }
    
    public static void main(String args[]){
        
        //Version de OpenGL a utilizar
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        
        //Capacidades disponibles del perfil
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        
        Iluminacion mk = new Iluminacion();
                
        glcanvas.addGLEventListener(mk);
        glcanvas.setSize(400, 400);
        
        //final Frame frame = new Frame("Basic Frame");
        final JFrame frame = new JFrame("Basic Frame");
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
        gl.glClearColor(0f,0f,0f,1f);
        
        gl.glEnable(GL2.GL_LIGHTING); 
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_NORMALIZE); 
        
        float[] ambientLight = { 0f, 1f, 0.f,0f };  // weak RED ambient 
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0); 
        
        
//        float parampos[] = {0f,.8f,1f,0};
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, parampos,0);
        
        FPSAnimator anim = new FPSAnimator(glad ,160);
        anim.start();
        
//        gl.glViewport( 1, 0, 1, 1 );

        //canvas scale
        gl.glOrtho(-5, 5, -5, 5, -5, 5);
        gl.glTranslatef(0,0,0); // inverse of camera's location
        
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
        
           gl.glFlush();
        
        // Clear the drawing area
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        
        gl.glColor3d(1,1,1);
        
        //Dibujar Objeto
        gl.glBegin(GL2.GL_POLYGON);
        
        gl.glVertex3f(0.2f,.4f,0);
        gl.glVertex3f(-0.2f,.4f,0);
        gl.glVertex3f(-0.4f,0,0);
        gl.glVertex3f(-0.2f,-.4f,0);
        gl.glVertex3f(0.2f,-.4f,0);
        gl.glVertex3f(0.4f,0,0);
        
        gl.glEnd();
        
        
        float parampos[] = {0f,0f,.1f,0};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, parampos,0);

        
        gl.glRotatef(2,0f,1f,0f);
        
        
    }
    
    //It is called by the object of GLAutoDrawable interface during the first repaint afeter the component has been resized.
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
    
    
}
