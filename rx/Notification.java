package rx;
/* loaded from: classes16.dex */
public final class Notification<T> {
    private static final Notification<Void> qdx = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind qdv;
    private final Throwable qdw;
    private final T value;

    /* loaded from: classes16.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> cc(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> S(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eFi() {
        return (Notification<T>) qdx;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.qdw = th;
        this.qdv = kind;
    }

    public Throwable eFj() {
        return this.qdw;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eFn() && this.value != null;
    }

    public boolean eFk() {
        return eAx() && this.qdw != null;
    }

    public Kind eFl() {
        return this.qdv;
    }

    public boolean eAx() {
        return eFl() == Kind.OnError;
    }

    public boolean eFm() {
        return eFl() == Kind.OnCompleted;
    }

    public boolean eFn() {
        return eFl() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eFl());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eFk()) {
            append.append(' ').append(eFj().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eFl().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eFk()) {
            return (hashCode * 31) + eFj().hashCode();
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
            if (notification.eFl() != eFl() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.qdw != notification.qdw && (this.qdw == null || !this.qdw.equals(notification.qdw))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
