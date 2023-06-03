package rx.exceptions;
/* loaded from: classes2.dex */
public class OnErrorNotImplementedException extends RuntimeException {
    public static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OnErrorNotImplementedException(Throwable th) {
        super(r0, th == null ? new NullPointerException() : th);
        String str;
        if (th != null) {
            str = th.getMessage();
        } else {
            str = null;
        }
    }
}
