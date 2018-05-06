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

//Cambiar las dimenciones del entorno
//GLFrustum::SetOrthographic(GLfloat xMin, GLfloat xMax, GLfloat yMin,
//GLfloat yMax, GLfloat zMin, GLfloat zMax);

//Cambiar la perspectiva 
//GLFrustum::SetPerspective(float fFov, float fAspect, float fNear, float fFar);


//shaderManager.InitializeStockShaders();

public class EjercicioRotacion implements GLEventListener{
    
    GL2 gl;
    static float rotate = 0f;
    FPSAnimator fps;
    
    float rx  = 0, ry = 0,rz = 0;
    float tx =0, ty = 0;
    
    float radio = .01f;
    
    
    public EjercicioRotacion(){
        
    }
    
    public static void main(String args[]){
        
        //Version de OpenGL a utilizar
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        
        //Capacidades disponibles del perfil
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        
        EjercicioRotacion mk = new EjercicioRotacion();
                
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
        
        if(fps==null){
            fps = new FPSAnimator(glad,60);
            fps.start();
        }
        
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
        
        //Asignar color de fondo
        gl.glColor3d(1,1,1);   
        
//        gl.glPushMatrix();
        
        //Dibujar Objeto
        gl.glBegin(GL2.GL_LINES);
        
        //cara
        calcularCircunferencia(gl,0,0);
        
        //ojos
        gl.glVertex3f(0.020f,.05f,0);
        gl.glVertex3f(0.020f,0,0);
        gl.glVertex3f(-0.020f,.05f,0);
        gl.glVertex3f(-0.020f,0,0);
        
        gl.glEnd();
        
        rz+=0.1;
        radio+=0.001;
        
        rx+=0.005;
        
//        gl.glPushMatrix();
       
        //Espiral logaritmica
        tx = (float) (radio*.1*Math.cos(rz));
        ty = (float) (radio*.1*Math.sin(rz));
        
        gl.glTranslatef(tx,ty,0f);
        
        gl.glRotatef(rx,0f,0f,1.0f);
        
        
//        gl.glPopMatrix();


    }
    
    //It is called by the object of GLAutoDrawable interface during the first repaint afeter the component has been resized.
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }
    
    public void calcularCircunferencia(GL2 gl,float xc,float yc){
        for(double alpha = 0; alpha<360;alpha+=1){
            float dx = (float) ((.1)*Math.cos(alpha));
            float dy = (float) ((.1)*Math.sin(alpha));
            gl.glVertex3f(xc+dx,yc+dy,0);
        }  
    }
  
    
    
}
