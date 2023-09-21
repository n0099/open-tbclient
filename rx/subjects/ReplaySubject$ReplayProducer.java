package rx.subjects;

import com.baidu.tieba.hdc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements mcc, rcc {
    public static final long serialVersionUID = -5006209596735204567L;
    public final qcc<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(qcc<? super T> qccVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = qccVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.rcc
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.mcc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            hdc.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
