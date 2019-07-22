package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> kup = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kun;
    private final Throwable kuo;
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

    public static <T> Notification<T> cON() {
        return (Notification<T>) kup;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.kuo = th;
        this.kun = kind;
    }

    public Throwable cOO() {
        return this.kuo;
    }

    public T getValue() {
        return this.value;
    }

    public boolean cOP() {
        return cOU() && this.value != null;
    }

    public boolean cOQ() {
        return cOS() && this.kuo != null;
    }

    public Kind cOR() {
        return this.kun;
    }

    public boolean cOS() {
        return cOR() == Kind.OnError;
    }

    public boolean cOT() {
        return cOR() == Kind.OnCompleted;
    }

    public boolean cOU() {
        return cOR() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(cOR());
        if (cOP()) {
            append.append(' ').append(getValue());
        }
        if (cOQ()) {
            append.append(' ').append(cOO().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = cOR().hashCode();
        if (cOP()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (cOQ()) {
            return (hashCode * 31) + cOO().hashCode();
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
            if (notification.cOR() != cOR() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.kuo != notification.kuo && (this.kuo == null || !this.kuo.equals(notification.kuo))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
