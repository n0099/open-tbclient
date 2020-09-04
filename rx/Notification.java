package rx;
/* loaded from: classes5.dex */
public final class Notification<T> {
    private static final Notification<Void> oDP = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind oDN;
    private final Throwable oDO;
    private final T value;

    /* loaded from: classes5.dex */
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

    public static <T> Notification<T> ejM() {
        return (Notification<T>) oDP;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.oDO = th;
        this.oDN = kind;
    }

    public Throwable ejN() {
        return this.oDO;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return ejR() && this.value != null;
    }

    public boolean ejO() {
        return efa() && this.oDO != null;
    }

    public Kind ejP() {
        return this.oDN;
    }

    public boolean efa() {
        return ejP() == Kind.OnError;
    }

    public boolean ejQ() {
        return ejP() == Kind.OnCompleted;
    }

    public boolean ejR() {
        return ejP() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(ejP());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (ejO()) {
            append.append(' ').append(ejN().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = ejP().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (ejO()) {
            return (hashCode * 31) + ejN().hashCode();
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
            if (notification.ejP() != ejP() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.oDO != notification.oDO && (this.oDO == null || !this.oDO.equals(notification.oDO))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
