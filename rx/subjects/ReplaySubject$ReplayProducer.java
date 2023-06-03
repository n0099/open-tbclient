package rx.subjects;

import com.baidu.tieba.dnb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements kmb, pmb {
    public static final long serialVersionUID = -5006209596735204567L;
    public final omb<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(omb<? super T> ombVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = ombVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.kmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            dnb.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
