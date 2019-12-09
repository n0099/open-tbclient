package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rx.d;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    final rx.d<TLeft> kyS;
    final rx.d<TRight> kyT;
    final rx.functions.g<TLeft, TRight, R> kyW;
    final rx.functions.f<TLeft, rx.d<TLeftDuration>> kzc;
    final rx.functions.f<TRight, rx.d<TRightDuration>> kzd;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super R> jVar) {
        new ResultSink(new rx.b.e(jVar)).run();
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
            OnSubscribeJoin.this.kyS.a((rx.j<? super TLeft>) aVar);
            OnSubscribeJoin.this.kyT.a((rx.j<? super TRight>) bVar);
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
                ResultSink.this.group.a(kVar);
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
                    C0599a c0599a = new C0599a(i);
                    ResultSink.this.group.add(c0599a);
                    OnSubscribeJoin.this.kzc.call(tleft).a((rx.j<? super TLeftDuration>) c0599a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.kyW.h(tleft, obj));
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
                ResultSink.this.group.a(this);
            }

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            final class C0599a extends rx.j<TLeftDuration> {
                final int id;
                boolean once = true;

                public C0599a(int i) {
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
                    if (this.once) {
                        this.once = false;
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
                ResultSink.this.group.a(kVar);
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
                    OnSubscribeJoin.this.kzd.call(tright).a((rx.j<? super TRightDuration>) aVar);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap().entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.kyW.h(obj, tright));
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
                ResultSink.this.group.a(this);
            }

            /* loaded from: classes2.dex */
            final class a extends rx.j<TRightDuration> {
                final int id;
                boolean once = true;

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
                    if (this.once) {
                        this.once = false;
                        b.this.a(this.id, this);
                    }
                }
            }
        }
    }
}
