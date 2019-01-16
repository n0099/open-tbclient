package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.d;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {
    final rx.d<T1> iHb;
    final rx.d<T2> iHc;
    final rx.functions.f<? super T1, ? extends rx.d<D1>> iHd;
    final rx.functions.f<? super T2, ? extends rx.d<D2>> iHe;
    final rx.functions.g<? super T1, ? super rx.d<T2>, ? extends R> iHf;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public OnSubscribeGroupJoin(rx.d<T1> dVar, rx.d<T2> dVar2, rx.functions.f<? super T1, ? extends rx.d<D1>> fVar, rx.functions.f<? super T2, ? extends rx.d<D2>> fVar2, rx.functions.g<? super T1, ? super rx.d<T2>, ? extends R> gVar) {
        this.iHb = dVar;
        this.iHc = dVar2;
        this.iHd = fVar;
        this.iHe = fVar2;
        this.iHf = gVar;
    }

    public void call(rx.j<? super R> jVar) {
        ResultManager resultManager = new ResultManager(new rx.b.f(jVar));
        jVar.add(resultManager);
        resultManager.init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, rx.e<T2>> implements rx.k {
        private static final long serialVersionUID = -3035156013812425335L;
        boolean leftDone;
        int leftIds;
        boolean rightDone;
        int rightIds;
        final rx.j<? super R> subscriber;
        final Map<Integer, T2> rightMap = new HashMap();
        final rx.subscriptions.b group = new rx.subscriptions.b();
        final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public ResultManager(rx.j<? super R> jVar) {
            this.subscriber = jVar;
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.add(bVar);
            this.group.add(dVar);
            OnSubscribeGroupJoin.this.iHb.unsafeSubscribe(bVar);
            OnSubscribeGroupJoin.this.iHc.unsafeSubscribe(dVar);
        }

        @Override // rx.k
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        Map<Integer, rx.e<T2>> leftMap() {
            return this;
        }

        void errorAll(Throwable th) {
            ArrayList<rx.e> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (rx.e eVar : arrayList) {
                eVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        void errorMain(Throwable th) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        void complete(List<rx.e<T2>> list) {
            if (list != null) {
                for (rx.e<T2> eVar : list) {
                    eVar.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class b extends rx.j<T1> {
            b() {
            }

            @Override // rx.e
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject cgH = PublishSubject.cgH();
                    rx.b.e eVar = new rx.b.e(cgH);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), eVar);
                    }
                    rx.d create = rx.d.create(new a(cgH, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.add(aVar);
                    OnSubscribeGroupJoin.this.iHd.call(t1).unsafeSubscribe(aVar);
                    R j = OnSubscribeGroupJoin.this.iHf.j(t1, create);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(j);
                    for (Object obj : arrayList) {
                        eVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }

            @Override // rx.e
            public void onCompleted() {
                ArrayList arrayList = null;
                synchronized (ResultManager.this) {
                    ResultManager.this.leftDone = true;
                    if (ResultManager.this.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class d extends rx.j<T2> {
            d() {
            }

            @Override // rx.e
            public void onNext(T2 t2) {
                int i;
                ArrayList<rx.e> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.add(cVar);
                    OnSubscribeGroupJoin.this.iHe.call(t2).unsafeSubscribe(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (rx.e eVar : arrayList) {
                        eVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }

            @Override // rx.e
            public void onCompleted() {
                ArrayList arrayList = null;
                synchronized (ResultManager.this) {
                    ResultManager.this.rightDone = true;
                    if (ResultManager.this.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }
        }

        /* loaded from: classes2.dex */
        final class a extends rx.j<D1> {
            boolean iGB = true;
            final int id;

            public a(int i) {
                this.id = i;
            }

            @Override // rx.e
            public void onCompleted() {
                rx.e<T2> remove;
                if (this.iGB) {
                    this.iGB = false;
                    synchronized (ResultManager.this) {
                        remove = ResultManager.this.leftMap().remove(Integer.valueOf(this.id));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // rx.e
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        final class c extends rx.j<D2> {
            boolean iGB = true;
            final int id;

            public c(int i) {
                this.id = i;
            }

            @Override // rx.e
            public void onCompleted() {
                if (this.iGB) {
                    this.iGB = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.id));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // rx.e
            public void onNext(D2 d2) {
                onCompleted();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class a<T> implements d.a<T> {
        final RefCountSubscription iHh;
        final rx.d<T> iHi;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(rx.d<T> dVar, RefCountSubscription refCountSubscription) {
            this.iHh = refCountSubscription;
            this.iHi = dVar;
        }

        public void call(rx.j<? super T> jVar) {
            rx.k cgM = this.iHh.cgM();
            C0407a c0407a = new C0407a(jVar, cgM);
            c0407a.add(cgM);
            this.iHi.unsafeSubscribe(c0407a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0407a extends rx.j<T> {
            private final rx.k iHj;
            final rx.j<? super T> subscriber;

            public C0407a(rx.j<? super T> jVar, rx.k kVar) {
                super(jVar);
                this.subscriber = jVar;
                this.iHj = kVar;
            }

            @Override // rx.e
            public void onNext(T t) {
                this.subscriber.onNext(t);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                this.subscriber.onError(th);
                this.iHj.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                this.subscriber.onCompleted();
                this.iHj.unsubscribe();
            }
        }
    }
}
