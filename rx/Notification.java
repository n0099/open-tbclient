package rx;
/* loaded from: classes14.dex */
public final class Notification<T> {
    private static final Notification<Void> qnN = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qnL;
    private final Throwable qnM;
    private final T value;

    /* loaded from: classes14.dex */
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

    public static <T> Notification<T> eKf() {
        return (Notification<T>) qnN;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qnM = th;
        this.qnL = kind;
    }

    public Throwable eKg() {
        return this.qnM;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eKk() && this.value != null;
    }

    public boolean eKh() {
        return eHP() && this.qnM != null;
    }

    public Kind eKi() {
        return this.qnL;
    }

    public boolean eHP() {
        return eKi() == Kind.OnError;
    }

    public boolean eKj() {
        return eKi() == Kind.OnCompleted;
    }

    public boolean eKk() {
        return eKi() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eKi());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eKh()) {
            append.append(' ').append(eKg().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eKi().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eKh()) {
            return (hashCode * 31) + eKg().hashCode();
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
            if (notification.eKi() != eKi() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qnM != notification.qnM && (this.qnM == null || !this.qnM.equals(notification.qnM))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
