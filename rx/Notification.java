package rx;
/* loaded from: classes7.dex */
public final class Notification<T> {
    private static final Notification<Void> oNu = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind oNs;
    private final Throwable oNt;
    private final T value;

    /* loaded from: classes7.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bV(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> S(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> enJ() {
        return (Notification<T>) oNu;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.oNt = th;
        this.oNs = kind;
    }

    public Throwable enK() {
        return this.oNt;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return enO() && this.value != null;
    }

    public boolean enL() {
        return eiX() && this.oNt != null;
    }

    public Kind enM() {
        return this.oNs;
    }

    public boolean eiX() {
        return enM() == Kind.OnError;
    }

    public boolean enN() {
        return enM() == Kind.OnCompleted;
    }

    public boolean enO() {
        return enM() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(enM());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (enL()) {
            append.append(' ').append(enK().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = enM().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (enL()) {
            return (hashCode * 31) + enK().hashCode();
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
            if (notification.enM() != enM() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.oNt != notification.oNt && (this.oNt == null || !this.oNt.equals(notification.oNt))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
