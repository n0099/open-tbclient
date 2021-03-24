package rx.internal.operators;

import h.e;
import java.io.Serializable;
/* loaded from: classes7.dex */
public final class NotificationLite {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68149a = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        public static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Object f68150b = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        public static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* loaded from: classes7.dex */
    public static final class OnErrorSentinel implements Serializable {
        public static final long serialVersionUID = 3;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f68151e;

        public OnErrorSentinel(Throwable th) {
            this.f68151e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f68151e;
        }
    }

    public static <T> boolean a(e<? super T> eVar, Object obj) {
        if (obj == f68149a) {
            eVar.onCompleted();
            return true;
        } else if (obj == f68150b) {
            eVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == OnErrorSentinel.class) {
                eVar.onError(((OnErrorSentinel) obj).f68151e);
                return true;
            }
            eVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static Object b() {
        return f68149a;
    }

    public static Object c(Throwable th) {
        return new OnErrorSentinel(th);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T d(Object obj) {
        if (obj == f68150b) {
            return null;
        }
        return obj;
    }

    public static boolean e(Object obj) {
        return obj == f68149a;
    }

    public static boolean f(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public static <T> Object g(T t) {
        return t == null ? f68150b : t;
    }
}
