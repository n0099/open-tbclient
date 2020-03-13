package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> nNv = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind nNu;
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

    public static <T> Notification<T> dNO() {
        return (Notification<T>) nNv;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.nNu = kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dNS() && this.value != null;
    }

    public boolean dNP() {
        return dJf() && this.throwable != null;
    }

    public Kind dNQ() {
        return this.nNu;
    }

    public boolean dJf() {
        return dNQ() == Kind.OnError;
    }

    public boolean dNR() {
        return dNQ() == Kind.OnCompleted;
    }

    public boolean dNS() {
        return dNQ() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dNQ());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dNP()) {
            append.append(' ').append(getThrowable().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dNQ().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dNP()) {
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
            if (notification.dNQ() != dNQ() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.throwable != notification.throwable && (this.throwable == null || !this.throwable.equals(notification.throwable))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
