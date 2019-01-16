package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> iFj = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind iFh;
    private final Throwable iFi;
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

    public static <T> Notification<T> cek() {
        return (Notification<T>) iFj;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.iFi = th;
        this.iFh = kind;
    }

    public Throwable cel() {
        return this.iFi;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return ceq() && this.value != null;
    }

    public boolean cem() {
        return ceo() && this.iFi != null;
    }

    public Kind cen() {
        return this.iFh;
    }

    public boolean ceo() {
        return cen() == Kind.OnError;
    }

    public boolean cep() {
        return cen() == Kind.OnCompleted;
    }

    public boolean ceq() {
        return cen() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cen());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cem()) {
            append.append(' ').append(cel().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cen().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cem()) {
            return (hashCode * 31) + cel().hashCode();
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
            if (notification.cen() != cen() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.iFi != notification.iFi && (this.iFi == null || !this.iFi.equals(notification.iFi))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
