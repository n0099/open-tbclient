package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> iAS = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind iAQ;
    private final Throwable iAR;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> aV(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> ccL() {
        return (Notification<T>) iAS;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.iAR = th;
        this.iAQ = kind;
    }

    public Throwable ccM() {
        return this.iAR;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return ccR() && this.value != null;
    }

    public boolean ccN() {
        return ccP() && this.iAR != null;
    }

    public Kind ccO() {
        return this.iAQ;
    }

    public boolean ccP() {
        return ccO() == Kind.OnError;
    }

    public boolean ccQ() {
        return ccO() == Kind.OnCompleted;
    }

    public boolean ccR() {
        return ccO() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(ccO());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (ccN()) {
            append.append(' ').append(ccM().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = ccO().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (ccN()) {
            return (hashCode * 31) + ccM().hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() == getClass()) {
            Notification notification = (Notification) obj;
            if (notification.ccO() != ccO() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.iAR != notification.iAR && (this.iAR == null || !this.iAR.equals(notification.iAR))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
