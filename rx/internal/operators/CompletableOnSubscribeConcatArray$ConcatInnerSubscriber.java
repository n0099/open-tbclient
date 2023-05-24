package rx.internal.operators;

import com.baidu.tieba.g7b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.hcb;
import com.baidu.tieba.p7b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements h7b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final h7b actual;
    public int index;
    public final hcb sd = new hcb();
    public final g7b[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(h7b h7bVar, g7b[] g7bVarArr) {
        this.actual = h7bVar;
        this.sources = g7bVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        g7b[] g7bVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == g7bVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            g7bVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.h7b
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.h7b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.h7b
    public void onSubscribe(p7b p7bVar) {
        this.sd.a(p7bVar);
    }
}
