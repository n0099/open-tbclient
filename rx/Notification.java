package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kmQ = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kmO;
    private final Throwable kmP;
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

    public static <T> Notification<T> cKZ() {
        return (Notification<T>) kmQ;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kmP = th;
        this.kmO = kind;
    }

    public Throwable cLa() {
        return this.kmP;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cLf() && this.value != null;
    }

    public boolean cLb() {
        return cLd() && this.kmP != null;
    }

    public Kind cLc() {
        return this.kmO;
    }

    public boolean cLd() {
        return cLc() == Kind.OnError;
    }

    public boolean cLe() {
        return cLc() == Kind.OnCompleted;
    }

    public boolean cLf() {
        return cLc() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cLc());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cLb()) {
            append.append(' ').append(cLa().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cLc().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cLb()) {
            return (hashCode * 31) + cLa().hashCode();
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
            if (notification.cLc() != cLc() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kmP != notification.kmP && (this.kmP == null || !this.kmP.equals(notification.kmP))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
