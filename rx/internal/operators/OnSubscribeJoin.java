package rx.internal.operators;

import com.baidu.tieba.cfc;
import com.baidu.tieba.ebc;
import com.baidu.tieba.lbc;
import com.baidu.tieba.mbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tfc;
import com.baidu.tieba.vfc;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements sac.a<R> {
    public final sac<TLeft> a;
    public final sac<TRight> b;
    public final lbc<TLeft, sac<TLeftDuration>> c;
    public final lbc<TRight, sac<TRightDuration>> d;
    public final mbc<TLeft, TRight, R> e;

    /* loaded from: classes2.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static final long serialVersionUID = 3491669543549085380L;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final yac<? super R> subscriber;
        public final tfc group = new tfc();
        public final Map<Integer, TRight> rightMap = new HashMap();

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        /* loaded from: classes2.dex */
        public final class a extends yac<TLeft> {

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public final class C0797a extends yac<TLeftDuration> {
                public final int e;
                public boolean f = true;

                public C0797a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.tac
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        a.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.tac
                public void onError(Throwable th) {
                    a.this.onError(th);
                }

                @Override // com.baidu.tieba.tac
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public a() {
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, zac zacVar) {
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
                ResultSink.this.group.d(zacVar);
            }

            @Override // com.baidu.tieba.tac
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.mbc<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.tac
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
                    C0797a c0797a = new C0797a(i);
                    ResultSink.this.group.a(c0797a);
                    OnSubscribeJoin.this.c.call(tleft).O(c0797a);
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
                    ebc.f(th, this);
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends yac<TRight> {

            /* loaded from: classes2.dex */
            public final class a extends yac<TRightDuration> {
                public final int e;
                public boolean f = true;

                public a(int i) {
                    this.e = i;
                }

                @Override // com.baidu.tieba.tac
                public void onCompleted() {
                    if (this.f) {
                        this.f = false;
                        b.this.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.tac
                public void onError(Throwable th) {
                    b.this.onError(th);
                }

                @Override // com.baidu.tieba.tac
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public b() {
            }

            @Override // com.baidu.tieba.tac
            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void g(int i, zac zacVar) {
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
                ResultSink.this.group.d(zacVar);
            }

            @Override // com.baidu.tieba.tac
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

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.mbc<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.tac
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
                ResultSink.this.group.a(new vfc());
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
                    ebc.f(th, this);
                }
            }
        }

        public ResultSink(yac<? super R> yacVar) {
            this.subscriber = yacVar;
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

    public void call(yac<? super R> yacVar) {
        new ResultSink(new cfc(yacVar)).run();
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
