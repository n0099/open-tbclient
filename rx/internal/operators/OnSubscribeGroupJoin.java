package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f5c;
import com.baidu.tieba.g5c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.p1c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.x5c;
import com.baidu.tieba.y0c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements x0c.a<R> {
    public final x0c<T1> a;
    public final x0c<T2> b;
    public final p1c<? super T1, ? extends x0c<D1>> c;
    public final p1c<? super T2, ? extends x0c<D2>> d;
    public final q1c<? super T1, ? super x0c<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, y0c<T2>> implements e1c {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final d1c<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final x5c group = new x5c();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, y0c<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends d1c<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.y0c
            public void onCompleted() {
                y0c<T2> remove;
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

            @Override // com.baidu.tieba.y0c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.y0c
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends d1c<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.y0c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.y0c
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

            @Override // com.baidu.tieba.y0c
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    f5c f5cVar = new f5c(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), f5cVar);
                    }
                    x0c d = x0c.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        f5cVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    j1c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends d1c<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.y0c
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.y0c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.y0c
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends d1c<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.y0c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.y0c
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

            @Override // com.baidu.tieba.y0c
            public void onNext(T2 t2) {
                int i;
                ArrayList<y0c> arrayList;
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
                    for (y0c y0cVar : arrayList) {
                        y0cVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    j1c.f(th, this);
                }
            }
        }

        public ResultManager(d1c<? super R> d1cVar) {
            this.subscriber = d1cVar;
        }

        public void complete(List<y0c<T2>> list) {
            if (list != null) {
                for (y0c<T2> y0cVar : list) {
                    y0cVar.onCompleted();
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
            ArrayList<y0c> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (y0c y0cVar : arrayList) {
                y0cVar.onError(th);
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

        @Override // com.baidu.tieba.e1c
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.e1c
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements x0c.a<T> {
        public final RefCountSubscription a;
        public final x0c<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0800a extends d1c<T> {
            public final d1c<? super T> e;
            public final e1c f;

            public C0800a(a aVar, d1c<? super T> d1cVar, e1c e1cVar) {
                super(d1cVar);
                this.e = d1cVar;
                this.f = e1cVar;
            }

            @Override // com.baidu.tieba.y0c
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.y0c
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.y0c
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(x0c<T> x0cVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = x0cVar;
        }

        public void call(d1c<? super T> d1cVar) {
            e1c a = this.a.a();
            C0800a c0800a = new C0800a(this, d1cVar, a);
            c0800a.b(a);
            this.b.O(c0800a);
        }

        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((d1c) ((d1c) obj));
        }
    }

    public void call(d1c<? super R> d1cVar) {
        ResultManager resultManager = new ResultManager(new g5c(d1cVar));
        d1cVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((d1c) ((d1c) obj));
    }
}
