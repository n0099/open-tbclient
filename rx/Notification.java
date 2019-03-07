package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> jUS = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind jUQ;
    private final Throwable jUR;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bl(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> I(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cDq() {
        return (Notification<T>) jUS;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.jUR = th;
        this.jUQ = kind;
    }

    public Throwable cDr() {
        return this.jUR;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cDw() && this.value != null;
    }

    public boolean cDs() {
        return cDu() && this.jUR != null;
    }

    public Kind cDt() {
        return this.jUQ;
    }

    public boolean cDu() {
        return cDt() == Kind.OnError;
    }

    public boolean cDv() {
        return cDt() == Kind.OnCompleted;
    }

    public boolean cDw() {
        return cDt() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cDt());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cDs()) {
            append.append(' ').append(cDr().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cDt().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cDs()) {
            return (hashCode * 31) + cDr().hashCode();
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
            if (notification.cDt() != cDt() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.jUR != notification.jUR && (this.jUR == null || !this.jUR.equals(notification.jUR))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
