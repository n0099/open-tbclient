package rx.internal.operators;

import com.baidu.tieba.etb;
import com.baidu.tieba.vsb;
import com.baidu.tieba.wsb;
import com.baidu.tieba.zxb;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements wsb {
    public static final long serialVersionUID = -7965400327305809232L;
    public final wsb actual;
    public int index;
    public final zxb sd = new zxb();
    public final vsb[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(wsb wsbVar, vsb[] vsbVarArr) {
        this.actual = wsbVar;
        this.sources = vsbVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        vsb[] vsbVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == vsbVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            vsbVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.wsb
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.wsb
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.wsb
    public void onSubscribe(etb etbVar) {
        this.sd.a(etbVar);
    }
}
