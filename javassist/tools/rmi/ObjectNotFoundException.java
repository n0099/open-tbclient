package javassist.tools.rmi;
/* loaded from: classes.dex */
public class ObjectNotFoundException extends Exception {
    public ObjectNotFoundException(String str) {
        super(str + " is not exported");
    }

    public ObjectNotFoundException(String str, Exception exc) {
        super(str + " because of " + exc.toString());
    }
}
