package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kmN = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kmL;
    private final Throwable kmM;
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

    public static <T> Notification<T> cLa() {
        return (Notification<T>) kmN;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kmM = th;
        this.kmL = kind;
    }

    public Throwable cLb() {
        return this.kmM;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cLg() && this.value != null;
    }

    public boolean cLc() {
        return cLe() && this.kmM != null;
    }

    public Kind cLd() {
        return this.kmL;
    }

    public boolean cLe() {
        return cLd() == Kind.OnError;
    }

    public boolean cLf() {
        return cLd() == Kind.OnCompleted;
    }

    public boolean cLg() {
        return cLd() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cLd());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cLc()) {
            append.append(' ').append(cLb().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cLd().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cLc()) {
            return (hashCode * 31) + cLb().hashCode();
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
            if (notification.cLd() != cLd() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kmM != notification.kmM && (this.kmM == null || !this.kmM.equals(notification.kmM))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
