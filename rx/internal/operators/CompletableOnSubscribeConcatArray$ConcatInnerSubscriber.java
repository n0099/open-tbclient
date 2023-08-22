package rx.internal.operators;

import com.baidu.tieba.l7c;
import com.baidu.tieba.m7c;
import com.baidu.tieba.qcc;
import com.baidu.tieba.u7c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements m7c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final m7c actual;
    public int index;
    public final qcc sd = new qcc();
    public final l7c[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(m7c m7cVar, l7c[] l7cVarArr) {
        this.actual = m7cVar;
        this.sources = l7cVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        l7c[] l7cVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == l7cVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            l7cVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m7c
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.m7c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.m7c
    public void onSubscribe(u7c u7cVar) {
        this.sd.a(u7cVar);
    }
}
