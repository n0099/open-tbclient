package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> jVd = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind jVb;
    private final Throwable jVc;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bm(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> I(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cDD() {
        return (Notification<T>) jVd;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.jVc = th;
        this.jVb = kind;
    }

    public Throwable cDE() {
        return this.jVc;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cDJ() && this.value != null;
    }

    public boolean cDF() {
        return cDH() && this.jVc != null;
    }

    public Kind cDG() {
        return this.jVb;
    }

    public boolean cDH() {
        return cDG() == Kind.OnError;
    }

    public boolean cDI() {
        return cDG() == Kind.OnCompleted;
    }

    public boolean cDJ() {
        return cDG() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cDG());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cDF()) {
            append.append(' ').append(cDE().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cDG().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cDF()) {
            return (hashCode * 31) + cDE().hashCode();
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
            if (notification.cDG() != cDG() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.jVc != notification.jVc && (this.jVc == null || !this.jVc.equals(notification.jVc))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
