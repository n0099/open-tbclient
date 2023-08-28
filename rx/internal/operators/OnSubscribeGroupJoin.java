package rx.internal.operators;

import com.baidu.tieba.b8c;
import com.baidu.tieba.i8c;
import com.baidu.tieba.j8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.qcc;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import com.baidu.tieba.ybc;
import com.baidu.tieba.zbc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements p7c.a<R> {
    public final p7c<T1> a;
    public final p7c<T2> b;
    public final i8c<? super T1, ? extends p7c<D1>> c;
    public final i8c<? super T2, ? extends p7c<D2>> d;
    public final j8c<? super T1, ? super p7c<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, q7c<T2>> implements w7c {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final v7c<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final qcc group = new qcc();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, q7c<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends v7c<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.q7c
            public void onCompleted() {
                q7c<T2> remove;
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

            @Override // com.baidu.tieba.q7c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.q7c
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends v7c<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.q7c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.q7c
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

            @Override // com.baidu.tieba.q7c
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    ybc ybcVar = new ybc(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), ybcVar);
                    }
                    p7c d = p7c.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        ybcVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    b8c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends v7c<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.q7c
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.q7c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.q7c
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends v7c<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.q7c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.q7c
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

            @Override // com.baidu.tieba.q7c
            public void onNext(T2 t2) {
                int i;
                ArrayList<q7c> arrayList;
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
                    for (q7c q7cVar : arrayList) {
                        q7cVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    b8c.f(th, this);
                }
            }
        }

        public ResultManager(v7c<? super R> v7cVar) {
            this.subscriber = v7cVar;
        }

        public void complete(List<q7c<T2>> list) {
            if (list != null) {
                for (q7c<T2> q7cVar : list) {
                    q7cVar.onCompleted();
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
            ArrayList<q7c> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (q7c q7cVar : arrayList) {
                q7cVar.onError(th);
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

        @Override // com.baidu.tieba.w7c
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.w7c
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements p7c.a<T> {
        public final RefCountSubscription a;
        public final p7c<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0801a extends v7c<T> {
            public final v7c<? super T> e;
            public final w7c f;

            public C0801a(a aVar, v7c<? super T> v7cVar, w7c w7cVar) {
                super(v7cVar);
                this.e = v7cVar;
                this.f = w7cVar;
            }

            @Override // com.baidu.tieba.q7c
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.q7c
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.q7c
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(p7c<T> p7cVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = p7cVar;
        }

        public void call(v7c<? super T> v7cVar) {
            w7c a = this.a.a();
            C0801a c0801a = new C0801a(this, v7cVar, a);
            c0801a.b(a);
            this.b.O(c0801a);
        }

        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((v7c) ((v7c) obj));
        }
    }

    public void call(v7c<? super R> v7cVar) {
        ResultManager resultManager = new ResultManager(new zbc(v7cVar));
        v7cVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((v7c) ((v7c) obj));
    }
}
