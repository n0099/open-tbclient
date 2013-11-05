package javassist.tools.reflect;
/* loaded from: classes.dex */
public class CannotCreateException extends Exception {
    public CannotCreateException(String str) {
        super(str);
    }

    public CannotCreateException(Exception exc) {
        super("by " + exc.toString());
    }
}
