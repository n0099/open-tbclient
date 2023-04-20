package rx.internal.operators;

import com.baidu.tieba.f2b;
import com.baidu.tieba.g2b;
import com.baidu.tieba.h6b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.z1b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes9.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements n1b.a<R> {
    public final n1b<T1> a;
    public final n1b<T2> b;
    public final f2b<? super T1, ? extends n1b<D1>> c;
    public final f2b<? super T2, ? extends n1b<D2>> d;
    public final g2b<? super T1, ? super n1b<T2>, ? extends R> e;

    /* loaded from: classes9.dex */
    public final class ResultManager extends HashMap<Integer, o1b<T2>> implements u1b {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final t1b<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final h6b group = new h6b();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, o1b<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes9.dex */
        public final class a extends t1b<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.o1b
            public void onCompleted() {
                o1b<T2> remove;
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

            @Override // com.baidu.tieba.o1b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.o1b
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends t1b<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.o1b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.o1b
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

            @Override // com.baidu.tieba.o1b
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject D = PublishSubject.D();
                    p5b p5bVar = new p5b(D);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), p5bVar);
                    }
                    n1b a = n1b.a(new a(D, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).B(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        p5bVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    z1b.f(th, this);
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class c extends t1b<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.o1b
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.o1b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.o1b
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class d extends t1b<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.o1b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.o1b
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

            @Override // com.baidu.tieba.o1b
            public void onNext(T2 t2) {
                int i;
                ArrayList<o1b> arrayList;
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
                    for (o1b o1bVar : arrayList) {
                        o1bVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    z1b.f(th, this);
                }
            }
        }

        public ResultManager(t1b<? super R> t1bVar) {
            this.subscriber = t1bVar;
        }

        public void complete(List<o1b<T2>> list) {
            if (list != null) {
                for (o1b<T2> o1bVar : list) {
                    o1bVar.onCompleted();
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
            ArrayList<o1b> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (o1b o1bVar : arrayList) {
                o1bVar.onError(th);
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

        @Override // com.baidu.tieba.u1b
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.u1b
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T> implements n1b.a<T> {
        public final RefCountSubscription a;
        public final n1b<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C0745a extends t1b<T> {
            public final t1b<? super T> e;
            public final u1b f;

            public C0745a(a aVar, t1b<? super T> t1bVar, u1b u1bVar) {
                super(t1bVar);
                this.e = t1bVar;
                this.f = u1bVar;
            }

            @Override // com.baidu.tieba.o1b
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.o1b
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.o1b
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(n1b<T> n1bVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = n1bVar;
        }

        public void call(t1b<? super T> t1bVar) {
            u1b a = this.a.a();
            C0745a c0745a = new C0745a(this, t1bVar, a);
            c0745a.b(a);
            this.b.B(c0745a);
        }

        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t1b) ((t1b) obj));
        }
    }

    public void call(t1b<? super R> t1bVar) {
        ResultManager resultManager = new ResultManager(new q5b(t1bVar));
        t1bVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((t1b) ((t1b) obj));
    }
}
