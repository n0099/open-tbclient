package rx.internal.operators;

import com.baidu.tieba.icc;
import com.baidu.tieba.jcc;
import com.baidu.tieba.nhc;
import com.baidu.tieba.rcc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements jcc {
    public static final long serialVersionUID = -7965400327305809232L;
    public final jcc actual;
    public int index;
    public final nhc sd = new nhc();
    public final icc[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(jcc jccVar, icc[] iccVarArr) {
        this.actual = jccVar;
        this.sources = iccVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        icc[] iccVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == iccVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            iccVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.jcc
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.jcc
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.jcc
    public void onSubscribe(rcc rccVar) {
        this.sd.a(rccVar);
    }
}
