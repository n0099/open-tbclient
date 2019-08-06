package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kvv = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kvt;
    private final Throwable kvu;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bl(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cPi() {
        return (Notification<T>) kvv;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kvu = th;
        this.kvt = kind;
    }

    public Throwable cPj() {
        return this.kvu;
    }

    public T getValue() {
        return this.value;
    }

    public boolean cPk() {
        return cPp() && this.value != null;
    }

    public boolean cPl() {
        return cPn() && this.kvu != null;
    }

    public Kind cPm() {
        return this.kvt;
    }

    public boolean cPn() {
        return cPm() == Kind.OnError;
    }

    public boolean cPo() {
        return cPm() == Kind.OnCompleted;
    }

    public boolean cPp() {
        return cPm() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cPm());
        if (cPk()) {
            append.append(' ').append(getValue());
        }
        if (cPl()) {
            append.append(' ').append(cPj().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cPm().hashCode();
        if (cPk()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cPl()) {
            return (hashCode * 31) + cPj().hashCode();
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
            if (notification.cPm() != cPm() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kvu != notification.kvu && (this.kvu == null || !this.kvu.equals(notification.kvu))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
