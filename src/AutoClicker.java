import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AutoClicker implements KeyListener {
    // properties
    private Robot robot;
    private int delay;
    private AWTEventListener listener;
    private boolean active;

    // constructors
    public AutoClicker() {
        active = false;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        listener = new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                KeyEvent evt = (KeyEvent) event;
                if(evt.getKeyChar() == 'r') {
                    active = true;
                } else if(evt.getKeyChar() == 't') {
                    active = false;
                }
            }
        };
    }

    // methods
    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void click() {
        robot.keyPress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.keyRelease(InputEvent.BUTTON1_MASK);
        robot.delay(delay);
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
