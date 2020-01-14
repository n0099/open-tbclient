package rx;
/* loaded from: classes5.dex */
public final class Notification<T> {
    private static final Notification<Void> nMt = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind nMs;
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

    public static <T> Notification<T> dMy() {
        return (Notification<T>) nMt;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.nMs = kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dMC() && this.value != null;
    }

    public boolean dMz() {
        return dHV() && this.throwable != null;
    }

    public Kind dMA() {
        return this.nMs;
    }

    public boolean dHV() {
        return dMA() == Kind.OnError;
    }

    public boolean dMB() {
        return dMA() == Kind.OnCompleted;
    }

    public boolean dMC() {
        return dMA() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dMA());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dMz()) {
            append.append(' ').append(getThrowable().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dMA().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dMz()) {
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
            if (notification.dMA() != dMA() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.throwable != notification.throwable && (this.throwable == null || !this.throwable.equals(notification.throwable))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
