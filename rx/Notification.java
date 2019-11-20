package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kxF = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kxD;
    private final Throwable kxE;
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

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> cNZ() {
        return (Notification<T>) kxF;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kxE = th;
        this.kxD = kind;
    }

    public Throwable cOa() {
        return this.kxE;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return cOf() && this.value != null;
    }

    public boolean cOb() {
        return cOd() && this.kxE != null;
    }

    public Kind cOc() {
        return this.kxD;
    }

    public boolean cOd() {
        return cOc() == Kind.OnError;
    }

    public boolean cOe() {
        return cOc() == Kind.OnCompleted;
    }

    public boolean cOf() {
        return cOc() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cOc());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (cOb()) {
            append.append(' ').append(cOa().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cOc().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cOb()) {
            return (hashCode * 31) + cOa().hashCode();
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
            if (notification.cOc() != cOc() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kxE != notification.kxE && (this.kxE == null || !this.kxE.equals(notification.kxE))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
