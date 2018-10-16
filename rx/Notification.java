package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> irY = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind irW;
    private final Throwable irX;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> aV(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cbm() {
        return (Notification<T>) irY;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.irX = th;
        this.irW = kind;
    }

    public Throwable cbn() {
        return this.irX;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cbs() && this.value != null;
    }

    public boolean cbo() {
        return cbq() && this.irX != null;
    }

    public Kind cbp() {
        return this.irW;
    }

    public boolean cbq() {
        return cbp() == Kind.OnError;
    }

    public boolean cbr() {
        return cbp() == Kind.OnCompleted;
    }

    public boolean cbs() {
        return cbp() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cbp());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cbo()) {
            append.append(' ').append(cbn().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cbp().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cbo()) {
            return (hashCode * 31) + cbn().hashCode();
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
            if (notification.cbp() != cbp() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.irX != notification.irX && (this.irX == null || !this.irX.equals(notification.irX))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
