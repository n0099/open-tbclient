package h.q;

import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f69136e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69137f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f69138g;

    /* renamed from: h  reason: collision with root package name */
    public a f69139h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f69140a;

        /* renamed from: b  reason: collision with root package name */
        public int f69141b;

        public void a(Object obj) {
            int i = this.f69141b;
            Object[] objArr = this.f69140a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f69140a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f69140a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f69141b = i + 1;
        }
    }

    public d(h.e<? super T> eVar) {
        this.f69136e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f69138g) {
            return;
        }
        synchronized (this) {
            if (this.f69138g) {
                return;
            }
            this.f69138g = true;
            if (this.f69137f) {
                a aVar = this.f69139h;
                if (aVar == null) {
                    aVar = new a();
                    this.f69139h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f69137f = true;
            this.f69136e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f69138g) {
            return;
        }
        synchronized (this) {
            if (this.f69138g) {
                return;
            }
            this.f69138g = true;
            if (this.f69137f) {
                a aVar = this.f69139h;
                if (aVar == null) {
                    aVar = new a();
                    this.f69139h = aVar;
                }
                aVar.a(NotificationLite.c(th));
                return;
            }
            this.f69137f = true;
            this.f69136e.onError(th);
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
        if (this.f69138g) {
            return;
        }
        synchronized (this) {
            if (this.f69138g) {
                return;
            }
            if (this.f69137f) {
                a aVar = this.f69139h;
                if (aVar == null) {
                    aVar = new a();
                    this.f69139h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f69137f = true;
            try {
                this.f69136e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f69139h;
                        if (aVar2 == null) {
                            this.f69137f = false;
                            return;
                        }
                        this.f69139h = null;
                        for (Object obj : aVar2.f69140a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f69136e, obj)) {
                                    this.f69138g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f69138g = true;
                                h.m.a.e(th);
                                this.f69136e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f69138g = true;
                h.m.a.g(th2, this.f69136e, t);
            }
        }
    }
}
