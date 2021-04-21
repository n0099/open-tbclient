package io.reactivex.internal.util;

import f.b.o;
import f.b.t.b;
import f.b.x.b.a;
import g.d.c;
import g.d.d;
import java.io.Serializable;
/* loaded from: classes7.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes7.dex */
    public static final class DisposableNotification implements Serializable {
        public static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d  reason: collision with root package name */
        public final b f69251d;

        public DisposableNotification(b bVar) {
            this.f69251d = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f69251d + "]";
        }
    }

    /* loaded from: classes7.dex */
    public static final class ErrorNotification implements Serializable {
        public static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f69252e;

        public ErrorNotification(Throwable th) {
            this.f69252e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return a.a(this.f69252e, ((ErrorNotification) obj).f69252e);
            }
            return false;
        }

        public int hashCode() {
            return this.f69252e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f69252e + "]";
        }
    }

    /* loaded from: classes7.dex */
    public static final class SubscriptionNotification implements Serializable {
        public static final long serialVersionUID = -1322257508628817540L;
        public final d s;

        public SubscriptionNotification(d dVar) {
            this.s = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.s + "]";
        }
    }

    public static <T> boolean accept(Object obj, c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).f69252e);
            return true;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).f69252e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            cVar.onSubscribe(((SubscriptionNotification) obj).s);
            return false;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static b getDisposable(Object obj) {
        return ((DisposableNotification) obj).f69251d;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f69252e;
    }

    public static d getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).s;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(d dVar) {
        return new SubscriptionNotification(dVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            oVar.onError(((ErrorNotification) obj).f69252e);
            return true;
        } else {
            oVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            oVar.onError(((ErrorNotification) obj).f69252e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            oVar.onSubscribe(((DisposableNotification) obj).f69251d);
            return false;
        } else {
            oVar.onNext(obj);
            return false;
        }
    }
}
