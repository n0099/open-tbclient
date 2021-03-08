package io.reactivex;

import io.reactivex.internal.util.NotificationLite;
/* loaded from: classes6.dex */
public final class p<T> {
    static final p<Object> qop = new p<>(null);
    final Object value;

    private p(Object obj) {
        this.value = obj;
    }

    public boolean eJV() {
        return NotificationLite.isError(this.value);
    }

    public Throwable eJW() {
        Object obj = this.value;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return io.reactivex.internal.functions.a.equals(this.value, ((p) obj).value);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.value;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.value + "]";
    }

    public static <T> p<T> bL(T t) {
        io.reactivex.internal.functions.a.n(t, "value is null");
        return new p<>(t);
    }

    public static <T> p<T> M(Throwable th) {
        io.reactivex.internal.functions.a.n(th, "error is null");
        return new p<>(NotificationLite.error(th));
    }

    public static <T> p<T> eJX() {
        return (p<T>) qop;
    }
}
