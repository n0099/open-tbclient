package rx.internal.operators;

import com.baidu.tieba.eob;
import com.baidu.tieba.fob;
import com.baidu.tieba.ftb;
import com.baidu.tieba.nob;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements fob {
    public static final long serialVersionUID = -7965400327305809232L;
    public final fob actual;
    public int index;
    public final ftb sd = new ftb();
    public final eob[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(fob fobVar, eob[] eobVarArr) {
        this.actual = fobVar;
        this.sources = eobVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        eob[] eobVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == eobVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            eobVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fob
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.fob
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.fob
    public void onSubscribe(nob nobVar) {
        this.sd.a(nobVar);
    }
}
