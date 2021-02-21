package rx;
/* loaded from: classes5.dex */
public final class Notification<T> {
    private static final Notification<Void> qyq = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qyo;
    private final Throwable qyp;
    private final T value;

    /* loaded from: classes5.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bW(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eMD() {
        return (Notification<T>) qyq;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qyp = th;
        this.qyo = kind;
    }

    public Throwable eME() {
        return this.qyp;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eMI() && this.value != null;
    }

    public boolean eMF() {
        return eKn() && this.qyp != null;
    }

    public Kind eMG() {
        return this.qyo;
    }

    public boolean eKn() {
        return eMG() == Kind.OnError;
    }

    public boolean eMH() {
        return eMG() == Kind.OnCompleted;
    }

    public boolean eMI() {
        return eMG() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eMG());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eMF()) {
            append.append(' ').append(eME().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eMG().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eMF()) {
            return (hashCode * 31) + eME().hashCode();
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
            if (notification.eMG() != eMG() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qyp != notification.qyp && (this.qyp == null || !this.qyp.equals(notification.qyp))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
