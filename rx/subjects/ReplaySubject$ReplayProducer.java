package rx.subjects;

import h.f;
import h.j;
import h.k;
import h.o.a.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements f, k {
    public static final long serialVersionUID = -5006209596735204567L;
    public final j<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(j<? super T> jVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = jVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // h.f
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            a.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        this.state.remove(this);
    }
}
