package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> oaM = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind oaK;
    private final Throwable oaL;
    private final T value;

    /* loaded from: classes6.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bR(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dTY() {
        return (Notification<T>) oaM;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.oaL = th;
        this.oaK = kind;
    }

    public Throwable dTZ() {
        return this.oaL;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dUd() && this.value != null;
    }

    public boolean dUa() {
        return dPo() && this.oaL != null;
    }

    public Kind dUb() {
        return this.oaK;
    }

    public boolean dPo() {
        return dUb() == Kind.OnError;
    }

    public boolean dUc() {
        return dUb() == Kind.OnCompleted;
    }

    public boolean dUd() {
        return dUb() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dUb());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dUa()) {
            append.append(' ').append(dTZ().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dUb().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dUa()) {
            return (hashCode * 31) + dTZ().hashCode();
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
            if (notification.dUb() != dUb() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.oaL != notification.oaL && (this.oaL == null || !this.oaL.equals(notification.oaL))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
