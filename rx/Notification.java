package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> jVl = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind jVj;
    private final Throwable jVk;
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

    public static <T> Notification<T> cDA() {
        return (Notification<T>) jVl;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.jVk = th;
        this.jVj = kind;
    }

    public Throwable cDB() {
        return this.jVk;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cDG() && this.value != null;
    }

    public boolean cDC() {
        return cDE() && this.jVk != null;
    }

    public Kind cDD() {
        return this.jVj;
    }

    public boolean cDE() {
        return cDD() == Kind.OnError;
    }

    public boolean cDF() {
        return cDD() == Kind.OnCompleted;
    }

    public boolean cDG() {
        return cDD() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cDD());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cDC()) {
            append.append(' ').append(cDB().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cDD().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cDC()) {
            return (hashCode * 31) + cDB().hashCode();
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
            if (notification.cDD() != cDD() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.jVk != notification.jVk && (this.jVk == null || !this.jVk.equals(notification.jVk))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
