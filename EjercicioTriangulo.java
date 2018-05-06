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



public class EjercicioTriangulo implements GLEventListener{
    
    GL2 gl;
    
    
    public EjercicioTriangulo(){
        
    }
    
    public static void main(String args[]){
        
        //Version de OpenGL a utilizar
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        
        //Capacidades disponibles del perfil
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        
        EjercicioTriangulo mk = new EjercicioTriangulo();
                
        glcanvas.addGLEventListener(mk);
        glcanvas.setSize(400, 400);
        
        //final Frame frame = new Frame("Basic Frame");
        final JFrame frame = new JFrame("Basic Frame ej4");
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
        
        
        gl.glPushMatrix();
        
        gl.glScalef(.5f, .5f, .5f);        
        
        //Dibuja ciculo relleno con lineas del centro a cada
        //punto de la circuferencias
        gl.glBegin(GL2.GL_TRIANGLES);
        
        gl.glColor3f(1,0,0);
        gl.glVertex3f(0f,0f,0f);
        
        gl.glColor3f(0,1,0);
        gl.glVertex3f(.50f,0f,0f);
        
        gl.glColor3f(0,0,1);
        gl.glVertex3f(.50f,.50f,0f);
        
        
        gl.glEnd();
        
        gl.glPopMatrix();
    }
    
    //It is called by the object of GLAutoDrawable interface during the first repaint afeter the component has been resized.
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
  
    
    
}
