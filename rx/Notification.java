package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> jUw = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind jUu;
    private final Throwable jUv;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bi(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> I(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cDs() {
        return (Notification<T>) jUw;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.jUv = th;
        this.jUu = kind;
    }

    public Throwable cDt() {
        return this.jUv;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cDy() && this.value != null;
    }

    public boolean cDu() {
        return cDw() && this.jUv != null;
    }

    public Kind cDv() {
        return this.jUu;
    }

    public boolean cDw() {
        return cDv() == Kind.OnError;
    }

    public boolean cDx() {
        return cDv() == Kind.OnCompleted;
    }

    public boolean cDy() {
        return cDv() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cDv());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cDu()) {
            append.append(' ').append(cDt().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cDv().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cDu()) {
            return (hashCode * 31) + cDt().hashCode();
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
            if (notification.cDv() != cDv() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.jUv != notification.jUv && (this.jUv == null || !this.jUv.equals(notification.jUv))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
