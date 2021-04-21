package rx;
/* loaded from: classes7.dex */
public final class Notification<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final Notification<Void> f69292d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a  reason: collision with root package name */
    public final Kind f69293a;

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f69294b;

    /* renamed from: c  reason: collision with root package name */
    public final T f69295c;

    /* loaded from: classes7.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public Notification(Kind kind, T t, Throwable th) {
        this.f69295c = t;
        this.f69294b = th;
        this.f69293a = kind;
    }

    public static <T> Notification<T> a() {
        return (Notification<T>) f69292d;
    }

    public static <T> Notification<T> b(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> c(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public Kind d() {
        return this.f69293a;
    }

    public Throwable e() {
        return this.f69294b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.d() == d()) {
            T t = this.f69295c;
            T t2 = notification.f69295c;
            if (t == t2 || (t != null && t.equals(t2))) {
                Throwable th = this.f69294b;
                Throwable th2 = notification.f69294b;
                return th == th2 || (th != null && th.equals(th2));
            }
            return false;
        }
        return false;
    }

    public T f() {
        return this.f69295c;
    }

    public boolean g() {
        return j() && this.f69294b != null;
    }

    public boolean h() {
        return k() && this.f69295c != null;
    }

    public int hashCode() {
        int hashCode = d().hashCode();
        if (h()) {
            hashCode = (hashCode * 31) + f().hashCode();
        }
        return g() ? (hashCode * 31) + e().hashCode() : hashCode;
    }

    public boolean i() {
        return d() == Kind.OnCompleted;
    }

    public boolean j() {
        return d() == Kind.OnError;
    }

    public boolean k() {
        return d() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(d());
        if (h()) {
            sb.append(' ');
            sb.append(f());
        }
        if (g()) {
            sb.append(' ');
            sb.append(e().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
