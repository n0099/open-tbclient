package rx;
/* loaded from: classes5.dex */
public final class Notification<T> {
    private static final Notification<Void> oDx = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind oDv;
    private final Throwable oDw;
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

    public static <T> Notification<T> ejD() {
        return (Notification<T>) oDx;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.oDw = th;
        this.oDv = kind;
    }

    public Throwable ejE() {
        return this.oDw;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return ejI() && this.value != null;
    }

    public boolean ejF() {
        return eeR() && this.oDw != null;
    }

    public Kind ejG() {
        return this.oDv;
    }

    public boolean eeR() {
        return ejG() == Kind.OnError;
    }

    public boolean ejH() {
        return ejG() == Kind.OnCompleted;
    }

    public boolean ejI() {
        return ejG() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(ejG());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (ejF()) {
            append.append(' ').append(ejE().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = ejG().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (ejF()) {
            return (hashCode * 31) + ejE().hashCode();
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
            if (notification.ejG() != ejG() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.oDw != notification.oDw && (this.oDw == null || !this.oDw.equals(notification.oDw))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
