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
        public final /* synthetic */ c f69169e;

        public a(c cVar) {
            this.f69169e = cVar;
        }

        @Override // h.n.a
        public void call() {
            SubjectSubscriptionManager.this.remove(this.f69169e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> {

        /* renamed from: c  reason: collision with root package name */
        public static final c[] f69171c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f69172d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f69173e;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f69174a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f69175b;

        static {
            c[] cVarArr = new c[0];
            f69171c = cVarArr;
            f69172d = new b(true, cVarArr);
            f69173e = new b(false, f69171c);
        }

        public b(boolean z, c[] cVarArr) {
            this.f69174a = z;
            this.f69175b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f69175b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f69174a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f69175b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f69173e;
            }
            if (length == 0) {
                return this;
            }
            int i2 = length - 1;
            c[] cVarArr2 = new c[i2];
            int i3 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i3 == i2) {
                        return this;
                    }
                    cVarArr2[i3] = cVar2;
                    i3++;
                }
            }
            if (i3 == 0) {
                return f69173e;
            }
            if (i3 < i2) {
                c[] cVarArr3 = new c[i3];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i3);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f69174a, cVarArr2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements e<T> {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f69176e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69177f = true;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69178g;

        /* renamed from: h  reason: collision with root package name */
        public List<Object> f69179h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f69180i;

        public c(j<? super T> jVar) {
            this.f69176e = jVar;
        }

        public void a(Object obj) {
            if (obj != null) {
                NotificationLite.a(this.f69176e, obj);
            }
        }

        public void b(Object obj) {
            synchronized (this) {
                if (this.f69177f && !this.f69178g) {
                    this.f69177f = false;
                    this.f69178g = obj != null;
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
                            list = this.f69179h;
                            this.f69179h = null;
                            if (list == null) {
                                this.f69178g = false;
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
                            this.f69178g = false;
                        }
                    }
                    throw th;
                }
            }
        }

        public void d(Object obj) {
            if (!this.f69180i) {
                synchronized (this) {
                    this.f69177f = false;
                    if (this.f69178g) {
                        if (this.f69179h == null) {
                            this.f69179h = new ArrayList();
                        }
                        this.f69179h.add(obj);
                        return;
                    }
                    this.f69180i = true;
                }
            }
            NotificationLite.a(this.f69176e, obj);
        }

        @Override // h.e
        public void onCompleted() {
            this.f69176e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f69176e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f69176e.onNext(t);
        }
    }

    public SubjectSubscriptionManager() {
        super(b.f69173e);
        this.active = true;
        this.onStart = Actions.a();
        this.onAdded = Actions.a();
        this.onTerminated = Actions.a();
    }

    public boolean add(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f69174a) {
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
        return get().f69175b;
    }

    public c<T>[] observers() {
        return get().f69175b;
    }

    public void remove(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        do {
            bVar = get();
            if (bVar.f69174a || (b2 = bVar.b(cVar)) == bVar) {
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
        if (get().f69174a) {
            return b.f69171c;
        }
        return getAndSet(b.f69172d).f69175b;
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
