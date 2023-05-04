package rx.internal.operators;

import com.baidu.tieba.h5b;
import com.baidu.tieba.hab;
import com.baidu.tieba.i5b;
import com.baidu.tieba.q5b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements i5b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final i5b actual;
    public int index;
    public final hab sd = new hab();
    public final h5b[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(i5b i5bVar, h5b[] h5bVarArr) {
        this.actual = i5bVar;
        this.sources = h5bVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        h5b[] h5bVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == h5bVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            h5bVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i5b
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.i5b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.i5b
    public void onSubscribe(q5b q5bVar) {
        this.sd.a(q5bVar);
    }
}
