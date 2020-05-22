package rx;
/* loaded from: classes6.dex */
public final class Notification<T> {
    private static final Notification<Void> nDR = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind nDP;
    private final Throwable nDQ;
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

    public static <T> Notification<T> dPe() {
        return (Notification<T>) nDR;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.nDQ = th;
        this.nDP = kind;
    }

    public Throwable dPf() {
        return this.nDQ;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return dPj() && this.value != null;
    }

    public boolean dPg() {
        return dKu() && this.nDQ != null;
    }

    public Kind dPh() {
        return this.nDP;
    }

    public boolean dKu() {
        return dPh() == Kind.OnError;
    }

    public boolean dPi() {
        return dPh() == Kind.OnCompleted;
    }

    public boolean dPj() {
        return dPh() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(dPh());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (dPg()) {
            append.append(' ').append(dPf().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = dPh().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (dPg()) {
            return (hashCode * 31) + dPf().hashCode();
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
            if (notification.dPh() != dPh() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.nDQ != notification.nDQ && (this.nDQ == null || !this.nDQ.equals(notification.nDQ))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
