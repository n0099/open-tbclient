package io.reactivex.internal.util;

import io.reactivex.u;
import java.io.Serializable;
/* loaded from: classes5.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes5.dex */
    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable th) {
            this.e = th;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return io.reactivex.internal.functions.a.equals(this.e, ((ErrorNotification) obj).e);
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final org.a.d s;

        SubscriptionNotification(org.a.d dVar) {
            this.s = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.s + "]";
        }
    }

    /* loaded from: classes5.dex */
    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.disposables.b d;

        DisposableNotification(io.reactivex.disposables.b bVar) {
            this.d = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.d + "]";
        }
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Object subscription(org.a.d dVar) {
        return new SubscriptionNotification(dVar);
    }

    public static Object disposable(io.reactivex.disposables.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).e;
    }

    public static org.a.d getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).s;
    }

    public static io.reactivex.disposables.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).d;
    }

    public static <T> boolean accept(Object obj, org.a.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).e);
            return true;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, u<? super T> uVar) {
        if (obj == COMPLETE) {
            uVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            uVar.onError(((ErrorNotification) obj).e);
            return true;
        } else {
            uVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, org.a.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            cVar.onSubscribe(((SubscriptionNotification) obj).s);
            return false;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, u<? super T> uVar) {
        if (obj == COMPLETE) {
            uVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            uVar.onError(((ErrorNotification) obj).e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            uVar.onSubscribe(((DisposableNotification) obj).d);
            return false;
        } else {
            uVar.onNext(obj);
            return false;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
