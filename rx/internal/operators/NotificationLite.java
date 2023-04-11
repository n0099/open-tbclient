package rx.internal.operators;

import com.baidu.tieba.g1b;
import java.io.Serializable;
/* loaded from: classes9.dex */
public final class NotificationLite {
    public static final Object a = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        public static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };
    public static final Object b = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        public static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* loaded from: classes9.dex */
    public static final class OnErrorSentinel implements Serializable {
        public static final long serialVersionUID = 3;
        public final Throwable e;

        public OnErrorSentinel(Throwable th) {
            this.e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.e;
        }
    }

    public static Object b() {
        return a;
    }

    public static <T> boolean a(g1b<? super T> g1bVar, Object obj) {
        if (obj == a) {
            g1bVar.onCompleted();
            return true;
        } else if (obj == b) {
            g1bVar.onNext(null);
            return false;
        } else if (obj != null) {
            if (obj.getClass() == OnErrorSentinel.class) {
                g1bVar.onError(((OnErrorSentinel) obj).e);
                return true;
            }
            g1bVar.onNext(obj);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }

    public static Object c(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public static Throwable d(Object obj) {
        return ((OnErrorSentinel) obj).e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj) {
        if (obj == b) {
            return null;
        }
        return obj;
    }

    public static boolean f(Object obj) {
        if (obj == a) {
            return true;
        }
        return false;
    }

    public static boolean g(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public static <T> Object h(T t) {
        if (t == null) {
            return b;
        }
        return t;
    }
}
