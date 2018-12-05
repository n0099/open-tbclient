package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rx.d;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    final rx.d<TLeft> iCK;
    final rx.d<TRight> iCL;
    final rx.functions.g<TLeft, TRight, R> iCO;
    final rx.functions.f<TLeft, rx.d<TLeftDuration>> iCU;
    final rx.functions.f<TRight, rx.d<TRightDuration>> iCV;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public OnSubscribeJoin(rx.d<TLeft> dVar, rx.d<TRight> dVar2, rx.functions.f<TLeft, rx.d<TLeftDuration>> fVar, rx.functions.f<TRight, rx.d<TRightDuration>> fVar2, rx.functions.g<TLeft, TRight, R> gVar) {
        this.iCK = dVar;
        this.iCL = dVar2;
        this.iCU = fVar;
        this.iCV = fVar2;
        this.iCO = gVar;
    }

    public void call(rx.j<? super R> jVar) {
        new ResultSink(new rx.b.f(jVar)).run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;
        boolean leftDone;
        int leftId;
        boolean rightDone;
        int rightId;
        final rx.j<? super R> subscriber;
        final rx.subscriptions.b group = new rx.subscriptions.b();
        final Map<Integer, TRight> rightMap = new HashMap();

        public ResultSink(rx.j<? super R> jVar) {
            this.subscriber = jVar;
        }

        HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            a aVar = new a();
            b bVar = new b();
            this.group.add(aVar);
            this.group.add(bVar);
            OnSubscribeJoin.this.iCK.unsafeSubscribe(aVar);
            OnSubscribeJoin.this.iCL.unsafeSubscribe(bVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class a extends rx.j<TLeft> {
            a() {
            }

            protected void a(int i, rx.k kVar) {
                boolean z = false;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.leftMap().remove(Integer.valueOf(i)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone) {
                        z = true;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(kVar);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: rx.functions.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public void onNext(TLeft tleft) {
                int i;
                int i2;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i = resultSink.leftId;
                    resultSink.leftId = i + 1;
                    ResultSink.this.leftMap().put(Integer.valueOf(i), tleft);
                    i2 = ResultSink.this.rightId;
                }
                try {
                    C0409a c0409a = new C0409a(i);
                    ResultSink.this.group.add(c0409a);
                    OnSubscribeJoin.this.iCU.call(tleft).unsafeSubscribe(c0409a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.iCO.j(tleft, obj));
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                boolean z = false;
                synchronized (ResultSink.this) {
                    ResultSink.this.leftDone = true;
                    if (ResultSink.this.rightDone || ResultSink.this.leftMap().isEmpty()) {
                        z = true;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(this);
            }

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            final class C0409a extends rx.j<TLeftDuration> {
                boolean iCk = true;
                final int id;

                public C0409a(int i) {
                    this.id = i;
                }

                @Override // rx.e
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    if (this.iCk) {
                        this.iCk = false;
                        a.this.a(this.id, this);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class b extends rx.j<TRight> {
            b() {
            }

            void a(int i, rx.k kVar) {
                boolean z = false;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.rightMap.remove(Integer.valueOf(i)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone) {
                        z = true;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(kVar);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: rx.functions.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.e
            public void onNext(TRight tright) {
                int i;
                int i2;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i = resultSink.rightId;
                    resultSink.rightId = i + 1;
                    ResultSink.this.rightMap.put(Integer.valueOf(i), tright);
                    i2 = ResultSink.this.leftId;
                }
                ResultSink.this.group.add(new rx.subscriptions.d());
                try {
                    a aVar = new a(i);
                    ResultSink.this.group.add(aVar);
                    OnSubscribeJoin.this.iCV.call(tright).unsafeSubscribe(aVar);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap().entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.iCO.j(obj, tright));
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            @Override // rx.e
            public void onCompleted() {
                boolean z = false;
                synchronized (ResultSink.this) {
                    ResultSink.this.rightDone = true;
                    if (ResultSink.this.leftDone || ResultSink.this.rightMap.isEmpty()) {
                        z = true;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.b(this);
            }

            /* loaded from: classes2.dex */
            final class a extends rx.j<TRightDuration> {
                boolean iCk = true;
                final int id;

                public a(int i) {
                    this.id = i;
                }

                @Override // rx.e
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // rx.e
                public void onCompleted() {
                    if (this.iCk) {
                        this.iCk = false;
                        b.this.a(this.id, this);
                    }
                }
            }
        }
    }
}
