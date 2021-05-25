package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f68722e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68723f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f68724g;

    /* renamed from: h  reason: collision with root package name */
    public a f68725h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f68726a;

        /* renamed from: b  reason: collision with root package name */
        public int f68727b;

        public void a(Object obj) {
            int i2 = this.f68727b;
            Object[] objArr = this.f68726a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f68726a = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[(i2 >> 2) + i2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.f68726a = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f68727b = i2 + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f68722e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68724g) {
            return;
        }
        synchronized (this) {
            if (this.f68724g) {
                return;
            }
            this.f68724g = true;
            if (this.f68723f) {
                a aVar = this.f68725h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68725h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f68723f = true;
            this.f68722e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f68724g) {
            return;
        }
        synchronized (this) {
            if (this.f68724g) {
                return;
            }
            this.f68724g = true;
            if (this.f68723f) {
                a aVar = this.f68725h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68725h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f68723f = true;
            this.f68722e.onError(th);
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
        if (this.f68724g) {
            return;
        }
        synchronized (this) {
            if (this.f68724g) {
                return;
            }
            if (this.f68723f) {
                a aVar = this.f68725h;
                if (aVar == null) {
                    aVar = new a();
                    this.f68725h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f68723f = true;
            try {
                this.f68722e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f68725h;
                        if (aVar2 == null) {
                            this.f68723f = false;
                            return;
                        }
                        this.f68725h = null;
                        for (Object obj : aVar2.f68726a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f68722e, obj)) {
                                    this.f68724g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f68724g = true;
                                h.m.a.e(th);
                                this.f68722e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f68724g = true;
                h.m.a.g(th2, this.f68722e, t);
            }
        }
    }
}
