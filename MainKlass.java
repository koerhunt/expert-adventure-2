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
public class MainKlass implements GLEventListener{
    
    GL2 gl;
    
    
    public MainKlass(){
        
    }
    
    public static void main(String args[]){
        
        //Version de OpenGL a utilizar
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        
        //Capacidades disponibles del perfil
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        
        MainKlass mk = new MainKlass();
                
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
        gl.glClearColor(1f,1f,1f,1f);
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
        
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(0,0,0);
        
        //base cuadrada
        gl.glVertex3f(-.5f,.12f,0);
        gl.glVertex3f(-.5f,-.25f,0);
        
        gl.glVertex3f(.5f,.12f,0);
        gl.glVertex3f(.5f,-.25f,0);
        
        gl.glVertex3f(-.5f,-.25f,0);
        gl.glVertex3f(.5f,-.25f,0);
        
        gl.glVertex3f(-.5f,.12f,0);
        gl.glVertex3f(.5f,.12f,0);
        
        //cabina
        gl.glVertex3f(-.3f,.12f,0);
        gl.glVertex3f(-.3f,.3f,0);
        
        gl.glVertex3f(.3f,.12f,0);
        gl.glVertex3f(.3f,.3f,0);
        
        gl.glVertex3f(-.3f,.3f,0); 
        gl.glVertex3f(.3f,.3f,0);
        
        drawCircle(gl,-.25f,-.25f,180);
        drawCircle(gl,.25f,-.25f,180);

        gl.glEnd();
        
    }
    
    //It is called by the object of GLAutoDrawable interface during the first repaint afeter the component has been resized.
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
    public void drawCircle(GL2 gl,float xc,float yc,int gi){
        for(double alpha = gi; alpha<360;alpha+=5){
            float dx = (float) ((.15)*Math.cos(alpha));
            float dy = (float) ((.15)*Math.sin(alpha));
            gl.glVertex3f(xc+dx,yc+dy,0);
            dx = (float) ((.15)*Math.cos(alpha+1));
            dy = (float) ((.15)*Math.sin(alpha+1));
            gl.glVertex3f(xc+dx,yc+dy,0);
        }  
    }
    
}
