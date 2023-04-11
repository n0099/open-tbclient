package rx.internal.operators;

import com.baidu.tieba.f1b;
import com.baidu.tieba.g1b;
import com.baidu.tieba.h5b;
import com.baidu.tieba.i5b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.x1b;
import com.baidu.tieba.y1b;
import com.baidu.tieba.z5b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes9.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements f1b.a<R> {
    public final f1b<T1> a;
    public final f1b<T2> b;
    public final x1b<? super T1, ? extends f1b<D1>> c;
    public final x1b<? super T2, ? extends f1b<D2>> d;
    public final y1b<? super T1, ? super f1b<T2>, ? extends R> e;

    /* loaded from: classes9.dex */
    public final class ResultManager extends HashMap<Integer, g1b<T2>> implements m1b {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final l1b<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final z5b group = new z5b();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, g1b<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes9.dex */
        public final class a extends l1b<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.g1b
            public void onCompleted() {
                g1b<T2> remove;
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

            @Override // com.baidu.tieba.g1b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.g1b
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends l1b<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.g1b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.g1b
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

            @Override // com.baidu.tieba.g1b
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject D = PublishSubject.D();
                    h5b h5bVar = new h5b(D);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), h5bVar);
                    }
                    f1b a = f1b.a(new a(D, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).B(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        h5bVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    r1b.f(th, this);
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class c extends l1b<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.g1b
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.g1b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.g1b
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes9.dex */
        public final class d extends l1b<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.g1b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.g1b
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

            @Override // com.baidu.tieba.g1b
            public void onNext(T2 t2) {
                int i;
                ArrayList<g1b> arrayList;
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
                    for (g1b g1bVar : arrayList) {
                        g1bVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    r1b.f(th, this);
                }
            }
        }

        public ResultManager(l1b<? super R> l1bVar) {
            this.subscriber = l1bVar;
        }

        public void complete(List<g1b<T2>> list) {
            if (list != null) {
                for (g1b<T2> g1bVar : list) {
                    g1bVar.onCompleted();
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
            ArrayList<g1b> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (g1b g1bVar : arrayList) {
                g1bVar.onError(th);
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

        @Override // com.baidu.tieba.m1b
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.m1b
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T> implements f1b.a<T> {
        public final RefCountSubscription a;
        public final f1b<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C0746a extends l1b<T> {
            public final l1b<? super T> e;
            public final m1b f;

            public C0746a(a aVar, l1b<? super T> l1bVar, m1b m1bVar) {
                super(l1bVar);
                this.e = l1bVar;
                this.f = m1bVar;
            }

            @Override // com.baidu.tieba.g1b
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.g1b
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.g1b
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(f1b<T> f1bVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = f1bVar;
        }

        public void call(l1b<? super T> l1bVar) {
            m1b a = this.a.a();
            C0746a c0746a = new C0746a(this, l1bVar, a);
            c0746a.b(a);
            this.b.B(c0746a);
        }

        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l1b) ((l1b) obj));
        }
    }

    public void call(l1b<? super R> l1bVar) {
        ResultManager resultManager = new ResultManager(new i5b(l1bVar));
        l1bVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l1b) ((l1b) obj));
    }
}
