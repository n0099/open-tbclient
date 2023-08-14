package rx.subjects;

import com.baidu.tieba.a1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.u1c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements a1c, f1c {
    public static final long serialVersionUID = -5006209596735204567L;
    public final e1c<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(e1c<? super T> e1cVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = e1cVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.a1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            u1c.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
