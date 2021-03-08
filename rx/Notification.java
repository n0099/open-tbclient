package rx;
/* loaded from: classes4.dex */
public final class Notification<T> {
    private static final Notification<Void> qyS = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qyQ;
    private final Throwable qyR;
    private final T value;

    /* loaded from: classes4.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bX(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eMl() {
        return (Notification<T>) qyS;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qyR = th;
        this.qyQ = kind;
    }

    public Throwable eMm() {
        return this.qyR;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eMq() && this.value != null;
    }

    public boolean eMn() {
        return eJV() && this.qyR != null;
    }

    public Kind eMo() {
        return this.qyQ;
    }

    public boolean eJV() {
        return eMo() == Kind.OnError;
    }

    public boolean eMp() {
        return eMo() == Kind.OnCompleted;
    }

    public boolean eMq() {
        return eMo() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eMo());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eMn()) {
            append.append(' ').append(eMm().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eMo().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eMn()) {
            return (hashCode * 31) + eMm().hashCode();
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
            if (notification.eMo() != eMo() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qyR != notification.qyR && (this.qyR == null || !this.qyR.equals(notification.qyR))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
