package rx.exceptions;
/* loaded from: classes7.dex */
public final class UnsubscribeFailedException extends RuntimeException {
    public static final long serialVersionUID = 4594672310593167598L;

    public UnsubscribeFailedException(Throwable th) {
        super(th == null ? new NullPointerException() : th);
    }

    public UnsubscribeFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }
}
