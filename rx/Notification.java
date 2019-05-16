package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kmM = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kmK;
    private final Throwable kmL;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bk(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cKY() {
        return (Notification<T>) kmM;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kmL = th;
        this.kmK = kind;
    }

    public Throwable cKZ() {
        return this.kmL;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cLe() && this.value != null;
    }

    public boolean cLa() {
        return cLc() && this.kmL != null;
    }

    public Kind cLb() {
        return this.kmK;
    }

    public boolean cLc() {
        return cLb() == Kind.OnError;
    }

    public boolean cLd() {
        return cLb() == Kind.OnCompleted;
    }

    public boolean cLe() {
        return cLb() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cLb());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cLa()) {
            append.append(' ').append(cKZ().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cLb().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cLa()) {
            return (hashCode * 31) + cKZ().hashCode();
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
            if (notification.cLb() != cLb() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kmL != notification.kmL && (this.kmL == null || !this.kmL.equals(notification.kmL))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
