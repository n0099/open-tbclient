package rx;
/* loaded from: classes5.dex */
public final class Notification<T> {
    private static final Notification<Void> nMo = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind nMn;
    private final Throwable throwable;
    private final T value;

    /* loaded from: classes5.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bZ(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> R(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dMw() {
        return (Notification<T>) nMo;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.nMn = kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dMA() && this.value != null;
    }

    public boolean dMx() {
        return dHT() && this.throwable != null;
    }

    public Kind dMy() {
        return this.nMn;
    }

    public boolean dHT() {
        return dMy() == Kind.OnError;
    }

    public boolean dMz() {
        return dMy() == Kind.OnCompleted;
    }

    public boolean dMA() {
        return dMy() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dMy());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dMx()) {
            append.append(' ').append(getThrowable().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dMy().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dMx()) {
            return (hashCode * 31) + getThrowable().hashCode();
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
            if (notification.dMy() != dMy() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.throwable != notification.throwable && (this.throwable == null || !this.throwable.equals(notification.throwable))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
