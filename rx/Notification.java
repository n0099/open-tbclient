package rx;
/* loaded from: classes16.dex */
public final class Notification<T> {
    private static final Notification<Void> pcK = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind pcI;
    private final Throwable pcJ;
    private final T value;

    /* loaded from: classes16.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bY(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> S(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> erv() {
        return (Notification<T>) pcK;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.pcJ = th;
        this.pcI = kind;
    }

    public Throwable erw() {
        return this.pcJ;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return erA() && this.value != null;
    }

    public boolean erx() {
        return emI() && this.pcJ != null;
    }

    public Kind ery() {
        return this.pcI;
    }

    public boolean emI() {
        return ery() == Kind.OnError;
    }

    public boolean erz() {
        return ery() == Kind.OnCompleted;
    }

    public boolean erA() {
        return ery() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(ery());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (erx()) {
            append.append(' ').append(erw().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = ery().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (erx()) {
            return (hashCode * 31) + erw().hashCode();
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
            if (notification.ery() != ery() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.pcJ != notification.pcJ && (this.pcJ == null || !this.pcJ.equals(notification.pcJ))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
