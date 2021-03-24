package rx.internal.operators;

import h.d;
import h.e;
import h.j;
import h.k;
import h.n.f;
import h.n.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes7.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final d<T1> f68153e;

    /* renamed from: f  reason: collision with root package name */
    public final d<T2> f68154f;

    /* renamed from: g  reason: collision with root package name */
    public final f<? super T1, ? extends d<D1>> f68155g;

    /* renamed from: h  reason: collision with root package name */
    public final f<? super T2, ? extends d<D2>> f68156h;
    public final g<? super T1, ? super d<T2>, ? extends R> i;

    /* loaded from: classes7.dex */
    public final class ResultManager extends HashMap<Integer, e<T2>> implements k {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final j<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final h.u.b group = new h.u.b();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        /* loaded from: classes7.dex */
        public final class a extends j<D1> {

            /* renamed from: e  reason: collision with root package name */
            public final int f68157e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f68158f = true;

            public a(int i) {
                this.f68157e = i;
            }

            @Override // h.e
            public void onCompleted() {
                e<T2> remove;
                if (this.f68158f) {
                    this.f68158f = false;
                    synchronized (ResultManager.this) {
                        remove = ResultManager.this.leftMap().remove(Integer.valueOf(this.f68157e));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // h.e
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes7.dex */
        public final class b extends j<T1> {
            public b() {
            }

            @Override // h.e
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager.this.leftDone = true;
                    if (ResultManager.this.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // h.e
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // h.e
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject L = PublishSubject.L();
                    h.q.d dVar = new h.q.d(L);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), dVar);
                    }
                    h.d c2 = h.d.c(new a(L, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.f68155g.call(t1).J(aVar);
                    R a2 = OnSubscribeGroupJoin.this.i.a(t1, c2);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(a2);
                    for (Object obj : arrayList) {
                        dVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    h.m.a.f(th, this);
                }
            }
        }

        /* loaded from: classes7.dex */
        public final class c extends j<D2> {

            /* renamed from: e  reason: collision with root package name */
            public final int f68161e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f68162f = true;

            public c(int i) {
                this.f68161e = i;
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f68162f) {
                    this.f68162f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.f68161e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // h.e
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes7.dex */
        public final class d extends j<T2> {
            public d() {
            }

            @Override // h.e
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager.this.rightDone = true;
                    if (ResultManager.this.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // h.e
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // h.e
            public void onNext(T2 t2) {
                int i;
                ArrayList<e> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.f68156h.call(t2).J(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (e eVar : arrayList) {
                        eVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    h.m.a.f(th, this);
                }
            }
        }

        public ResultManager(j<? super R> jVar) {
            this.subscriber = jVar;
        }

        public void complete(List<e<T2>> list) {
            if (list != null) {
                for (e<T2> eVar : list) {
                    eVar.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        public void errorAll(Throwable th) {
            ArrayList<e> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (e eVar : arrayList) {
                eVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void errorMain(Throwable th) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.a(bVar);
            this.group.a(dVar);
            OnSubscribeGroupJoin.this.f68153e.J(bVar);
            OnSubscribeGroupJoin.this.f68154f.J(dVar);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        public Map<Integer, e<T2>> leftMap() {
            return this;
        }

        @Override // h.k
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes7.dex */
    public static final class a<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final RefCountSubscription f68165e;

        /* renamed from: f  reason: collision with root package name */
        public final d<T> f68166f;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C1893a extends j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final j<? super T> f68167e;

            /* renamed from: f  reason: collision with root package name */
            public final k f68168f;

            public C1893a(a aVar, j<? super T> jVar, k kVar) {
                super(jVar);
                this.f68167e = jVar;
                this.f68168f = kVar;
            }

            @Override // h.e
            public void onCompleted() {
                this.f68167e.onCompleted();
                this.f68168f.unsubscribe();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f68167e.onError(th);
                this.f68168f.unsubscribe();
            }

            @Override // h.e
            public void onNext(T t) {
                this.f68167e.onNext(t);
            }
        }

        public a(d<T> dVar, RefCountSubscription refCountSubscription) {
            this.f68165e = refCountSubscription;
            this.f68166f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            k a2 = this.f68165e.a();
            C1893a c1893a = new C1893a(this, jVar, a2);
            c1893a.add(a2);
            this.f68166f.J(c1893a);
        }
    }
}
