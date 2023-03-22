package rx.subjects;

import com.baidu.tieba.jsa;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements qra, vra {
    public static final long serialVersionUID = -5006209596735204567L;
    public final ura<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(ura<? super T> uraVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = uraVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            jsa.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
