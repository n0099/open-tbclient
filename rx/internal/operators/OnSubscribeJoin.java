package rx.internal.operators;

import com.baidu.tieba.a6c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.h5c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.r1c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.y5c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements y0c.a<R> {
    public final y0c<TLeft> a;
    public final y0c<TRight> b;
    public final q1c<TLeft, y0c<TLeftDuration>> c;
    public final q1c<TRight, y0c<TRightDuration>> d;
    public final r1c<TLeft, TRight, R> e;

    /* loaded from: classes2.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final e1c<? super R> subscriber;
        public final y5c group = new y5c();
        public final Map<Integer, TRight> rightMap = new HashMap();

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends e1c<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public final class C0801a extends e1c<TLeftDuration> {
                public final int e;
                public boolean f = true;

                public C0801a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.z0c
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        a.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.z0c
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // com.baidu.tieba.z0c
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public a() {
            }

            @Override // com.baidu.tieba.z0c
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, f1c f1cVar) {
                boolean z;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.leftMap().remove(Integer.valueOf(i)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.d(f1cVar);
            }

            @Override // com.baidu.tieba.z0c
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
                ResultSink.this.group.d(this);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.r1c<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.z0c
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
                    C0801a c0801a = new C0801a(i);
                    ResultSink.this.group.a(c0801a);
                    OnSubscribeJoin.this.c.call(tleft).O(c0801a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.e.call(tleft, obj));
                    }
                } catch (Throwable th) {
                    k1c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends e1c<TRight> {

            /* loaded from: classes2.dex */
            public final class a extends e1c<TRightDuration> {
                public final int e;
                public boolean f = true;

                public a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.z0c
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        b.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.z0c
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // com.baidu.tieba.z0c
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            @Override // com.baidu.tieba.z0c
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, f1c f1cVar) {
                boolean z;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.rightMap.remove(Integer.valueOf(i)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.d(f1cVar);
            }

            @Override // com.baidu.tieba.z0c
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
                ResultSink.this.group.d(this);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.r1c<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.z0c
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
                ResultSink.this.group.a(new a6c());
                try {
                    a aVar = new a(i);
                    ResultSink.this.group.a(aVar);
                    OnSubscribeJoin.this.d.call(tright).O(aVar);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap().entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.e.call(obj, tright));
                    }
                } catch (Throwable th) {
                    k1c.f(th, this);
                }
            }
        }

        public ResultSink(e1c<? super R> e1cVar) {
            this.subscriber = e1cVar;
        }

        public void run() {
            this.subscriber.b(this.group);
            a aVar = new a();
            b bVar = new b();
            this.group.a(aVar);
            this.group.a(bVar);
            OnSubscribeJoin.this.a.O(aVar);
            OnSubscribeJoin.this.b.O(bVar);
        }
    }

    public void call(e1c<? super R> e1cVar) {
        new ResultSink(new h5c(e1cVar)).run();
    }

    @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((e1c) ((e1c) obj));
    }
}
