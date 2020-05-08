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

    public static <T> Notification<T> dHj() {
        return (Notification<T>) niR;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.niQ = th;
        this.niP = kind;
    }

    public Throwable dHk() {
        return this.niQ;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dHo() && this.value != null;
    }

    public boolean dHl() {
        return dCz() && this.niQ != null;
    }

    public Kind dHm() {
        return this.niP;
    }

    public boolean dCz() {
        return dHm() == Kind.OnError;
    }

    public boolean dHn() {
        return dHm() == Kind.OnCompleted;
    }

    public boolean dHo() {
        return dHm() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dHm());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dHl()) {
            append.append(' ').append(dHk().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dHm().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dHl()) {
            return (hashCode * 31) + dHk().hashCode();
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
            if (notification.dHm() != dHm() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.niQ != notification.niQ && (this.niQ == null || !this.niQ.equals(notification.niQ))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
