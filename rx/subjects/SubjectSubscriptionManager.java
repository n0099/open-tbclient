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
        public final /* synthetic */ c f69296e;

        public a(c cVar) {
            this.f69296e = cVar;
        }

        @Override // h.n.a
        public void call() {
            SubjectSubscriptionManager.this.remove(this.f69296e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final c[] f69298c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f69299d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f69300e;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f69301a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f69302b;

        static {
            c[] cVarArr = new c[0];
            f69298c = cVarArr;
            f69299d = new b(true, cVarArr);
            f69300e = new b(false, f69298c);
        }

        public b(boolean z, c[] cVarArr) {
            this.f69301a = z;
            this.f69302b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f69302b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f69301a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f69302b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f69300e;
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
                return f69300e;
            }
            if (i2 < i) {
                c[] cVarArr3 = new c[i2];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i2);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f69301a, cVarArr2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements e<T> {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f69303e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69304f = true;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69305g;

        /* renamed from: h  reason: collision with root package name */
        public List<Object> f69306h;
        public boolean i;

        public c(j<? super T> jVar) {
            this.f69303e = jVar;
        }

        public void a(Object obj) {
            if (obj != null) {
                NotificationLite.a(this.f69303e, obj);
            }
        }

        public void b(Object obj) {
            synchronized (this) {
                if (this.f69304f && !this.f69305g) {
                    this.f69304f = false;
                    this.f69305g = obj != null;
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
                            list = this.f69306h;
                            this.f69306h = null;
                            if (list == null) {
                                this.f69305g = false;
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
                            this.f69305g = false;
                        }
                    }
                    throw th;
                }
            }
        }

        public void d(Object obj) {
            if (!this.i) {
                synchronized (this) {
                    this.f69304f = false;
                    if (this.f69305g) {
                        if (this.f69306h == null) {
                            this.f69306h = new ArrayList();
                        }
                        this.f69306h.add(obj);
                        return;
                    }
                    this.i = true;
                }
            }
            NotificationLite.a(this.f69303e, obj);
        }

        @Override // h.e
        public void onCompleted() {
            this.f69303e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f69303e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f69303e.onNext(t);
        }
    }

    public SubjectSubscriptionManager() {
        super(b.f69300e);
        this.active = true;
        this.onStart = Actions.a();
        this.onAdded = Actions.a();
        this.onTerminated = Actions.a();
    }

    public boolean add(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f69301a) {
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
        return get().f69302b;
    }

    public c<T>[] observers() {
        return get().f69302b;
    }

    public void remove(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        do {
            bVar = get();
            if (bVar.f69301a || (b2 = bVar.b(cVar)) == bVar) {
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
        if (get().f69301a) {
            return b.f69298c;
        }
        return getAndSet(b.f69299d).f69302b;
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
