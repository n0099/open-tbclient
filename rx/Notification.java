package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> nFb = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind nEZ;
    private final Throwable nFa;
    private final T value;

    /* loaded from: classes6.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bQ(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> U(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> dPs() {
        return (Notification<T>) nFb;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.nFa = th;
        this.nEZ = kind;
    }

    public Throwable dPt() {
        return this.nFa;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dPx() && this.value != null;
    }

    public boolean dPu() {
        return dKI() && this.nFa != null;
    }

    public Kind dPv() {
        return this.nEZ;
    }

    public boolean dKI() {
        return dPv() == Kind.OnError;
    }

    public boolean dPw() {
        return dPv() == Kind.OnCompleted;
    }

    public boolean dPx() {
        return dPv() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dPv());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dPu()) {
            append.append(' ').append(dPt().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dPv().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dPu()) {
            return (hashCode * 31) + dPt().hashCode();
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
            if (notification.dPv() != dPv() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.nFa != notification.nFa && (this.nFa == null || !this.nFa.equals(notification.nFa))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
