package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kxO = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kxM;
    private final Throwable kxN;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bl(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cPU() {
        return (Notification<T>) kxO;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kxN = th;
        this.kxM = kind;
    }

    public Throwable cPV() {
        return this.kxN;
    }

    public T getValue() {
        return this.value;
    }

    public boolean cPW() {
        return cQb() && this.value != null;
    }

    public boolean cPX() {
        return cPZ() && this.kxN != null;
    }

    public Kind cPY() {
        return this.kxM;
    }

    public boolean cPZ() {
        return cPY() == Kind.OnError;
    }

    public boolean cQa() {
        return cPY() == Kind.OnCompleted;
    }

    public boolean cQb() {
        return cPY() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cPY());
        if (cPW()) {
            append.append(' ').append(getValue());
        }
        if (cPX()) {
            append.append(' ').append(cPV().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cPY().hashCode();
        if (cPW()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cPX()) {
            return (hashCode * 31) + cPV().hashCode();
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
            if (notification.cPY() != cPY() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kxN != notification.kxN && (this.kxN == null || !this.kxN.equals(notification.kxN))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
