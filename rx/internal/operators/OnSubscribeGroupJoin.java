package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.fxb;
import com.baidu.tieba.gxb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.ptb;
import com.baidu.tieba.qtb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.xxb;
import com.baidu.tieba.ysb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements xsb.a<R> {
    public final xsb<T1> a;
    public final xsb<T2> b;
    public final ptb<? super T1, ? extends xsb<D1>> c;
    public final ptb<? super T2, ? extends xsb<D2>> d;
    public final qtb<? super T1, ? super xsb<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, ysb<T2>> implements etb {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final dtb<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final xxb group = new xxb();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, ysb<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends dtb<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.ysb
            public void onCompleted() {
                ysb<T2> remove;
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

            @Override // com.baidu.tieba.ysb
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.ysb
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends dtb<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.ysb
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.ysb
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

            @Override // com.baidu.tieba.ysb
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject O = PublishSubject.O();
                    fxb fxbVar = new fxb(O);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), fxbVar);
                    }
                    xsb d = xsb.d(new a(O, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).M(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        fxbVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    jtb.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends dtb<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.ysb
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.ysb
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.ysb
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends dtb<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.ysb
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.ysb
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

            @Override // com.baidu.tieba.ysb
            public void onNext(T2 t2) {
                int i;
                ArrayList<ysb> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.rightIds;
                        resultManager.rightIds = i + 1;
                        ResultManager.this.rightMap.put(Integer.valueOf(i), t2);
                    }
                    c cVar = new c(i);
                    ResultManager.this.group.a(cVar);
                    OnSubscribeGroupJoin.this.d.call(t2).M(cVar);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                    }
                    for (ysb ysbVar : arrayList) {
                        ysbVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    jtb.f(th, this);
                }
            }
        }

        public ResultManager(dtb<? super R> dtbVar) {
            this.subscriber = dtbVar;
        }

        public void complete(List<ysb<T2>> list) {
            if (list != null) {
                for (ysb<T2> ysbVar : list) {
                    ysbVar.onCompleted();
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
            ArrayList<ysb> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (ysb ysbVar : arrayList) {
                ysbVar.onError(th);
            }
            this.subscriber.onError(th);
            this.cancel.unsubscribe();
        }

        public void init() {
            b bVar = new b();
            d dVar = new d();
            this.group.a(bVar);
            this.group.a(dVar);
            OnSubscribeGroupJoin.this.a.M(bVar);
            OnSubscribeGroupJoin.this.b.M(dVar);
        }

        @Override // com.baidu.tieba.etb
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.etb
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements xsb.a<T> {
        public final RefCountSubscription a;
        public final xsb<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0794a extends dtb<T> {
            public final dtb<? super T> e;
            public final etb f;

            public C0794a(a aVar, dtb<? super T> dtbVar, etb etbVar) {
                super(dtbVar);
                this.e = dtbVar;
                this.f = etbVar;
            }

            @Override // com.baidu.tieba.ysb
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.ysb
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.ysb
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(xsb<T> xsbVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = xsbVar;
        }

        public void call(dtb<? super T> dtbVar) {
            etb a = this.a.a();
            C0794a c0794a = new C0794a(this, dtbVar, a);
            c0794a.b(a);
            this.b.M(c0794a);
        }

        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dtb) ((dtb) obj));
        }
    }

    public void call(dtb<? super R> dtbVar) {
        ResultManager resultManager = new ResultManager(new gxb(dtbVar));
        dtbVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dtb) ((dtb) obj));
    }
}
