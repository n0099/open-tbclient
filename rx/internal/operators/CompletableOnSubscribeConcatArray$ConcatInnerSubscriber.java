package rx.internal.operators;

import com.baidu.tieba.boc;
import com.baidu.tieba.coc;
import com.baidu.tieba.itc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements coc {
    public static final long serialVersionUID = -7965400327305809232L;
    public final coc actual;
    public int index;
    public final itc sd = new itc();
    public final boc[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(coc cocVar, boc[] bocVarArr) {
        this.actual = cocVar;
        this.sources = bocVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        boc[] bocVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == bocVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            bocVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.coc
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.coc
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.coc
    public void onSubscribe(koc kocVar) {
        this.sd.a(kocVar);
    }
}
