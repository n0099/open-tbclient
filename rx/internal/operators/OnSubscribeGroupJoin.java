package rx.internal.operators;

import com.baidu.tieba.a8b;
import com.baidu.tieba.b8b;
import com.baidu.tieba.fcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.nbb;
import com.baidu.tieba.o7b;
import com.baidu.tieba.obb;
import com.baidu.tieba.p7b;
import com.baidu.tieba.u7b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes10.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements i7b.a<R> {
    public final i7b<T1> a;
    public final i7b<T2> b;
    public final a8b<? super T1, ? extends i7b<D1>> c;
    public final a8b<? super T2, ? extends i7b<D2>> d;
    public final b8b<? super T1, ? super i7b<T2>, ? extends R> e;

    /* loaded from: classes10.dex */
    public final class ResultManager extends HashMap<Integer, j7b<T2>> implements p7b {
        public static final long serialVersionUID = -3035156013812425335L;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final o7b<? super R> subscriber;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final fcb group = new fcb();
        public final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public Map<Integer, j7b<T2>> leftMap() {
            return this;
        }

        /* loaded from: classes10.dex */
        public final class a extends o7b<D1> {
            public final int e;
            public boolean f = true;

            public a(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.j7b
            public void onCompleted() {
                j7b<T2> remove;
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

            @Override // com.baidu.tieba.j7b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.j7b
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* loaded from: classes10.dex */
        public final class b extends o7b<T1> {
            public b() {
            }

            @Override // com.baidu.tieba.j7b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.j7b
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

            @Override // com.baidu.tieba.j7b
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject H = PublishSubject.H();
                    nbb nbbVar = new nbb(H);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i = resultManager.leftIds;
                        resultManager.leftIds = i + 1;
                        ResultManager.this.leftMap().put(Integer.valueOf(i), nbbVar);
                    }
                    i7b a = i7b.a(new a(H, ResultManager.this.cancel));
                    a aVar = new a(i);
                    ResultManager.this.group.a(aVar);
                    OnSubscribeGroupJoin.this.c.call(t1).F(aVar);
                    R call = OnSubscribeGroupJoin.this.e.call(t1, a);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object obj : arrayList) {
                        nbbVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    u7b.f(th, this);
                }
            }
        }

        /* loaded from: classes10.dex */
        public final class c extends o7b<D2> {
            public final int e;
            public boolean f = true;

            public c(int i) {
                this.e = i;
            }

            @Override // com.baidu.tieba.j7b
            public void onCompleted() {
                if (this.f) {
                    this.f = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.e));
                    }
                    ResultManager.this.group.b(this);
                }
            }

            @Override // com.baidu.tieba.j7b
            public void onError(Throwable th) {
                ResultManager.this.errorMain(th);
            }

            @Override // com.baidu.tieba.j7b
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* loaded from: classes10.dex */
        public final class d extends o7b<T2> {
            public d() {
            }

            @Override // com.baidu.tieba.j7b
            public void onError(Throwable th) {
                ResultManager.this.errorAll(th);
            }

            @Override // com.baidu.tieba.j7b
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

            @Override // com.baidu.tieba.j7b
            public void onNext(T2 t2) {
                int i;
                ArrayList<j7b> arrayList;
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
                    for (j7b j7bVar : arrayList) {
                        j7bVar.onNext(t2);
                    }
                } catch (Throwable th) {
                    u7b.f(th, this);
                }
            }
        }

        public ResultManager(o7b<? super R> o7bVar) {
            this.subscriber = o7bVar;
        }

        public void complete(List<j7b<T2>> list) {
            if (list != null) {
                for (j7b<T2> j7bVar : list) {
                    j7bVar.onCompleted();
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
            ArrayList<j7b> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (j7b j7bVar : arrayList) {
                j7bVar.onError(th);
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

        @Override // com.baidu.tieba.p7b
        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        @Override // com.baidu.tieba.p7b
        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    /* loaded from: classes10.dex */
    public static final class a<T> implements i7b.a<T> {
        public final RefCountSubscription a;
        public final i7b<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public final class C0762a extends o7b<T> {
            public final o7b<? super T> e;
            public final p7b f;

            public C0762a(a aVar, o7b<? super T> o7bVar, p7b p7bVar) {
                super(o7bVar);
                this.e = o7bVar;
                this.f = p7bVar;
            }

            @Override // com.baidu.tieba.j7b
            public void onCompleted() {
                this.e.onCompleted();
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.j7b
            public void onError(Throwable th) {
                this.e.onError(th);
                this.f.unsubscribe();
            }

            @Override // com.baidu.tieba.j7b
            public void onNext(T t) {
                this.e.onNext(t);
            }
        }

        public a(i7b<T> i7bVar, RefCountSubscription refCountSubscription) {
            this.a = refCountSubscription;
            this.b = i7bVar;
        }

        public void call(o7b<? super T> o7bVar) {
            p7b a = this.a.a();
            C0762a c0762a = new C0762a(this, o7bVar, a);
            c0762a.b(a);
            this.b.F(c0762a);
        }

        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((o7b) ((o7b) obj));
        }
    }

    public void call(o7b<? super R> o7bVar) {
        ResultManager resultManager = new ResultManager(new obb(o7bVar));
        o7bVar.b(resultManager);
        resultManager.init();
    }

    @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((o7b) ((o7b) obj));
    }
}
