package rx.subjects;

import com.baidu.tieba.c8b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements j7b, o7b {
    public static final long serialVersionUID = -5006209596735204567L;
    public final n7b<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(n7b<? super T> n7bVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = n7bVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            c8b.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
