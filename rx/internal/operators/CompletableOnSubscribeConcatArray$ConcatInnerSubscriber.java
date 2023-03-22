package rx.internal.operators;

import com.baidu.tieba.kwa;
import com.baidu.tieba.mra;
import com.baidu.tieba.nra;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements nra {
    public static final long serialVersionUID = -7965400327305809232L;
    public final nra actual;
    public int index;
    public final kwa sd = new kwa();
    public final mra[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(nra nraVar, mra[] mraVarArr) {
        this.actual = nraVar;
        this.sources = mraVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        mra[] mraVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == mraVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            mraVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.nra
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.nra
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.nra
    public void onSubscribe(vra vraVar) {
        this.sd.a(vraVar);
    }
}
