package rx.subjects;

import com.baidu.tieba.m8c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements r7c, w7c {
    public static final long serialVersionUID = -5006209596735204567L;
    public final v7c<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(v7c<? super T> v7cVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = v7cVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            m8c.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
