package rx;
/* loaded from: classes14.dex */
public final class Notification<T> {
    private static final Notification<Void> qfa = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qeY;
    private final Throwable qeZ;
    private final T value;

    /* loaded from: classes14.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> cd(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> S(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eFj() {
        return (Notification<T>) qfa;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qeZ = th;
        this.qeY = kind;
    }

    public Throwable eFk() {
        return this.qeZ;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eFo() && this.value != null;
    }

    public boolean eFl() {
        return eAy() && this.qeZ != null;
    }

    public Kind eFm() {
        return this.qeY;
    }

    public boolean eAy() {
        return eFm() == Kind.OnError;
    }

    public boolean eFn() {
        return eFm() == Kind.OnCompleted;
    }

    public boolean eFo() {
        return eFm() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eFm());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eFl()) {
            append.append(' ').append(eFk().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eFm().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eFl()) {
            return (hashCode * 31) + eFk().hashCode();
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
            if (notification.eFm() != eFm() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qeZ != notification.qeZ && (this.qeZ == null || !this.qeZ.equals(notification.qeZ))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
