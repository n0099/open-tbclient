package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67974e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67975f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f67976g;

    /* renamed from: h  reason: collision with root package name */
    public a f67977h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f67978a;

        /* renamed from: b  reason: collision with root package name */
        public int f67979b;

        public void a(Object obj) {
            int i = this.f67979b;
            Object[] objArr = this.f67978a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f67978a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f67978a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f67979b = i + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f67974e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f67976g) {
            return;
        }
        synchronized (this) {
            if (this.f67976g) {
                return;
            }
            this.f67976g = true;
            if (this.f67975f) {
                a aVar = this.f67977h;
                if (aVar == null) {
                    aVar = new a();
                    this.f67977h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f67975f = true;
            this.f67974e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f67976g) {
            return;
        }
        synchronized (this) {
            if (this.f67976g) {
                return;
            }
            this.f67976g = true;
            if (this.f67975f) {
                a aVar = this.f67977h;
                if (aVar == null) {
                    aVar = new a();
                    this.f67977h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f67975f = true;
            this.f67974e.onError(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x002d, code lost:
        continue;
     */
    @Override // h.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        Object[] objArr;
        if (this.f67976g) {
            return;
        }
        synchronized (this) {
            if (this.f67976g) {
                return;
            }
            if (this.f67975f) {
                a aVar = this.f67977h;
                if (aVar == null) {
                    aVar = new a();
                    this.f67977h = aVar;
                }
                aVar.a(NotificationLite.g(t));
                return;
            }
            this.f67975f = true;
            try {
                this.f67974e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f67977h;
                        if (aVar2 == null) {
                            this.f67975f = false;
                            return;
                        }
                        this.f67977h = null;
                        for (Object obj : aVar2.f67978a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f67974e, obj)) {
                                    this.f67976g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f67976g = true;
                                h.m.a.e(th);
                                this.f67974e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f67976g = true;
                h.m.a.g(th2, this.f67974e, t);
            }
        }
    }
}
