package rx.subjects;

import com.baidu.tieba.d8b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p7b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements k7b, p7b {
    public static final long serialVersionUID = -5006209596735204567L;
    public final o7b<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(o7b<? super T> o7bVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = o7bVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.p7b
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            d8b.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
