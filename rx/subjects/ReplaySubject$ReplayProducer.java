package rx.subjects;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements foc, koc {
    public static final long serialVersionUID = -5006209596735204567L;
    public final joc<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(joc<? super T> jocVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = jocVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            cpc.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
