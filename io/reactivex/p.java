package io.reactivex;

import io.reactivex.internal.util.NotificationLite;
/* loaded from: classes17.dex */
public final class p<T> {
    static final p<Object> pLY = new p<>(null);
    final Object value;

    private p(Object obj) {
        this.value = obj;
    }

    public boolean eAx() {
        return NotificationLite.isError(this.value);
    }

    public Throwable eAy() {
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
        io.reactivex.internal.functions.a.l(t, "value is null");
        return new p<>(t);
    }

    public static <T> p<T> I(Throwable th) {
        io.reactivex.internal.functions.a.l(th, "error is null");
        return new p<>(NotificationLite.error(th));
    }

    public static <T> p<T> eAz() {
        return (p<T>) pLY;
    }
}
