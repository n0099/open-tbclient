package rx.internal.operators;

import com.baidu.tieba.b6b;
import com.baidu.tieba.c6b;
import com.baidu.tieba.fab;
import com.baidu.tieba.j5b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.n9b;
import com.baidu.tieba.o9b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.v5b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes9.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements j5b.a<R> {
    public final j5b<T1> a;
    public final j5b<T2> b;
    public final b6b<? super T1, ? extends j5b<D1>> c;
    public final b6b<? super T2, ? extends j5b<D2>> d;
    public final c6b<? super T1, ? super j5b<T2>, ? extends R> e;

    /* loaded from: classes9.dex */
    public final class ResultManager extends HashMap<Integer, k5b<T2>> implements q5b {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final p5b<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final fab group = new fab();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, k5b<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes9.dex */
        public final class a extends p5b<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.k5b
            public void onCompleted() {
                k5b<T2> remove;
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

            @Override // com.baidu.tieba.k5b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.k5b
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends p5b<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.k5b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.k5b
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

            @Override // com.baidu.tieba.k5b
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject F = PublishSubject.F();
                    n9b n9bVar = new n9b(F);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), n9bVar);
                    }
                    j5b a = j5b.a(new a(F, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).D(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        n9bVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    v5b.f(th, this);
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class c extends p5b<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.k5b
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.k5b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.k5b
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class d extends p5b<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.k5b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.k5b
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

            @Override // com.baidu.tieba.k5b
            public void onNext(T2 t2) {
                int i;
                ArrayList<k5b> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.d.call(t2).D(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (k5b k5bVar : arrayList) {
                        k5bVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    v5b.f(th, this);
                }
            }
        }

        public ResultManager(p5b<? super R> p5bVar) {
            this.subscriber = p5bVar;
        }

        public void complete(List<k5b<T2>> list) {
            if (list != null) {
                for (k5b<T2> k5bVar : list) {
                    k5bVar.onCompleted();
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
            ArrayList<k5b> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (k5b k5bVar : arrayList) {
                k5bVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.a(bVar);
            this.group.a(dVar);
            OnSubscribeGroupJoin.this.a.D(bVar);
            OnSubscribeGroupJoin.this.b.D(dVar);
        }

        @Override // com.baidu.tieba.q5b
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.q5b
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T> implements j5b.a<T> {
        public final RefCountSubscription a;
        public final j5b<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C0748a extends p5b<T> {
            public final p5b<? super T> e;
            public final q5b f;

            public C0748a(a aVar, p5b<? super T> p5bVar, q5b q5bVar) {
                super(p5bVar);
                this.e = p5bVar;
                this.f = q5bVar;
            }

            @Override // com.baidu.tieba.k5b
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.k5b
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.k5b
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(j5b<T> j5bVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = j5bVar;
        }

        public void call(p5b<? super T> p5bVar) {
            q5b a = this.a.a();
            C0748a c0748a = new C0748a(this, p5bVar, a);
            c0748a.b(a);
            this.b.D(c0748a);
        }

        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((p5b) ((p5b) obj));
        }
    }

    public void call(p5b<? super R> p5bVar) {
        ResultManager resultManager = new ResultManager(new o9b(p5bVar));
        p5bVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
    }
}
