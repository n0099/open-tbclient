package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> nNi = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind nNh;
    private final Throwable throwable;
    private final T value;

    /* loaded from: classes6.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> ca(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> Q(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dNL() {
        return (Notification<T>) nNi;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.nNh = kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dNP() && this.value != null;
    }

    public boolean dNM() {
        return dJc() && this.throwable != null;
    }

    public Kind dNN() {
        return this.nNh;
    }

    public boolean dJc() {
        return dNN() == Kind.OnError;
    }

    public boolean dNO() {
        return dNN() == Kind.OnCompleted;
    }

    public boolean dNP() {
        return dNN() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dNN());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dNM()) {
            append.append(' ').append(getThrowable().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dNN().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dNM()) {
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
            if (notification.dNN() != dNN() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.throwable != notification.throwable && (this.throwable == null || !this.throwable.equals(notification.throwable))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
