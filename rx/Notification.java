package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> niO = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind niM;
    private final Throwable niN;
    private final T value;

    /* loaded from: classes6.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bJ(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dHn() {
        return (Notification<T>) niO;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.niN = th;
        this.niM = kind;
    }

    public Throwable dHo() {
        return this.niN;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dHs() && this.value != null;
    }

    public boolean dHp() {
        return dCD() && this.niN != null;
    }

    public Kind dHq() {
        return this.niM;
    }

    public boolean dCD() {
        return dHq() == Kind.OnError;
    }

    public boolean dHr() {
        return dHq() == Kind.OnCompleted;
    }

    public boolean dHs() {
        return dHq() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dHq());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dHp()) {
            append.append(' ').append(dHo().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dHq().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dHp()) {
            return (hashCode * 31) + dHo().hashCode();
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
            if (notification.dHq() != dHq() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.niN != notification.niN && (this.niN == null || !this.niN.equals(notification.niN))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
