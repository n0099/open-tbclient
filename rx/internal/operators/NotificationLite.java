package rx.internal.operators;

import h.e;
import java.io.Serializable;
/* loaded from: classes7.dex */
public final class NotificationLite {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68344a = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        public static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Object f68345b = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        public static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* loaded from: classes7.dex */
    public static final class OnErrorSentinel implements Serializable {
        public static final long serialVersionUID = 3;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f68346e;

        public OnErrorSentinel(Throwable th) {
            this.f68346e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f68346e;
        }
    }

    public static <T> boolean a(e<? super T> eVar, Object obj) {
        if (obj == f68344a) {
            eVar.onCompleted();
            return true;
        } else if (obj == f68345b) {
            eVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == OnErrorSentinel.class) {
                eVar.onError(((OnErrorSentinel) obj).f68346e);
                return true;
            }
            eVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static Object b() {
        return f68344a;
    }

    public static Object c(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public static Throwable d(Object obj) {
        return ((OnErrorSentinel) obj).f68346e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj) {
        if (obj == f68345b) {
            return null;
        }
        return obj;
    }

    public static boolean f(Object obj) {
        return obj == f68344a;
    }

    public static boolean g(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public static <T> Object h(T t) {
        return t == null ? f68345b : t;
    }
}
