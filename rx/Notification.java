package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> oaP = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind oaN;
    private final Throwable oaO;
    private final T value;

    /* loaded from: classes6.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bR(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dUc() {
        return (Notification<T>) oaP;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.oaO = th;
        this.oaN = kind;
    }

    public Throwable dUd() {
        return this.oaO;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dUh() && this.value != null;
    }

    public boolean dUe() {
        return dPs() && this.oaO != null;
    }

    public Kind dUf() {
        return this.oaN;
    }

    public boolean dPs() {
        return dUf() == Kind.OnError;
    }

    public boolean dUg() {
        return dUf() == Kind.OnCompleted;
    }

    public boolean dUh() {
        return dUf() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dUf());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dUe()) {
            append.append(' ').append(dUd().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dUf().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dUe()) {
            return (hashCode * 31) + dUd().hashCode();
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
            if (notification.dUf() != dUf() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.oaO != notification.oaO && (this.oaO == null || !this.oaO.equals(notification.oaO))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
