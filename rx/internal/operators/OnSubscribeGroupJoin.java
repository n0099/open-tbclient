package rx.internal.operators;

import com.baidu.tieba.ckc;
import com.baidu.tieba.dkc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.moc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.unc;
import com.baidu.tieba.vjc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements jjc.a<R> {
    public final jjc<T1> a;
    public final jjc<T2> b;
    public final ckc<? super T1, ? extends jjc<D1>> c;
    public final ckc<? super T2, ? extends jjc<D2>> d;
    public final dkc<? super T1, ? super jjc<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, kjc<T2>> implements qjc {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final pjc<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final moc group = new moc();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, kjc<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends pjc<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.kjc
            public void onCompleted() {
                kjc<T2> remove;
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

            @Override // com.baidu.tieba.kjc
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.kjc
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends pjc<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.kjc
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.kjc
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

            @Override // com.baidu.tieba.kjc
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    unc uncVar = new unc(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), uncVar);
                    }
                    jjc d = jjc.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R a = OnSubscribeGroupJoin.this.e.a(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(a);
                    for (Object obj : arrayList) {
                        uncVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    vjc.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends pjc<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.kjc
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.kjc
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.kjc
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends pjc<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.kjc
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.kjc
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

            @Override // com.baidu.tieba.kjc
            public void onNext(T2 t2) {
                int i;
                ArrayList<kjc> arrayList;
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
                    for (kjc kjcVar : arrayList) {
                        kjcVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    vjc.f(th, this);
                }
            }
        }

        public ResultManager(pjc<? super R> pjcVar) {
            this.subscriber = pjcVar;
        }

        public void complete(List<kjc<T2>> list) {
            if (list != null) {
                for (kjc<T2> kjcVar : list) {
                    kjcVar.onCompleted();
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
            ArrayList<kjc> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (kjc kjcVar : arrayList) {
                kjcVar.onError(th);
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

        @Override // com.baidu.tieba.qjc
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.qjc
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements jjc.a<T> {
        public final RefCountSubscription a;
        public final jjc<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0730a extends pjc<T> {
            public final pjc<? super T> e;
            public final qjc f;

            public C0730a(a aVar, pjc<? super T> pjcVar, qjc qjcVar) {
                super(pjcVar);
                this.e = pjcVar;
                this.f = qjcVar;
            }

            @Override // com.baidu.tieba.kjc
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.kjc
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.kjc
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(jjc<T> jjcVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = jjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xjc
        /* renamed from: a */
        public void call(pjc<? super T> pjcVar) {
            qjc a = this.a.a();
            C0730a c0730a = new C0730a(this, pjcVar, a);
            c0730a.b(a);
            this.b.O(c0730a);
        }
    }
}
