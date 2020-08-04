package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.d;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes6.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {
    final rx.d<T1> okG;
    final rx.d<T2> okH;
    final rx.functions.f<? super T1, ? extends rx.d<D1>> okI;
    final rx.functions.f<? super T2, ? extends rx.d<D2>> okJ;
    final rx.functions.g<? super T1, ? super rx.d<T2>, ? extends R> okK;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super R> jVar) {
        ResultManager resultManager = new ResultManager(new rx.b.e(jVar));
        jVar.add(resultManager);
        resultManager.init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
            OnSubscribeGroupJoin.this.okG.a((rx.j<? super T1>) bVar);
            OnSubscribeGroupJoin.this.okH.a((rx.j<? super T2>) dVar);
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
        /* loaded from: classes6.dex */
        public final class b extends rx.j<T1> {
            b() {
            }

            @Override // rx.e
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject dZe = PublishSubject.dZe();
                    rx.b.d dVar = new rx.b.d(dZe);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), dVar);
                    }
                    rx.d a = rx.d.a((d.a) new a(dZe, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.add(aVar);
                    OnSubscribeGroupJoin.this.okI.call(t1).a((rx.j<? super D1>) aVar);
                    R o = OnSubscribeGroupJoin.this.okK.o(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(o);
                    for (Object obj : arrayList) {
                        dVar.onNext(obj);
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
        /* loaded from: classes6.dex */
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
                    OnSubscribeGroupJoin.this.okJ.call(t2).a((rx.j<? super D2>) cVar);
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

        /* loaded from: classes6.dex */
        final class a extends rx.j<D1> {
            final int id;
            boolean once = true;

            public a(int i) {
                this.id = i;
            }

            @Override // rx.e
            public void onCompleted() {
                rx.e<T2> remove;
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        remove = ResultManager.this.leftMap().remove(Integer.valueOf(this.id));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    ResultManager.this.group.a(this);
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

        /* loaded from: classes6.dex */
        final class c extends rx.j<D2> {
            final int id;
            boolean once = true;

            public c(int i) {
                this.id = i;
            }

            @Override // rx.e
            public void onCompleted() {
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.id));
                    }
                    ResultManager.this.group.a(this);
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

    /* loaded from: classes6.dex */
    static final class a<T> implements d.a<T> {
        final RefCountSubscription okM;
        final rx.d<T> okN;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(rx.d<T> dVar, RefCountSubscription refCountSubscription) {
            this.okM = refCountSubscription;
            this.okN = dVar;
        }

        public void call(rx.j<? super T> jVar) {
            rx.k dZj = this.okM.dZj();
            C0932a c0932a = new C0932a(jVar, dZj);
            c0932a.add(dZj);
            this.okN.a((rx.j) c0932a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public final class C0932a extends rx.j<T> {
            private final rx.k okO;
            final rx.j<? super T> subscriber;

            public C0932a(rx.j<? super T> jVar, rx.k kVar) {
                super(jVar);
                this.subscriber = jVar;
                this.okO = kVar;
            }

            @Override // rx.e
            public void onNext(T t) {
                this.subscriber.onNext(t);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                this.subscriber.onError(th);
                this.okO.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                this.subscriber.onCompleted();
                this.okO.unsubscribe();
            }
        }
    }
}
