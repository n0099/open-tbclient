package rx.subjects;

import com.baidu.tieba.e6b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements l5b, q5b {
    public static final long serialVersionUID = -5006209596735204567L;
    public final p5b<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(p5b<? super T> p5bVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = p5bVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            e6b.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
