package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> ojz = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind ojx;
    private final Throwable ojy;
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

    public static <T> Notification<T> T(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dXy() {
        return (Notification<T>) ojz;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.ojy = th;
        this.ojx = kind;
    }

    public Throwable dXz() {
        return this.ojy;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dXD() && this.value != null;
    }

    public boolean dXA() {
        return dSO() && this.ojy != null;
    }

    public Kind dXB() {
        return this.ojx;
    }

    public boolean dSO() {
        return dXB() == Kind.OnError;
    }

    public boolean dXC() {
        return dXB() == Kind.OnCompleted;
    }

    public boolean dXD() {
        return dXB() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dXB());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dXA()) {
            append.append(' ').append(dXz().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dXB().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dXA()) {
            return (hashCode * 31) + dXz().hashCode();
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
            if (notification.dXB() != dXB() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.ojy != notification.ojy && (this.ojy == null || !this.ojy.equals(notification.ojy))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
