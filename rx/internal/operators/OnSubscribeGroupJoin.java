package rx.internal.operators;

import com.baidu.tieba.a7c;
import com.baidu.tieba.b7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.i6c;
import com.baidu.tieba.kbc;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.sac;
import com.baidu.tieba.t6c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements h6c.a<R> {
    public final h6c<T1> a;
    public final h6c<T2> b;
    public final a7c<? super T1, ? extends h6c<D1>> c;
    public final a7c<? super T2, ? extends h6c<D2>> d;
    public final b7c<? super T1, ? super h6c<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, i6c<T2>> implements o6c {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final n6c<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final kbc group = new kbc();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, i6c<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends n6c<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.i6c
            public void onCompleted() {
                i6c<T2> remove;
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

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.i6c
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends n6c<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.i6c
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

            @Override // com.baidu.tieba.i6c
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    sac sacVar = new sac(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), sacVar);
                    }
                    h6c d = h6c.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R a = OnSubscribeGroupJoin.this.e.a(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(a);
                    for (Object obj : arrayList) {
                        sacVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    t6c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends n6c<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.i6c
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.i6c
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends n6c<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.i6c
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

            @Override // com.baidu.tieba.i6c
            public void onNext(T2 t2) {
                int i;
                ArrayList<i6c> arrayList;
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
                    for (i6c i6cVar : arrayList) {
                        i6cVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    t6c.f(th, this);
                }
            }
        }

        public ResultManager(n6c<? super R> n6cVar) {
            this.subscriber = n6cVar;
        }

        public void complete(List<i6c<T2>> list) {
            if (list != null) {
                for (i6c<T2> i6cVar : list) {
                    i6cVar.onCompleted();
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
            ArrayList<i6c> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (i6c i6cVar : arrayList) {
                i6cVar.onError(th);
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

        @Override // com.baidu.tieba.o6c
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.o6c
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements h6c.a<T> {
        public final RefCountSubscription a;
        public final h6c<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0724a extends n6c<T> {
            public final n6c<? super T> e;
            public final o6c f;

            public C0724a(a aVar, n6c<? super T> n6cVar, o6c o6cVar) {
                super(n6cVar);
                this.e = n6cVar;
                this.f = o6cVar;
            }

            @Override // com.baidu.tieba.i6c
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.i6c
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(h6c<T> h6cVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = h6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super T> n6cVar) {
            o6c a = this.a.a();
            C0724a c0724a = new C0724a(this, n6cVar, a);
            c0724a.b(a);
            this.b.O(c0724a);
        }
    }
}
