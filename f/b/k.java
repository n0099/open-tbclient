package f.b;

import io.reactivex.internal.util.NotificationLite;
/* loaded from: classes7.dex */
public final class k<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final k<Object> f68611b = new k<>(null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f68612a;

    public k(Object obj) {
        this.f68612a = obj;
    }

    public static <T> k<T> a() {
        return (k<T>) f68611b;
    }

    public static <T> k<T> b(Throwable th) {
        f.b.x.b.a.b(th, "error is null");
        return new k<>(NotificationLite.error(th));
    }

    public static <T> k<T> c(T t) {
        f.b.x.b.a.b(t, "value is null");
        return new k<>(t);
    }

    public Throwable d() {
        Object obj = this.f68612a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean e() {
        return NotificationLite.isError(this.f68612a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return f.b.x.b.a.a(this.f68612a, ((k) obj).f68612a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f68612a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f68612a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f68612a + "]";
    }
}
