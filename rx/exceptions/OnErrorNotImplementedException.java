package rx.exceptions;
/* loaded from: classes8.dex */
public class OnErrorNotImplementedException extends RuntimeException {
    public static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public OnErrorNotImplementedException(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
