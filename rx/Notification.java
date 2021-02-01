package rx;
/* loaded from: classes5.dex */
public final class Notification<T> {
    private static final Notification<Void> qxQ = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qxO;
    private final Throwable qxP;
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

    public static <T> Notification<T> eMv() {
        return (Notification<T>) qxQ;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qxP = th;
        this.qxO = kind;
    }

    public Throwable eMw() {
        return this.qxP;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eMA() && this.value != null;
    }

    public boolean eMx() {
        return eKf() && this.qxP != null;
    }

    public Kind eMy() {
        return this.qxO;
    }

    public boolean eKf() {
        return eMy() == Kind.OnError;
    }

    public boolean eMz() {
        return eMy() == Kind.OnCompleted;
    }

    public boolean eMA() {
        return eMy() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eMy());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eMx()) {
            append.append(' ').append(eMw().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eMy().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eMx()) {
            return (hashCode * 31) + eMw().hashCode();
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
            if (notification.eMy() != eMy() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qxP != notification.qxP && (this.qxP == null || !this.qxP.equals(notification.qxP))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
