package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f72082e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72083f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f72084g;

    /* renamed from: h  reason: collision with root package name */
    public a f72085h;

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f72086a;

        /* renamed from: b  reason: collision with root package name */
        public int f72087b;

        public void a(Object obj) {
            int i2 = this.f72087b;
            Object[] objArr = this.f72086a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f72086a = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[(i2 >> 2) + i2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.f72086a = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f72087b = i2 + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f72082e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f72084g) {
            return;
        }
        synchronized (this) {
            if (this.f72084g) {
                return;
            }
            this.f72084g = true;
            if (this.f72083f) {
                a aVar = this.f72085h;
                if (aVar == null) {
                    aVar = new a();
                    this.f72085h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f72083f = true;
            this.f72082e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f72084g) {
            return;
        }
        synchronized (this) {
            if (this.f72084g) {
                return;
            }
            this.f72084g = true;
            if (this.f72083f) {
                a aVar = this.f72085h;
                if (aVar == null) {
                    aVar = new a();
                    this.f72085h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f72083f = true;
            this.f72082e.onError(th);
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
        if (this.f72084g) {
            return;
        }
        synchronized (this) {
            if (this.f72084g) {
                return;
            }
            if (this.f72083f) {
                a aVar = this.f72085h;
                if (aVar == null) {
                    aVar = new a();
                    this.f72085h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f72083f = true;
            try {
                this.f72082e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f72085h;
                        if (aVar2 == null) {
                            this.f72083f = false;
                            return;
                        }
                        this.f72085h = null;
                        for (Object obj : aVar2.f72086a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f72082e, obj)) {
                                    this.f72084g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f72084g = true;
                                h.m.a.e(th);
                                this.f72082e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f72084g = true;
                h.m.a.g(th2, this.f72082e, t);
            }
        }
    }
}
