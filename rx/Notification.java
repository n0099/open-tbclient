package rx;
/* loaded from: classes2.dex */
public final class Notification<T> {
    private static final Notification<Void> itJ = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind itH;
    private final Throwable itI;
    private final T value;

    /* loaded from: classes2.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> aU(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> H(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> caJ() {
        return (Notification<T>) itJ;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.itI = th;
        this.itH = kind;
    }

    public Throwable caK() {
        return this.itI;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return caP() && this.value != null;
    }

    public boolean caL() {
        return caN() && this.itI != null;
    }

    public Kind caM() {
        return this.itH;
    }

    public boolean caN() {
        return caM() == Kind.OnError;
    }

    public boolean caO() {
        return caM() == Kind.OnCompleted;
    }

    public boolean caP() {
        return caM() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(caM());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (caL()) {
            append.append(' ').append(caK().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = caM().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (caL()) {
            return (hashCode * 31) + caK().hashCode();
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
            if (notification.caM() != caM() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.itI != notification.itI && (this.itI == null || !this.itI.equals(notification.itI))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
