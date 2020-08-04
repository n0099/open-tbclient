package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> ojB = new Notification<>(Kind.OnCompleted, null, null);
    private final Throwable ojA;
    private final Kind ojz;
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

    public static <T> Notification<T> dXz() {
        return (Notification<T>) ojB;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.ojA = th;
        this.ojz = kind;
    }

    public Throwable dXA() {
        return this.ojA;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dXE() && this.value != null;
    }

    public boolean dXB() {
        return dSP() && this.ojA != null;
    }

    public Kind dXC() {
        return this.ojz;
    }

    public boolean dSP() {
        return dXC() == Kind.OnError;
    }

    public boolean dXD() {
        return dXC() == Kind.OnCompleted;
    }

    public boolean dXE() {
        return dXC() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dXC());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dXB()) {
            append.append(' ').append(dXA().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dXC().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dXB()) {
            return (hashCode * 31) + dXA().hashCode();
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
            if (notification.dXC() != dXC() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.ojA != notification.ojA && (this.ojA == null || !this.ojA.equals(notification.ojA))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
