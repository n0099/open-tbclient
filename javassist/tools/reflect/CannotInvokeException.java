package javassist.tools.reflect;

import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class CannotInvokeException extends RuntimeException {
    private Throwable err;

    public Throwable getReason() {
        return this.err;
    }

    public CannotInvokeException(String str) {
        super(str);
        this.err = null;
    }

    public CannotInvokeException(InvocationTargetException invocationTargetException) {
        super("by " + invocationTargetException.getTargetException().toString());
        this.err = null;
        this.err = invocationTargetException.getTargetException();
    }

    public CannotInvokeException(IllegalAccessException illegalAccessException) {
        super("by " + illegalAccessException.toString());
        this.err = null;
        this.err = illegalAccessException;
    }

    public CannotInvokeException(ClassNotFoundException classNotFoundException) {
        super("by " + classNotFoundException.toString());
        this.err = null;
        this.err = classNotFoundException;
    }
}
