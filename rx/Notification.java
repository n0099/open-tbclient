package rx;
/* loaded from: classes7.dex */
public final class Notification<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final Notification<Void> f68329d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a  reason: collision with root package name */
    public final Kind f68330a;

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f68331b;

    /* renamed from: c  reason: collision with root package name */
    public final T f68332c;

    /* loaded from: classes7.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public Notification(Kind kind, T t, Throwable th) {
        this.f68332c = t;
        this.f68331b = th;
        this.f68330a = kind;
    }

    public static <T> Notification<T> a() {
        return (Notification<T>) f68329d;
    }

    public static <T> Notification<T> b(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> c(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public Kind d() {
        return this.f68330a;
    }

    public Throwable e() {
        return this.f68331b;
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
            T t = this.f68332c;
            T t2 = notification.f68332c;
            if (t == t2 || (t != null && t.equals(t2))) {
                Throwable th = this.f68331b;
                Throwable th2 = notification.f68331b;
                return th == th2 || (th != null && th.equals(th2));
            }
            return false;
        }
        return false;
    }

    public T f() {
        return this.f68332c;
    }

    public boolean g() {
        return j() && this.f68331b != null;
    }

    public boolean h() {
        return k() && this.f68332c != null;
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
