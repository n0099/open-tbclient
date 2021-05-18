package rx.internal.operators;

import h.e;
import java.io.Serializable;
/* loaded from: classes7.dex */
public final class NotificationLite {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f69024a = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        public static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Object f69025b = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        public static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* loaded from: classes7.dex */
    public static final class OnErrorSentinel implements Serializable {
        public static final long serialVersionUID = 3;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f69026e;

        public OnErrorSentinel(Throwable th) {
            this.f69026e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f69026e;
        }
    }

    public static <T> boolean a(e<? super T> eVar, Object obj) {
        if (obj == f69024a) {
            eVar.onCompleted();
            return true;
        } else if (obj == f69025b) {
            eVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == OnErrorSentinel.class) {
                eVar.onError(((OnErrorSentinel) obj).f69026e);
                return true;
            }
            eVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static Object b() {
        return f69024a;
    }

    public static Object c(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public static Throwable d(Object obj) {
        return ((OnErrorSentinel) obj).f69026e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj) {
        if (obj == f69025b) {
            return null;
        }
        return obj;
    }

    public static boolean f(Object obj) {
        return obj == f69024a;
    }

    public static boolean g(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public static <T> Object h(T t) {
        return t == null ? f69025b : t;
    }
}
