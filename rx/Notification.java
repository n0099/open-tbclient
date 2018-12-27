package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> iEc = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind iEa;
    private final Throwable iEb;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> aV(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cdC() {
        return (Notification<T>) iEc;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.iEb = th;
        this.iEa = kind;
    }

    public Throwable cdD() {
        return this.iEb;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cdI() && this.value != null;
    }

    public boolean cdE() {
        return cdG() && this.iEb != null;
    }

    public Kind cdF() {
        return this.iEa;
    }

    public boolean cdG() {
        return cdF() == Kind.OnError;
    }

    public boolean cdH() {
        return cdF() == Kind.OnCompleted;
    }

    public boolean cdI() {
        return cdF() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cdF());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cdE()) {
            append.append(' ').append(cdD().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cdF().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cdE()) {
            return (hashCode * 31) + cdD().hashCode();
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
            if (notification.cdF() != cdF() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.iEb != notification.iEb && (this.iEb == null || !this.iEb.equals(notification.iEb))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
