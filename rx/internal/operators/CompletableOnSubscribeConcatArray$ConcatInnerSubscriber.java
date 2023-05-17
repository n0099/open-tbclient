package rx.internal.operators;

import com.baidu.tieba.f7b;
import com.baidu.tieba.g7b;
import com.baidu.tieba.gcb;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements g7b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final g7b actual;
    public int index;
    public final gcb sd = new gcb();
    public final f7b[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(g7b g7bVar, f7b[] f7bVarArr) {
        this.actual = g7bVar;
        this.sources = f7bVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        f7b[] f7bVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == f7bVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            f7bVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.g7b
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.g7b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.g7b
    public void onSubscribe(o7b o7bVar) {
        this.sd.a(o7bVar);
    }
}
