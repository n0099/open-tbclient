package rx.exceptions;
/* loaded from: classes9.dex */
public class OnErrorFailedException extends RuntimeException {
    public static final long serialVersionUID = -419289748403337611L;

    public OnErrorFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OnErrorFailedException(Throwable th) {
        super(r0, th == null ? new NullPointerException() : th);
        String str;
        if (th != null) {
            str = th.getMessage();
        } else {
            str = null;
        }
    }
}
