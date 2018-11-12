package rx.internal.operators;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class NotificationLite {
    private static final Object iuL = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };
    private static final Object iuM = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* loaded from: classes2.dex */
    static final class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;
        final Throwable e;

        public OnErrorSentinel(Throwable th) {
            this.e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.e;
        }
    }

    public static <T> Object aX(T t) {
        if (t == null) {
            return iuM;
        }
        return t;
    }

    public static Object cbe() {
        return iuL;
    }

    public static Object M(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public static <T> boolean a(rx.e<? super T> eVar, Object obj) {
        if (obj == iuL) {
            eVar.onCompleted();
            return true;
        } else if (obj == iuM) {
            eVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == OnErrorSentinel.class) {
                eVar.onError(((OnErrorSentinel) obj).e);
                return true;
            }
            eVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static boolean aY(Object obj) {
        return obj == iuL;
    }

    public static boolean aZ(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T ba(Object obj) {
        if (obj == iuM) {
            return null;
        }
        return obj;
    }

    public static Throwable bb(Object obj) {
        return ((OnErrorSentinel) obj).e;
    }
}
