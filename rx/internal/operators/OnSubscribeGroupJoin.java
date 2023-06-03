package rx.internal.operators;

import com.baidu.tieba.anb;
import com.baidu.tieba.bnb;
import com.baidu.tieba.frb;
import com.baidu.tieba.imb;
import com.baidu.tieba.jmb;
import com.baidu.tieba.nqb;
import com.baidu.tieba.omb;
import com.baidu.tieba.oqb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.umb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements imb.a<R> {
    public final imb<T1> a;
    public final imb<T2> b;
    public final anb<? super T1, ? extends imb<D1>> c;
    public final anb<? super T2, ? extends imb<D2>> d;
    public final bnb<? super T1, ? super imb<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, jmb<T2>> implements pmb {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final omb<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final frb group = new frb();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, jmb<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends omb<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.jmb
            public void onCompleted() {
                jmb<T2> remove;
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

            @Override // com.baidu.tieba.jmb
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.jmb
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends omb<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.jmb
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.jmb
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

            @Override // com.baidu.tieba.jmb
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject H = PublishSubject.H();
                    nqb nqbVar = new nqb(H);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), nqbVar);
                    }
                    imb a = imb.a(new a(H, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).F(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        nqbVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    umb.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends omb<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.jmb
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.jmb
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.jmb
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends omb<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.jmb
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.jmb
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

            @Override // com.baidu.tieba.jmb
            public void onNext(T2 t2) {
                int i;
                ArrayList<jmb> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.d.call(t2).F(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (jmb jmbVar : arrayList) {
                        jmbVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    umb.f(th, this);
                }
            }
        }

        public ResultManager(omb<? super R> ombVar) {
            this.subscriber = ombVar;
        }

        public void complete(List<jmb<T2>> list) {
            if (list != null) {
                for (jmb<T2> jmbVar : list) {
                    jmbVar.onCompleted();
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
            ArrayList<jmb> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (jmb jmbVar : arrayList) {
                jmbVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.a(bVar);
            this.group.a(dVar);
            OnSubscribeGroupJoin.this.a.F(bVar);
            OnSubscribeGroupJoin.this.b.F(dVar);
        }

        @Override // com.baidu.tieba.pmb
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.pmb
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements imb.a<T> {
        public final RefCountSubscription a;
        public final imb<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0783a extends omb<T> {
            public final omb<? super T> e;
            public final pmb f;

            public C0783a(a aVar, omb<? super T> ombVar, pmb pmbVar) {
                super(ombVar);
                this.e = ombVar;
                this.f = pmbVar;
            }

            @Override // com.baidu.tieba.jmb
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.jmb
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.jmb
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(imb<T> imbVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = imbVar;
        }

        public void call(omb<? super T> ombVar) {
            pmb a = this.a.a();
            C0783a c0783a = new C0783a(this, ombVar, a);
            c0783a.b(a);
            this.b.F(c0783a);
        }

        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((omb) ((omb) obj));
        }
    }

    public void call(omb<? super R> ombVar) {
        ResultManager resultManager = new ResultManager(new oqb(ombVar));
        ombVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((omb) ((omb) obj));
    }
}
