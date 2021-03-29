package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67979e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67980f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f67981g;

    /* renamed from: h  reason: collision with root package name */
    public a f67982h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f67983a;

        /* renamed from: b  reason: collision with root package name */
        public int f67984b;

        public void a(Object obj) {
            int i = this.f67984b;
            Object[] objArr = this.f67983a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f67983a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f67983a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f67984b = i + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f67979e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f67981g) {
            return;
        }
        synchronized (this) {
            if (this.f67981g) {
                return;
            }
            this.f67981g = true;
            if (this.f67980f) {
                a aVar = this.f67982h;
                if (aVar == null) {
                    aVar = new a();
                    this.f67982h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f67980f = true;
            this.f67979e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f67981g) {
            return;
        }
        synchronized (this) {
            if (this.f67981g) {
                return;
            }
            this.f67981g = true;
            if (this.f67980f) {
                a aVar = this.f67982h;
                if (aVar == null) {
                    aVar = new a();
                    this.f67982h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f67980f = true;
            this.f67979e.onError(th);
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
        if (this.f67981g) {
            return;
        }
        synchronized (this) {
            if (this.f67981g) {
                return;
            }
            if (this.f67980f) {
                a aVar = this.f67982h;
                if (aVar == null) {
                    aVar = new a();
                    this.f67982h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f67980f = true;
            try {
                this.f67979e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f67982h;
                        if (aVar2 == null) {
                            this.f67980f = false;
                            return;
                        }
                        this.f67982h = null;
                        for (Object obj : aVar2.f67983a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f67979e, obj)) {
                                    this.f67981g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f67981g = true;
                                h.m.a.e(th);
                                this.f67979e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f67981g = true;
                h.m.a.g(th2, this.f67979e, t);
            }
        }
    }
}
