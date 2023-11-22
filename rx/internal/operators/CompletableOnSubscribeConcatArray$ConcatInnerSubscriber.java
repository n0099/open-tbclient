package rx.internal.operators;

import com.baidu.tieba.hjc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.ooc;
import com.baidu.tieba.qjc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements ijc {
    public static final long serialVersionUID = -7965400327305809232L;
    public final ijc actual;
    public int index;
    public final ooc sd = new ooc();
    public final hjc[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(ijc ijcVar, hjc[] hjcVarArr) {
        this.actual = ijcVar;
        this.sources = hjcVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        hjc[] hjcVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == hjcVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            hjcVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ijc
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.ijc
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.ijc
    public void onSubscribe(qjc qjcVar) {
        this.sd.a(qjcVar);
    }
}
