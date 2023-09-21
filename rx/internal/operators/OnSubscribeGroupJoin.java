package rx.internal.operators;

import com.baidu.tieba.ddc;
import com.baidu.tieba.edc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.lcc;
import com.baidu.tieba.lhc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.tgc;
import com.baidu.tieba.ugc;
import com.baidu.tieba.wcc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements kcc.a<R> {
    public final kcc<T1> a;
    public final kcc<T2> b;
    public final ddc<? super T1, ? extends kcc<D1>> c;
    public final ddc<? super T2, ? extends kcc<D2>> d;
    public final edc<? super T1, ? super kcc<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, lcc<T2>> implements rcc {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final qcc<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final lhc group = new lhc();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, lcc<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends qcc<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.lcc
            public void onCompleted() {
                lcc<T2> remove;
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        remove = ResultManager.this.leftMap().remove(Integer.valueOf(this.e));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.lcc
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.lcc
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends qcc<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.lcc
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.lcc
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

            @Override // com.baidu.tieba.lcc
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    tgc tgcVar = new tgc(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), tgcVar);
                    }
                    kcc d = kcc.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        tgcVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    wcc.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends qcc<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.lcc
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.lcc
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.lcc
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends qcc<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.lcc
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.lcc
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

            @Override // com.baidu.tieba.lcc
            public void onNext(T2 t2) {
                int i;
                ArrayList<lcc> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.d.call(t2).O(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (lcc lccVar : arrayList) {
                        lccVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    wcc.f(th, this);
                }
            }
        }

        public ResultManager(qcc<? super R> qccVar) {
            this.subscriber = qccVar;
        }

        public void complete(List<lcc<T2>> list) {
            if (list != null) {
                for (lcc<T2> lccVar : list) {
                    lccVar.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        public void errorMain(Throwable th) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void errorAll(Throwable th) {
            ArrayList<lcc> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (lcc lccVar : arrayList) {
                lccVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.a(bVar);
            this.group.a(dVar);
            OnSubscribeGroupJoin.this.a.O(bVar);
            OnSubscribeGroupJoin.this.b.O(dVar);
        }

        @Override // com.baidu.tieba.rcc
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.rcc
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements kcc.a<T> {
        public final RefCountSubscription a;
        public final kcc<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0789a extends qcc<T> {
            public final qcc<? super T> e;
            public final rcc f;

            public C0789a(a aVar, qcc<? super T> qccVar, rcc rccVar) {
                super(qccVar);
                this.e = qccVar;
                this.f = rccVar;
            }

            @Override // com.baidu.tieba.lcc
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.lcc
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.lcc
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(kcc<T> kccVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = kccVar;
        }

        public void call(qcc<? super T> qccVar) {
            rcc a = this.a.a();
            C0789a c0789a = new C0789a(this, qccVar, a);
            c0789a.b(a);
            this.b.O(c0789a);
        }

        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((qcc) ((qcc) obj));
        }
    }

    public void call(qcc<? super R> qccVar) {
        ResultManager resultManager = new ResultManager(new ugc(qccVar));
        qccVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((qcc) ((qcc) obj));
    }
}
