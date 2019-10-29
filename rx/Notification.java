package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kyw = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kyu;
    private final Throwable kyv;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bg(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> G(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cOb() {
        return (Notification<T>) kyw;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kyv = th;
        this.kyu = kind;
    }

    public Throwable cOc() {
        return this.kyv;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cOh() && this.value != null;
    }

    public boolean cOd() {
        return cOf() && this.kyv != null;
    }

    public Kind cOe() {
        return this.kyu;
    }

    public boolean cOf() {
        return cOe() == Kind.OnError;
    }

    public boolean cOg() {
        return cOe() == Kind.OnCompleted;
    }

    public boolean cOh() {
        return cOe() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cOe());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cOd()) {
            append.append(' ').append(cOc().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cOe().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cOd()) {
            return (hashCode * 31) + cOc().hashCode();
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
            if (notification.cOe() != cOe() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kyv != notification.kyv && (this.kyv == null || !this.kyv.equals(notification.kyv))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
