package rx.subjects;

import h.d;
import h.e;
import h.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public final class SubjectSubscriptionManager<T> extends AtomicReference<b<T>> implements d.a<T> {
    public static final long serialVersionUID = 6035251036011671568L;
    public boolean active;
    public volatile Object latest;
    public h.n.b<c<T>> onAdded;
    public h.n.b<c<T>> onStart;
    public h.n.b<c<T>> onTerminated;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f68290e;

        public a(c cVar) {
            this.f68290e = cVar;
        }

        @Override // h.n.a
        public void call() {
            SubjectSubscriptionManager.this.remove(this.f68290e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final c[] f68292c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f68293d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f68294e;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f68295a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f68296b;

        static {
            c[] cVarArr = new c[0];
            f68292c = cVarArr;
            f68293d = new b(true, cVarArr);
            f68294e = new b(false, f68292c);
        }

        public b(boolean z, c[] cVarArr) {
            this.f68295a = z;
            this.f68296b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f68296b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f68295a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f68296b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f68294e;
            }
            if (length == 0) {
                return this;
            }
            int i = length - 1;
            c[] cVarArr2 = new c[i];
            int i2 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i2 == i) {
                        return this;
                    }
                    cVarArr2[i2] = cVar2;
                    i2++;
                }
            }
            if (i2 == 0) {
                return f68294e;
            }
            if (i2 < i) {
                c[] cVarArr3 = new c[i2];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i2);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f68295a, cVarArr2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements e<T> {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f68297e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68298f = true;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68299g;

        /* renamed from: h  reason: collision with root package name */
        public List<Object> f68300h;
        public boolean i;

        public c(j<? super T> jVar) {
            this.f68297e = jVar;
        }

        public void a(Object obj) {
            if (obj != null) {
                NotificationLite.a(this.f68297e, obj);
            }
        }

        public void b(Object obj) {
            synchronized (this) {
                if (this.f68298f && !this.f68299g) {
                    this.f68298f = false;
                    this.f68299g = obj != null;
                    if (obj != null) {
                        c(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(List<Object> list, Object obj) {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object obj2 : list) {
                            a(obj2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                        }
                        throw th;
                    }
                }
                if (z2) {
                    a(obj);
                    z2 = false;
                }
                try {
                    synchronized (this) {
                        try {
                            list = this.f68300h;
                            this.f68300h = null;
                            if (list == null) {
                                this.f68299g = false;
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    if (!z) {
                        synchronized (this) {
                            this.f68299g = false;
                        }
                    }
                    throw th;
                }
            }
        }

        public void d(Object obj) {
            if (!this.i) {
                synchronized (this) {
                    this.f68298f = false;
                    if (this.f68299g) {
                        if (this.f68300h == null) {
                            this.f68300h = new ArrayList();
                        }
                        this.f68300h.add(obj);
                        return;
                    }
                    this.i = true;
                }
            }
            NotificationLite.a(this.f68297e, obj);
        }

        @Override // h.e
        public void onCompleted() {
            this.f68297e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f68297e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f68297e.onNext(t);
        }
    }

    public SubjectSubscriptionManager() {
        super(b.f68294e);
        this.active = true;
        this.onStart = Actions.a();
        this.onAdded = Actions.a();
        this.onTerminated = Actions.a();
    }

    public boolean add(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f68295a) {
                this.onTerminated.call(cVar);
                return false;
            }
        } while (!compareAndSet(bVar, bVar.a(cVar)));
        this.onAdded.call(cVar);
        return true;
    }

    public void addUnsubscriber(j<? super T> jVar, c<T> cVar) {
        jVar.add(h.u.e.a(new a(cVar)));
    }

    @Override // h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public Object getLatest() {
        return this.latest;
    }

    public c<T>[] next(Object obj) {
        setLatest(obj);
        return get().f68296b;
    }

    public c<T>[] observers() {
        return get().f68296b;
    }

    public void remove(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        do {
            bVar = get();
            if (bVar.f68295a || (b2 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!compareAndSet(bVar, b2));
    }

    public void setLatest(Object obj) {
        this.latest = obj;
    }

    public c<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (get().f68295a) {
            return b.f68292c;
        }
        return getAndSet(b.f68293d).f68296b;
    }

    public void call(j<? super T> jVar) {
        c<T> cVar = new c<>(jVar);
        addUnsubscriber(jVar, cVar);
        this.onStart.call(cVar);
        if (!jVar.isUnsubscribed() && add(cVar) && jVar.isUnsubscribed()) {
            remove(cVar);
        }
    }
}
