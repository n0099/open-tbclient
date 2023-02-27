package rx.exceptions;
/* loaded from: classes9.dex */
public final class OnCompletedFailedException extends RuntimeException {
    public static final long serialVersionUID = 8622579378868820554L;

    public OnCompletedFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public OnCompletedFailedException(Throwable th) {
        super(th == null ? new NullPointerException() : th);
    }
}
