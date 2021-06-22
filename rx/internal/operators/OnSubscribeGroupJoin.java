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
/* loaded from: classes8.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final d<T1> f72484e;

    /* renamed from: f  reason: collision with root package name */
    public final d<T2> f72485f;

    /* renamed from: g  reason: collision with root package name */
    public final f<? super T1, ? extends d<D1>> f72486g;

    /* renamed from: h  reason: collision with root package name */
    public final f<? super T2, ? extends d<D2>> f72487h;

    /* renamed from: i  reason: collision with root package name */
    public final g<? super T1, ? super d<T2>, ? extends R> f72488i;

    /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
        public final class a extends j<D1> {

            /* renamed from: e  reason: collision with root package name */
            public final int f72489e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f72490f = true;

            public a(int i2) {
                this.f72489e = i2;
            }

            @Override // h.e
            public void onCompleted() {
                e<T2> remove;
                if (this.f72490f) {
                    this.f72490f = false;
                    synchronized (ResultManager.this) {
                        remove = ResultManager.this.leftMap().remove(Integer.valueOf(this.f72489e));
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

        /* loaded from: classes8.dex */
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
                int i2;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject K = PublishSubject.K();
                    h.q.d dVar = new h.q.d(K);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i2 = resultManager.leftIds;
                        resultManager.leftIds = i2 + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i2), dVar);
                    }
                    h.d b2 = h.d.b(new a(K, ResultManager.this.cancel));
                    a aVar = new a(i2);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.f72486g.call(t1).I(aVar);
                    R a2 = OnSubscribeGroupJoin.this.f72488i.a(t1, b2);
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

        /* loaded from: classes8.dex */
        public final class c extends j<D2> {

            /* renamed from: e  reason: collision with root package name */
            public final int f72493e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f72494f = true;

            public c(int i2) {
                this.f72493e = i2;
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f72494f) {
                    this.f72494f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.f72493e));
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

        /* loaded from: classes8.dex */
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
                int i2;
                ArrayList<e> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i2 = resultManager.rightIds;
                        resultManager.rightIds = i2 + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i2), t2);
                    }
                    c cVar = new c(i2);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.f72487h.call(t2).I(cVar);
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
            OnSubscribeGroupJoin.this.f72484e.I(bVar);
            OnSubscribeGroupJoin.this.f72485f.I(dVar);
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

    /* loaded from: classes8.dex */
    public static final class a<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final RefCountSubscription f72497e;

        /* renamed from: f  reason: collision with root package name */
        public final d<T> f72498f;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public final class C2007a extends j<T> {

            /* renamed from: e  reason: collision with root package name */
            public final j<? super T> f72499e;

            /* renamed from: f  reason: collision with root package name */
            public final k f72500f;

            public C2007a(a aVar, j<? super T> jVar, k kVar) {
                super(jVar);
                this.f72499e = jVar;
                this.f72500f = kVar;
            }

            @Override // h.e
            public void onCompleted() {
                this.f72499e.onCompleted();
                this.f72500f.unsubscribe();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f72499e.onError(th);
                this.f72500f.unsubscribe();
            }

            @Override // h.e
            public void onNext(T t) {
                this.f72499e.onNext(t);
            }
        }

        public a(d<T> dVar, RefCountSubscription refCountSubscription) {
            this.f72497e = refCountSubscription;
            this.f72498f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            k a2 = this.f72497e.a();
            C2007a c2007a = new C2007a(this, jVar, a2);
            c2007a.add(a2);
            this.f72498f.I(c2007a);
        }
    }
}
