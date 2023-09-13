package rx.internal.operators;

import com.baidu.tieba.qac;
import com.baidu.tieba.rac;
import com.baidu.tieba.vfc;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements rac {
    public static final long serialVersionUID = -7965400327305809232L;
    public final rac actual;
    public int index;
    public final vfc sd = new vfc();
    public final qac[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(rac racVar, qac[] qacVarArr) {
        this.actual = racVar;
        this.sources = qacVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        qac[] qacVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == qacVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            qacVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.rac
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.rac
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.rac
    public void onSubscribe(zac zacVar) {
        this.sd.a(zacVar);
    }
}
