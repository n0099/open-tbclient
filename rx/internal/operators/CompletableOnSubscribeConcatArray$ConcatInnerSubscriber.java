package rx.internal.operators;

import com.baidu.tieba.ora;
import com.baidu.tieba.qma;
import com.baidu.tieba.rma;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements rma {
    public static final long serialVersionUID = -7965400327305809232L;
    public final rma actual;
    public int index;
    public final ora sd = new ora();
    public final qma[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(rma rmaVar, qma[] qmaVarArr) {
        this.actual = rmaVar;
        this.sources = qmaVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        qma[] qmaVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == qmaVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            qmaVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.rma
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.rma
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.rma
    public void onSubscribe(zma zmaVar) {
        this.sd.a(zmaVar);
    }
}
