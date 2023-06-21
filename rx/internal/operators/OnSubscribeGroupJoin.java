package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.gob;
import com.baidu.tieba.hob;
import com.baidu.tieba.lsb;
import com.baidu.tieba.mob;
import com.baidu.tieba.msb;
import com.baidu.tieba.nob;
import com.baidu.tieba.sob;
import com.baidu.tieba.yob;
import com.baidu.tieba.zob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements gob.a<R> {
    public final gob<T1> a;
    public final gob<T2> b;
    public final yob<? super T1, ? extends gob<D1>> c;
    public final yob<? super T2, ? extends gob<D2>> d;
    public final zob<? super T1, ? super gob<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, hob<T2>> implements nob {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final mob<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final dtb group = new dtb();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, hob<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends mob<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.hob
            public void onCompleted() {
                hob<T2> remove;
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

            @Override // com.baidu.tieba.hob
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.hob
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends mob<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.hob
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.hob
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

            @Override // com.baidu.tieba.hob
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject H = PublishSubject.H();
                    lsb lsbVar = new lsb(H);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), lsbVar);
                    }
                    gob a = gob.a(new a(H, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).F(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        lsbVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    sob.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends mob<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.hob
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.hob
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.hob
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends mob<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.hob
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.hob
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

            @Override // com.baidu.tieba.hob
            public void onNext(T2 t2) {
                int i;
                ArrayList<hob> arrayList;
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
                    for (hob hobVar : arrayList) {
                        hobVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    sob.f(th, this);
                }
            }
        }

        public ResultManager(mob<? super R> mobVar) {
            this.subscriber = mobVar;
        }

        public void complete(List<hob<T2>> list) {
            if (list != null) {
                for (hob<T2> hobVar : list) {
                    hobVar.onCompleted();
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
            ArrayList<hob> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (hob hobVar : arrayList) {
                hobVar.onError(th);
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

        @Override // com.baidu.tieba.nob
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.nob
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements gob.a<T> {
        public final RefCountSubscription a;
        public final gob<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0784a extends mob<T> {
            public final mob<? super T> e;
            public final nob f;

            public C0784a(a aVar, mob<? super T> mobVar, nob nobVar) {
                super(mobVar);
                this.e = mobVar;
                this.f = nobVar;
            }

            @Override // com.baidu.tieba.hob
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.hob
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.hob
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(gob<T> gobVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = gobVar;
        }

        public void call(mob<? super T> mobVar) {
            nob a = this.a.a();
            C0784a c0784a = new C0784a(this, mobVar, a);
            c0784a.b(a);
            this.b.F(c0784a);
        }

        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mob) ((mob) obj));
        }
    }

    public void call(mob<? super R> mobVar) {
        ResultManager resultManager = new ResultManager(new msb(mobVar));
        mobVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mob) ((mob) obj));
    }
}
