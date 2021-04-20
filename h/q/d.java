package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f68989e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68990f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f68991g;

    /* renamed from: h  reason: collision with root package name */
    public a f68992h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f68993a;

        /* renamed from: b  reason: collision with root package name */
        public int f68994b;

        public void a(Object obj) {
            int i = this.f68994b;
            Object[] objArr = this.f68993a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f68993a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f68993a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f68994b = i + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f68989e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68991g) {
            return;
        }
        synchronized (this) {
            if (this.f68991g) {
                return;
            }
            this.f68991g = true;
            if (this.f68990f) {
                a aVar = this.f68992h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68992h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f68990f = true;
            this.f68989e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f68991g) {
            return;
        }
        synchronized (this) {
            if (this.f68991g) {
                return;
            }
            this.f68991g = true;
            if (this.f68990f) {
                a aVar = this.f68992h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68992h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f68990f = true;
            this.f68989e.onError(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x002d, code lost:
        continue;
     */
    @Override // h.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        Object[] objArr;
        if (this.f68991g) {
            return;
        }
        synchronized (this) {
            if (this.f68991g) {
                return;
            }
            if (this.f68990f) {
                a aVar = this.f68992h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68992h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f68990f = true;
            try {
                this.f68989e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f68992h;
                        if (aVar2 == null) {
                            this.f68990f = false;
                            return;
                        }
                        this.f68992h = null;
                        for (Object obj : aVar2.f68993a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f68989e, obj)) {
                                    this.f68991g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f68991g = true;
                                h.m.a.e(th);
                                this.f68989e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f68991g = true;
                h.m.a.g(th2, this.f68989e, t);
            }
        }
    }
}
