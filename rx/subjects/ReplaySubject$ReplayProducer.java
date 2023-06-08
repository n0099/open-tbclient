package rx.subjects;

import com.baidu.tieba.inb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements pmb, umb {
    public static final long serialVersionUID = -5006209596735204567L;
    public final tmb<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(tmb<? super T> tmbVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = tmbVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            inb.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
