package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f71978e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71979f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f71980g;

    /* renamed from: h  reason: collision with root package name */
    public a f71981h;

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f71982a;

        /* renamed from: b  reason: collision with root package name */
        public int f71983b;

        public void a(Object obj) {
            int i2 = this.f71983b;
            Object[] objArr = this.f71982a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f71982a = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[(i2 >> 2) + i2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.f71982a = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f71983b = i2 + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f71978e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f71980g) {
            return;
        }
        synchronized (this) {
            if (this.f71980g) {
                return;
            }
            this.f71980g = true;
            if (this.f71979f) {
                a aVar = this.f71981h;
                if (aVar == null) {
                    aVar = new a();
                    this.f71981h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f71979f = true;
            this.f71978e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f71980g) {
            return;
        }
        synchronized (this) {
            if (this.f71980g) {
                return;
            }
            this.f71980g = true;
            if (this.f71979f) {
                a aVar = this.f71981h;
                if (aVar == null) {
                    aVar = new a();
                    this.f71981h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f71979f = true;
            this.f71978e.onError(th);
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
        if (this.f71980g) {
            return;
        }
        synchronized (this) {
            if (this.f71980g) {
                return;
            }
            if (this.f71979f) {
                a aVar = this.f71981h;
                if (aVar == null) {
                    aVar = new a();
                    this.f71981h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f71979f = true;
            try {
                this.f71978e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f71981h;
                        if (aVar2 == null) {
                            this.f71979f = false;
                            return;
                        }
                        this.f71981h = null;
                        for (Object obj : aVar2.f71982a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f71978e, obj)) {
                                    this.f71980g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f71980g = true;
                                h.m.a.e(th);
                                this.f71978e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f71980g = true;
                h.m.a.g(th2, this.f71978e, t);
            }
        }
    }
}
