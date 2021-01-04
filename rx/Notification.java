package rx;
/* loaded from: classes15.dex */
public final class Notification<T> {
    private static final Notification<Void> qqG = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qqE;
    private final Throwable qqF;
    private final T value;

    /* loaded from: classes15.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bV(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> V(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eNr() {
        return (Notification<T>) qqG;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qqF = th;
        this.qqE = kind;
    }

    public Throwable eNs() {
        return this.qqF;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eNw() && this.value != null;
    }

    public boolean eNt() {
        return eLb() && this.qqF != null;
    }

    public Kind eNu() {
        return this.qqE;
    }

    public boolean eLb() {
        return eNu() == Kind.OnError;
    }

    public boolean eNv() {
        return eNu() == Kind.OnCompleted;
    }

    public boolean eNw() {
        return eNu() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eNu());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eNt()) {
            append.append(' ').append(eNs().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eNu().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eNt()) {
            return (hashCode * 31) + eNs().hashCode();
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
            if (notification.eNu() != eNu() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qqF != notification.qqF && (this.qqF == null || !this.qqF.equals(notification.qqF))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
