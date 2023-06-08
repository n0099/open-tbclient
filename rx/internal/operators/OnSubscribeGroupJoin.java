package rx.internal.operators;

import com.baidu.tieba.fnb;
import com.baidu.tieba.gnb;
import com.baidu.tieba.krb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.sqb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.tqb;
import com.baidu.tieba.umb;
import com.baidu.tieba.zmb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements nmb.a<R> {
    public final nmb<T1> a;
    public final nmb<T2> b;
    public final fnb<? super T1, ? extends nmb<D1>> c;
    public final fnb<? super T2, ? extends nmb<D2>> d;
    public final gnb<? super T1, ? super nmb<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, omb<T2>> implements umb {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final tmb<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final krb group = new krb();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, omb<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends tmb<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.omb
            public void onCompleted() {
                omb<T2> remove;
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

            @Override // com.baidu.tieba.omb
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.omb
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends tmb<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.omb
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.omb
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

            @Override // com.baidu.tieba.omb
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject H = PublishSubject.H();
                    sqb sqbVar = new sqb(H);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), sqbVar);
                    }
                    nmb a = nmb.a(new a(H, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).F(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        sqbVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    zmb.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends tmb<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.omb
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.omb
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.omb
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends tmb<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.omb
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.omb
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

            @Override // com.baidu.tieba.omb
            public void onNext(T2 t2) {
                int i;
                ArrayList<omb> arrayList;
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
                    for (omb ombVar : arrayList) {
                        ombVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    zmb.f(th, this);
                }
            }
        }

        public ResultManager(tmb<? super R> tmbVar) {
            this.subscriber = tmbVar;
        }

        public void complete(List<omb<T2>> list) {
            if (list != null) {
                for (omb<T2> ombVar : list) {
                    ombVar.onCompleted();
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
            ArrayList<omb> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (omb ombVar : arrayList) {
                ombVar.onError(th);
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

        @Override // com.baidu.tieba.umb
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.umb
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements nmb.a<T> {
        public final RefCountSubscription a;
        public final nmb<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0783a extends tmb<T> {
            public final tmb<? super T> e;
            public final umb f;

            public C0783a(a aVar, tmb<? super T> tmbVar, umb umbVar) {
                super(tmbVar);
                this.e = tmbVar;
                this.f = umbVar;
            }

            @Override // com.baidu.tieba.omb
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.omb
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.omb
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(nmb<T> nmbVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = nmbVar;
        }

        public void call(tmb<? super T> tmbVar) {
            umb a = this.a.a();
            C0783a c0783a = new C0783a(this, tmbVar, a);
            c0783a.b(a);
            this.b.F(c0783a);
        }

        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((tmb) ((tmb) obj));
        }
    }

    public void call(tmb<? super R> tmbVar) {
        ResultManager resultManager = new ResultManager(new tqb(tmbVar));
        tmbVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((tmb) ((tmb) obj));
    }
}
