package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.gtc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.osc;
import com.baidu.tieba.poc;
import com.baidu.tieba.woc;
import com.baidu.tieba.xoc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes2.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements doc.a<R> {
    public final doc<T1> a;
    public final doc<T2> b;
    public final woc<? super T1, ? extends doc<D1>> c;
    public final woc<? super T2, ? extends doc<D2>> d;
    public final xoc<? super T1, ? super doc<T2>, ? extends R> e;

    /* loaded from: classes2.dex */
    public final class ResultManager extends HashMap<Integer, eoc<T2>> implements koc {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final joc<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final gtc group = new gtc();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, eoc<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends joc<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.eoc
            public void onCompleted() {
                eoc<T2> remove;
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

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.eoc
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends joc<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.eoc
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

            @Override // com.baidu.tieba.eoc
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject Q = PublishSubject.Q();
                    osc oscVar = new osc(Q);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), oscVar);
                    }
                    doc d = doc.d(new a(Q, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).O(aVar);
                    R a = OnSubscribeGroupJoin.this.e.a(t1, d);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(a);
                    for (Object obj : arrayList) {
                        oscVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    poc.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class c extends joc<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.eoc
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.d(this);
                }
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.eoc
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes2.dex */
        public final class d extends joc<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.eoc
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

            @Override // com.baidu.tieba.eoc
            public void onNext(T2 t2) {
                int i;
                ArrayList<eoc> arrayList;
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
                    for (eoc eocVar : arrayList) {
                        eocVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    poc.f(th, this);
                }
            }
        }

        public ResultManager(joc<? super R> jocVar) {
            this.subscriber = jocVar;
        }

        public void complete(List<eoc<T2>> list) {
            if (list != null) {
                for (eoc<T2> eocVar : list) {
                    eocVar.onCompleted();
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
            ArrayList<eoc> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (eoc eocVar : arrayList) {
                eocVar.onError(th);
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

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> implements doc.a<T> {
        public final RefCountSubscription a;
        public final doc<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0770a extends joc<T> {
            public final joc<? super T> e;
            public final koc f;

            public C0770a(a aVar, joc<? super T> jocVar, koc kocVar) {
                super(jocVar);
                this.e = jocVar;
                this.f = kocVar;
            }

            @Override // com.baidu.tieba.eoc
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.eoc
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(doc<T> docVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = docVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super T> jocVar) {
            koc a = this.a.a();
            C0770a c0770a = new C0770a(this, jocVar, a);
            c0770a.b(a);
            this.b.O(c0770a);
        }
    }
}
