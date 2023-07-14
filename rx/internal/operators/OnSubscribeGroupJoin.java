package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.c6c;
import com.baidu.tieba.d6c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.m2c;
import com.baidu.tieba.n2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.u6c;
import com.baidu.tieba.v1c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements u1c.a<R> {
    public final u1c<T1> a;
    public final u1c<T2> b;
    public final m2c<? super T1, ? extends u1c<D1>> c;
    public final m2c<? super T2, ? extends u1c<D2>> d;
    public final n2c<? super T1, ? super u1c<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, v1c<T2>> implements b2c {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final a2c<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final u6c group = new u6c();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, v1c<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends a2c<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                v1c<T2> remove;
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

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends a2c<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.v1c
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

            @Override // com.baidu.tieba.v1c
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    c6c c6cVar = new c6c(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), c6cVar);
                    }
                    u1c d = u1c.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        c6cVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    g2c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends a2c<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends a2c<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.v1c
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

            @Override // com.baidu.tieba.v1c
            public void onNext(T2 t2) {
                int i;
                ArrayList<v1c> arrayList;
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
                    for (v1c v1cVar : arrayList) {
                        v1cVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    g2c.f(th, this);
                }
            }
        }

        public ResultManager(a2c<? super R> a2cVar) {
            this.subscriber = a2cVar;
        }

        public void complete(List<v1c<T2>> list) {
            if (list != null) {
                for (v1c<T2> v1cVar : list) {
                    v1cVar.onCompleted();
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
            ArrayList<v1c> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (v1c v1cVar : arrayList) {
                v1cVar.onError(th);
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

        @Override // com.baidu.tieba.b2c
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.b2c
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements u1c.a<T> {
        public final RefCountSubscription a;
        public final u1c<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0799a extends a2c<T> {
            public final a2c<? super T> e;
            public final b2c f;

            public C0799a(a aVar, a2c<? super T> a2cVar, b2c b2cVar) {
                super(a2cVar);
                this.e = a2cVar;
                this.f = b2cVar;
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(u1c<T> u1cVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = u1cVar;
        }

        public void call(a2c<? super T> a2cVar) {
            b2c a = this.a.a();
            C0799a c0799a = new C0799a(this, a2cVar, a);
            c0799a.b(a);
            this.b.O(c0799a);
        }

        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((a2c) ((a2c) obj));
        }
    }

    public void call(a2c<? super R> a2cVar) {
        ResultManager resultManager = new ResultManager(new d6c(a2cVar));
        a2cVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
