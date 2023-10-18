package rx.internal.operators;

import com.baidu.tieba.a7c;
import com.baidu.tieba.b7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.kbc;
import com.baidu.tieba.mbc;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.t6c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements h6c.a<R> {
    public final h6c<TLeft> a;
    public final h6c<TRight> b;
    public final a7c<TLeft, h6c<TLeftDuration>> c;
    public final a7c<TRight, h6c<TRightDuration>> d;
    public final b7c<TLeft, TRight, R> e;

    /* loaded from: classes2.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final n6c<? super R> subscriber;
        public final kbc group = new kbc();
        public final Map<Integer, TRight> rightMap = new HashMap();

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends n6c<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public final class C0725a extends n6c<TLeftDuration> {
                public final int e;
                public boolean f = true;

                public C0725a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.i6c
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        a.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.i6c
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // com.baidu.tieba.i6c
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public a() {
            }

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, o6c o6cVar) {
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
                ResultSink.this.group.d(o6cVar);
            }

            @Override // com.baidu.tieba.i6c
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.b7c<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.i6c
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
                    C0725a c0725a = new C0725a(i);
                    ResultSink.this.group.a(c0725a);
                    OnSubscribeJoin.this.c.call(tleft).O(c0725a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.e.a(tleft, obj));
                    }
                } catch (Throwable th) {
                    t6c.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends n6c<TRight> {

            /* loaded from: classes2.dex */
            public final class a extends n6c<TRightDuration> {
                public final int e;
                public boolean f = true;

                public a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.i6c
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        b.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.i6c
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // com.baidu.tieba.i6c
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            @Override // com.baidu.tieba.i6c
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, o6c o6cVar) {
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
                ResultSink.this.group.d(o6cVar);
            }

            @Override // com.baidu.tieba.i6c
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.b7c<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.i6c
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
                ResultSink.this.group.a(new mbc());
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
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.e.a(obj, tright));
                    }
                } catch (Throwable th) {
                    t6c.f(th, this);
                }
            }
        }

        public ResultSink(n6c<? super R> n6cVar) {
            this.subscriber = n6cVar;
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
}
