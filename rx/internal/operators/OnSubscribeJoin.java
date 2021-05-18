package rx.internal.operators;

import h.d;
import h.j;
import h.k;
import h.n.f;
import h.n.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final d<TLeft> f69045e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f69046f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f69047g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f69048h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f69049i;

    /* loaded from: classes7.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final j<? super R> subscriber;
        public final h.u.b group = new h.u.b();
        public final Map<Integer, TRight> rightMap = new HashMap();

        /* loaded from: classes7.dex */
        public final class a extends j<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public final class C1951a extends j<TLeftDuration> {

                /* renamed from: e  reason: collision with root package name */
                public final int f69051e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f69052f = true;

                public C1951a(int i2) {
                    this.f69051e = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    if (this.f69052f) {
                        this.f69052f = false;
                        a.this.b(this.f69051e, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // h.e
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public a() {
            }

            public void b(int i2, k kVar) {
                boolean z;
                synchronized (ResultSink.this) {
                    z = ResultSink.this.leftMap().remove(Integer.valueOf(i2)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone;
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(kVar);
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    z = true;
                    ResultSink.this.leftDone = true;
                    if (!ResultSink.this.rightDone && !ResultSink.this.leftMap().isEmpty()) {
                        z = false;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(this);
            }

            @Override // h.e
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: h.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.e
            public void onNext(TLeft tleft) {
                int i2;
                int i3;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i2 = resultSink.leftId;
                    resultSink.leftId = i2 + 1;
                    ResultSink.this.leftMap().put(Integer.valueOf(i2), tleft);
                    i3 = ResultSink.this.rightId;
                }
                try {
                    C1951a c1951a = new C1951a(i2);
                    ResultSink.this.group.a(c1951a);
                    OnSubscribeJoin.this.f69047g.call(tleft).I(c1951a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i3) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.f69049i.a(tleft, obj));
                    }
                } catch (Throwable th) {
                    h.m.a.f(th, this);
                }
            }
        }

        /* loaded from: classes7.dex */
        public final class b extends j<TRight> {

            /* loaded from: classes7.dex */
            public final class a extends j<TRightDuration> {

                /* renamed from: e  reason: collision with root package name */
                public final int f69055e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f69056f = true;

                public a(int i2) {
                    this.f69055e = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    if (this.f69056f) {
                        this.f69056f = false;
                        b.this.b(this.f69055e, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // h.e
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            public void b(int i2, k kVar) {
                boolean z;
                synchronized (ResultSink.this) {
                    z = ResultSink.this.rightMap.remove(Integer.valueOf(i2)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone;
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(kVar);
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    z = true;
                    ResultSink.this.rightDone = true;
                    if (!ResultSink.this.leftDone && !ResultSink.this.rightMap.isEmpty()) {
                        z = false;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(this);
            }

            @Override // h.e
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: h.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.e
            public void onNext(TRight tright) {
                int i2;
                int i3;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i2 = resultSink.rightId;
                    resultSink.rightId = i2 + 1;
                    ResultSink.this.rightMap.put(Integer.valueOf(i2), tright);
                    i3 = ResultSink.this.leftId;
                }
                ResultSink.this.group.a(new h.u.d());
                try {
                    a aVar = new a(i2);
                    ResultSink.this.group.a(aVar);
                    OnSubscribeJoin.this.f69048h.call(tright).I(aVar);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap().entrySet()) {
                            if (entry.getKey().intValue() < i3) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.f69049i.a(obj, tright));
                    }
                } catch (Throwable th) {
                    h.m.a.f(th, this);
                }
            }
        }

        public ResultSink(j<? super R> jVar) {
            this.subscriber = jVar;
        }

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            a aVar = new a();
            b bVar = new b();
            this.group.a(aVar);
            this.group.a(bVar);
            OnSubscribeJoin.this.f69045e.I(aVar);
            OnSubscribeJoin.this.f69046f.I(bVar);
        }
    }
}
