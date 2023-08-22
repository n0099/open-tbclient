package rx.internal.operators;

import com.baidu.tieba.g8c;
import com.baidu.tieba.h8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.occ;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.wbc;
import com.baidu.tieba.xbc;
import com.baidu.tieba.z7c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements n7c.a<R> {
    public final n7c<T1> a;
    public final n7c<T2> b;
    public final g8c<? super T1, ? extends n7c<D1>> c;
    public final g8c<? super T2, ? extends n7c<D2>> d;
    public final h8c<? super T1, ? super n7c<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, o7c<T2>> implements u7c {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final t7c<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final occ group = new occ();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, o7c<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends t7c<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                o7c<T2> remove;
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

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.o7c
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends t7c<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.o7c
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

            @Override // com.baidu.tieba.o7c
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    wbc wbcVar = new wbc(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), wbcVar);
                    }
                    n7c d = n7c.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        wbcVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    z7c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends t7c<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.o7c
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends t7c<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.o7c
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

            @Override // com.baidu.tieba.o7c
            public void onNext(T2 t2) {
                int i;
                ArrayList<o7c> arrayList;
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
                    for (o7c o7cVar : arrayList) {
                        o7cVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    z7c.f(th, this);
                }
            }
        }

        public ResultManager(t7c<? super R> t7cVar) {
            this.subscriber = t7cVar;
        }

        public void complete(List<o7c<T2>> list) {
            if (list != null) {
                for (o7c<T2> o7cVar : list) {
                    o7cVar.onCompleted();
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
            ArrayList<o7c> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (o7c o7cVar : arrayList) {
                o7cVar.onError(th);
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

        @Override // com.baidu.tieba.u7c
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u7c
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements n7c.a<T> {
        public final RefCountSubscription a;
        public final n7c<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0800a extends t7c<T> {
            public final t7c<? super T> e;
            public final u7c f;

            public C0800a(a aVar, t7c<? super T> t7cVar, u7c u7cVar) {
                super(t7cVar);
                this.e = t7cVar;
                this.f = u7cVar;
            }

            @Override // com.baidu.tieba.o7c
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.o7c
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.o7c
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(n7c<T> n7cVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = n7cVar;
        }

        public void call(t7c<? super T> t7cVar) {
            u7c a = this.a.a();
            C0800a c0800a = new C0800a(this, t7cVar, a);
            c0800a.b(a);
            this.b.O(c0800a);
        }

        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t7c) ((t7c) obj));
        }
    }

    public void call(t7c<? super R> t7cVar) {
        ResultManager resultManager = new ResultManager(new xbc(t7cVar));
        t7cVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t7c) ((t7c) obj));
    }
}
