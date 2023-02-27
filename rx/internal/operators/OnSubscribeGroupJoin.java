package rx.internal.operators;

import com.baidu.tieba.ena;
import com.baidu.tieba.kna;
import com.baidu.tieba.lna;
import com.baidu.tieba.mra;
import com.baidu.tieba.sma;
import com.baidu.tieba.tma;
import com.baidu.tieba.uqa;
import com.baidu.tieba.vqa;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes9.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements sma.a<R> {
    public final sma<T1> a;
    public final sma<T2> b;
    public final kna<? super T1, ? extends sma<D1>> c;
    public final kna<? super T2, ? extends sma<D2>> d;
    public final lna<? super T1, ? super sma<T2>, ? extends R> e;

    /* loaded from: classes9.dex */
    public final class ResultManager extends HashMap<Integer, tma<T2>> implements zma {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final yma<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final mra group = new mra();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, tma<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes9.dex */
        public final class a extends yma<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.tma
            public void onCompleted() {
                tma<T2> remove;
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        remove = ResultManager.this.leftMap().remove(Integer.valueOf(this.e));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.tma
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.tma
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends yma<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.tma
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.tma
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

            @Override // com.baidu.tieba.tma
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject D = PublishSubject.D();
                    uqa uqaVar = new uqa(D);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), uqaVar);
                    }
                    sma a = sma.a(new a(D, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).B(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        uqaVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    ena.f(th, this);
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class c extends yma<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.tma
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.tma
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.tma
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class d extends yma<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.tma
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.tma
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

            @Override // com.baidu.tieba.tma
            public void onNext(T2 t2) {
                int i;
                ArrayList<tma> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.d.call(t2).B(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (tma tmaVar : arrayList) {
                        tmaVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    ena.f(th, this);
                }
            }
        }

        public ResultManager(yma<? super R> ymaVar) {
            this.subscriber = ymaVar;
        }

        public void complete(List<tma<T2>> list) {
            if (list != null) {
                for (tma<T2> tmaVar : list) {
                    tmaVar.onCompleted();
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
            ArrayList<tma> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (tma tmaVar : arrayList) {
                tmaVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.a(bVar);
            this.group.a(dVar);
            OnSubscribeGroupJoin.this.a.B(bVar);
            OnSubscribeGroupJoin.this.b.B(dVar);
        }

        @Override // com.baidu.tieba.zma
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.zma
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T> implements sma.a<T> {
        public final RefCountSubscription a;
        public final sma<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C0738a extends yma<T> {
            public final yma<? super T> e;
            public final zma f;

            public C0738a(a aVar, yma<? super T> ymaVar, zma zmaVar) {
                super(ymaVar);
                this.e = ymaVar;
                this.f = zmaVar;
            }

            @Override // com.baidu.tieba.tma
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.tma
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.tma
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(sma<T> smaVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = smaVar;
        }

        public void call(yma<? super T> ymaVar) {
            zma a = this.a.a();
            C0738a c0738a = new C0738a(this, ymaVar, a);
            c0738a.b(a);
            this.b.B(c0738a);
        }

        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yma) ((yma) obj));
        }
    }

    public void call(yma<? super R> ymaVar) {
        ResultManager resultManager = new ResultManager(new vqa(ymaVar));
        ymaVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yma) ((yma) obj));
    }
}
