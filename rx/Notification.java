package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> niR = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind niP;
    private final Throwable niQ;
    private final T value;

    /* loaded from: classes6.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bK(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dHk() {
        return (Notification<T>) niR;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.niQ = th;
        this.niP = kind;
    }

    public Throwable dHl() {
        return this.niQ;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dHp() && this.value != null;
    }

    public boolean dHm() {
        return dCA() && this.niQ != null;
    }

    public Kind dHn() {
        return this.niP;
    }

    public boolean dCA() {
        return dHn() == Kind.OnError;
    }

    public boolean dHo() {
        return dHn() == Kind.OnCompleted;
    }

    public boolean dHp() {
        return dHn() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dHn());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dHm()) {
            append.append(' ').append(dHl().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dHn().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dHm()) {
            return (hashCode * 31) + dHl().hashCode();
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
            if (notification.dHn() != dHn() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.niQ != notification.niQ && (this.niQ == null || !this.niQ.equals(notification.niQ))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
