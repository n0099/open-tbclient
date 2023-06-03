package rx.internal.operators;

import com.baidu.tieba.gmb;
import com.baidu.tieba.hmb;
import com.baidu.tieba.hrb;
import com.baidu.tieba.pmb;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements hmb {
    public static final long serialVersionUID = -7965400327305809232L;
    public final hmb actual;
    public int index;
    public final hrb sd = new hrb();
    public final gmb[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(hmb hmbVar, gmb[] gmbVarArr) {
        this.actual = hmbVar;
        this.sources = gmbVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        gmb[] gmbVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == gmbVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            gmbVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.hmb
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.hmb
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.hmb
    public void onSubscribe(pmb pmbVar) {
        this.sd.a(pmbVar);
    }
}
