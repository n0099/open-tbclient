package rx;
/* loaded from: classes12.dex */
public final class Notification<T> {
    private static final Notification<Void> pPe = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind pPc;
    private final Throwable pPd;
    private final T value;

    /* loaded from: classes12.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> bT(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> Q(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> eFj() {
        return (Notification<T>) pPe;
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.value = t;
        this.pPd = th;
        this.pPc = kind;
    }

    public Throwable eFk() {
        return this.pPd;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return eFo() && this.value != null;
    }

    public boolean eFl() {
        return eCT() && this.pPd != null;
    }

    public Kind eFm() {
        return this.pPc;
    }

    public boolean eCT() {
        return eFm() == Kind.OnError;
    }

    public boolean eFn() {
        return eFm() == Kind.OnCompleted;
    }

    public boolean eFo() {
        return eFm() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(64).append('[').append(super.toString()).append(' ').append(eFm());
        if (hasValue()) {
            append.append(' ').append(getValue());
        }
        if (eFl()) {
            append.append(' ').append(eFk().getMessage());
        }
        append.append(']');
        return append.toString();
    }

    public int hashCode() {
        int hashCode = eFm().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (eFl()) {
            return (hashCode * 31) + eFk().hashCode();
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
            if (notification.eFm() != eFm() || ((this.value != notification.value && (this.value == null || !this.value.equals(notification.value))) || (this.pPd != notification.pPd && (this.pPd == null || !this.pPd.equals(notification.pPd))))) {
                z = false;
            }
            return z;
        }
        return false;
    }
}
