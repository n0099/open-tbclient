package rx.subjects;

import com.baidu.tieba.pbc;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements uac, zac {
    public static final long serialVersionUID = -5006209596735204567L;
    public final yac<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(yac<? super T> yacVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = yacVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.uac
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            pbc.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
