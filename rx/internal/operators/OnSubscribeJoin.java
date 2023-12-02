package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.gtc;
import com.baidu.tieba.itc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.poc;
import com.baidu.tieba.woc;
import com.baidu.tieba.xoc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements doc.a<R> {
    public final doc<TLeft> a;
    public final doc<TRight> b;
    public final woc<TLeft, doc<TLeftDuration>> c;
    public final woc<TRight, doc<TRightDuration>> d;
    public final xoc<TLeft, TRight, R> e;

    /* loaded from: classes2.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final joc<? super R> subscriber;
        public final gtc group = new gtc();
        public final Map<Integer, TRight> rightMap = new HashMap();

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends joc<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public final class C0771a extends joc<TLeftDuration> {
                public final int e;
                public boolean f = true;

                public C0771a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.eoc
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        a.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.eoc
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // com.baidu.tieba.eoc
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public a() {
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, koc kocVar) {
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
                ResultSink.this.group.d(kocVar);
            }

            @Override // com.baidu.tieba.eoc
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.xoc<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.eoc
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
                    C0771a c0771a = new C0771a(i);
                    ResultSink.this.group.a(c0771a);
                    OnSubscribeJoin.this.c.call(tleft).O(c0771a);
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
                    poc.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends joc<TRight> {

            /* loaded from: classes2.dex */
            public final class a extends joc<TRightDuration> {
                public final int e;
                public boolean f = true;

                public a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.eoc
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        b.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.eoc
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // com.baidu.tieba.eoc
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            @Override // com.baidu.tieba.eoc
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, koc kocVar) {
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
                ResultSink.this.group.d(kocVar);
            }

            @Override // com.baidu.tieba.eoc
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.xoc<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.eoc
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
                ResultSink.this.group.a(new itc());
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
                    poc.f(th, this);
                }
            }
        }

        public ResultSink(joc<? super R> jocVar) {
            this.subscriber = jocVar;
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
