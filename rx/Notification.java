package rx;
/* loaded from: classes16.dex */
public final class Notification<T> {
    private static final Notification<Void> pUd = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind pUb;
    private final Throwable pUc;
    private final T value;

    /* loaded from: classes16.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> cc(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> S(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eBt() {
        return (Notification<T>) pUd;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.pUc = th;
        this.pUb = kind;
    }

    public Throwable eBu() {
        return this.pUc;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eBy() && this.value != null;
    }

    public boolean eBv() {
        return ewI() && this.pUc != null;
    }

    public Kind eBw() {
        return this.pUb;
    }

    public boolean ewI() {
        return eBw() == Kind.OnError;
    }

    public boolean eBx() {
        return eBw() == Kind.OnCompleted;
    }

    public boolean eBy() {
        return eBw() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eBw());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eBv()) {
            append.append(' ').append(eBu().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eBw().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eBv()) {
            return (hashCode * 31) + eBu().hashCode();
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
            if (notification.eBw() != eBw() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.pUc != notification.pUc && (this.pUc == null || !this.pUc.equals(notification.pUc))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
