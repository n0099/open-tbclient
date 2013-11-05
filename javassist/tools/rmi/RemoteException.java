package javassist.tools.rmi;
/* loaded from: classes.dex */
public class RemoteException extends RuntimeException {
    public RemoteException(String str) {
        super(str);
    }

    public RemoteException(Exception exc) {
        super("by " + exc.toString());
    }
}
