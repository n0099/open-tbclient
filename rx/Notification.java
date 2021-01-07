package rx;
/* loaded from: classes15.dex */
public final class Notification<T> {
    private static final Notification<Void> qso = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qsm;
    private final Throwable qsn;
    private final T value;

    /* loaded from: classes15.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bW(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> V(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eNV() {
        return (Notification<T>) qso;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qsn = th;
        this.qsm = kind;
    }

    public Throwable eNW() {
        return this.qsn;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eOa() && this.value != null;
    }

    public boolean eNX() {
        return eLF() && this.qsn != null;
    }

    public Kind eNY() {
        return this.qsm;
    }

    public boolean eLF() {
        return eNY() == Kind.OnError;
    }

    public boolean eNZ() {
        return eNY() == Kind.OnCompleted;
    }

    public boolean eOa() {
        return eNY() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eNY());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eNX()) {
            append.append(' ').append(eNW().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eNY().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eNX()) {
            return (hashCode * 31) + eNW().hashCode();
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
            if (notification.eNY() != eNY() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qsn != notification.qsn && (this.qsn == null || !this.qsn.equals(notification.qsn))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
