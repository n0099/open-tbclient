package rx.subjects;

import com.baidu.tieba.i2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements p1b, u1b {
    public static final long serialVersionUID = -5006209596735204567L;
    public final t1b<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(t1b<? super T> t1bVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = t1bVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.u1b
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.p1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            i2b.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
