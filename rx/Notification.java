package rx;
/* loaded from: classes4.dex */
public final class Notification<T> {
    private static final Notification<Void> ndp = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind ndo;
    private final Throwable throwable;
    private final T value;

    /* loaded from: classes4.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bR(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> P(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dFV() {
        return (Notification<T>) ndp;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.ndo = kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dFZ() && this.value != null;
    }

    public boolean dFW() {
        return dDM() && this.throwable != null;
    }

    public Kind dFX() {
        return this.ndo;
    }

    public boolean dDM() {
        return dFX() == Kind.OnError;
    }

    public boolean dFY() {
        return dFX() == Kind.OnCompleted;
    }

    public boolean dFZ() {
        return dFX() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dFX());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dFW()) {
            append.append(' ').append(getThrowable().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dFX().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dFW()) {
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
            if (notification.dFX() != dFX() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.throwable != notification.throwable && (this.throwable == null || !this.throwable.equals(notification.throwable))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
