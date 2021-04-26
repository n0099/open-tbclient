package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67999e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68000f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f68001g;

    /* renamed from: h  reason: collision with root package name */
    public a f68002h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f68003a;

        /* renamed from: b  reason: collision with root package name */
        public int f68004b;

        public void a(Object obj) {
            int i2 = this.f68004b;
            Object[] objArr = this.f68003a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f68003a = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[(i2 >> 2) + i2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.f68003a = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f68004b = i2 + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f67999e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68001g) {
            return;
        }
        synchronized (this) {
            if (this.f68001g) {
                return;
            }
            this.f68001g = true;
            if (this.f68000f) {
                a aVar = this.f68002h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68002h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f68000f = true;
            this.f67999e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f68001g) {
            return;
        }
        synchronized (this) {
            if (this.f68001g) {
                return;
            }
            this.f68001g = true;
            if (this.f68000f) {
                a aVar = this.f68002h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68002h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f68000f = true;
            this.f67999e.onError(th);
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
        if (this.f68001g) {
            return;
        }
        synchronized (this) {
            if (this.f68001g) {
                return;
            }
            if (this.f68000f) {
                a aVar = this.f68002h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68002h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f68000f = true;
            try {
                this.f67999e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f68002h;
                        if (aVar2 == null) {
                            this.f68000f = false;
                            return;
                        }
                        this.f68002h = null;
                        for (Object obj : aVar2.f68003a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f67999e, obj)) {
                                    this.f68001g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f68001g = true;
                                h.m.a.e(th);
                                this.f67999e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f68001g = true;
                h.m.a.g(th2, this.f67999e, t);
            }
        }
    }
}
