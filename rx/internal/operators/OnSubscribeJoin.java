package rx.internal.operators;

import com.baidu.tieba.asa;
import com.baidu.tieba.gsa;
import com.baidu.tieba.hsa;
import com.baidu.tieba.iwa;
import com.baidu.tieba.kwa;
import com.baidu.tieba.ora;
import com.baidu.tieba.rva;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements ora.a<R> {
    public final ora<TLeft> a;
    public final ora<TRight> b;
    public final gsa<TLeft, ora<TLeftDuration>> c;
    public final gsa<TRight, ora<TRightDuration>> d;
    public final hsa<TLeft, TRight, R> e;

    /* loaded from: classes9.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final ura<? super R> subscriber;
        public final iwa group = new iwa();
        public final Map<Integer, TRight> rightMap = new HashMap();

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        /* loaded from: classes9.dex */
        public final class a extends ura<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public final class C0746a extends ura<TLeftDuration> {
                public final int e;
                public boolean f = true;

                public C0746a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.pra
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        a.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.pra
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // com.baidu.tieba.pra
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public a() {
            }

            @Override // com.baidu.tieba.pra
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, vra vraVar) {
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
                ResultSink.this.group.b(vraVar);
            }

            @Override // com.baidu.tieba.pra
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.hsa<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pra
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
                    C0746a c0746a = new C0746a(i);
                    ResultSink.this.group.a(c0746a);
                    OnSubscribeJoin.this.c.call(tleft).B(c0746a);
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
                    asa.f(th, this);
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends ura<TRight> {

            /* loaded from: classes9.dex */
            public final class a extends ura<TRightDuration> {
                public final int e;
                public boolean f = true;

                public a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.pra
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        b.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.pra
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // com.baidu.tieba.pra
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            @Override // com.baidu.tieba.pra
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, vra vraVar) {
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
                ResultSink.this.group.b(vraVar);
            }

            @Override // com.baidu.tieba.pra
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.hsa<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pra
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
                ResultSink.this.group.a(new kwa());
                try {
                    a aVar = new a(i);
                    ResultSink.this.group.a(aVar);
                    OnSubscribeJoin.this.d.call(tright).B(aVar);
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
                    asa.f(th, this);
                }
            }
        }

        public ResultSink(ura<? super R> uraVar) {
            this.subscriber = uraVar;
        }

        public void run() {
            this.subscriber.b(this.group);
            a aVar = new a();
            b bVar = new b();
            this.group.a(aVar);
            this.group.a(bVar);
            OnSubscribeJoin.this.a.B(aVar);
            OnSubscribeJoin.this.b.B(bVar);
        }
    }

    public void call(ura<? super R> uraVar) {
        new ResultSink(new rva(uraVar)).run();
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
