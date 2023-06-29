package rx.subjects;

import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.ttb;
import com.baidu.tieba.zsb;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayProducer<T> extends AtomicInteger implements zsb, etb {
    public static final long serialVersionUID = -5006209596735204567L;
    public final dtb<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final ReplaySubject$ReplayState<T> state;
    public int tailIndex;

    public ReplaySubject$ReplayProducer(dtb<? super T> dtbVar, ReplaySubject$ReplayState<T> replaySubject$ReplayState) {
        this.actual = dtbVar;
        this.state = replaySubject$ReplayState;
    }

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        this.state.remove(this);
    }

    @Override // com.baidu.tieba.zsb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            ttb.b(this.requested, j);
            this.state.buffer.a(this);
        } else if (i >= 0) {
        } else {
            throw new IllegalArgumentException("n >= required but it was " + j);
        }
    }
}
