package rx.internal.operators;

import com.baidu.tieba.bfc;
import com.baidu.tieba.cfc;
import com.baidu.tieba.ebc;
import com.baidu.tieba.lbc;
import com.baidu.tieba.mbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.tfc;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements sac.a<R> {
    public final sac<T1> a;
    public final sac<T2> b;
    public final lbc<? super T1, ? extends sac<D1>> c;
    public final lbc<? super T2, ? extends sac<D2>> d;
    public final mbc<? super T1, ? super sac<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, tac<T2>> implements zac {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final yac<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final tfc group = new tfc();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, tac<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends yac<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                tac<T2> remove;
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

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.tac
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends yac<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.tac
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

            @Override // com.baidu.tieba.tac
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    bfc bfcVar = new bfc(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), bfcVar);
                    }
                    sac d = sac.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        bfcVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    ebc.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends yac<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.tac
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends yac<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.tac
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

            @Override // com.baidu.tieba.tac
            public void onNext(T2 t2) {
                int i;
                ArrayList<tac> arrayList;
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
                    for (tac tacVar : arrayList) {
                        tacVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    ebc.f(th, this);
                }
            }
        }

        public ResultManager(yac<? super R> yacVar) {
            this.subscriber = yacVar;
        }

        public void complete(List<tac<T2>> list) {
            if (list != null) {
                for (tac<T2> tacVar : list) {
                    tacVar.onCompleted();
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
            ArrayList<tac> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (tac tacVar : arrayList) {
                tacVar.onError(th);
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

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements sac.a<T> {
        public final RefCountSubscription a;
        public final sac<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0796a extends yac<T> {
            public final yac<? super T> e;
            public final zac f;

            public C0796a(a aVar, yac<? super T> yacVar, zac zacVar) {
                super(yacVar);
                this.e = yacVar;
                this.f = zacVar;
            }

            @Override // com.baidu.tieba.tac
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.tac
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(sac<T> sacVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = sacVar;
        }

        public void call(yac<? super T> yacVar) {
            zac a = this.a.a();
            C0796a c0796a = new C0796a(this, yacVar, a);
            c0796a.b(a);
            this.b.O(c0796a);
        }

        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yac) ((yac) obj));
        }
    }

    public void call(yac<? super R> yacVar) {
        ResultManager resultManager = new ResultManager(new cfc(yacVar));
        yacVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
