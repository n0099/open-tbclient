package rx.internal.operators;

import com.baidu.tieba.lmb;
import com.baidu.tieba.mmb;
import com.baidu.tieba.mrb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements mmb {
    public static final long serialVersionUID = -7965400327305809232L;
    public final mmb actual;
    public int index;
    public final mrb sd = new mrb();
    public final lmb[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(mmb mmbVar, lmb[] lmbVarArr) {
        this.actual = mmbVar;
        this.sources = lmbVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        lmb[] lmbVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == lmbVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            lmbVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.mmb
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.mmb
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.mmb
    public void onSubscribe(umb umbVar) {
        this.sd.a(umbVar);
    }
}
