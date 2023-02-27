package rx.subjects;

import com.baidu.tieba.nna;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements uma, zma {
    public static final long serialVersionUID = -5006209596735204567L;
    public final yma<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(yma<? super T> ymaVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = ymaVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.zma
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.uma
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            nna.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
