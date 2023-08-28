package rx.internal.operators;

import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.scc;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements o7c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final o7c actual;
    public int index;
    public final scc sd = new scc();
    public final n7c[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(o7c o7cVar, n7c[] n7cVarArr) {
        this.actual = o7cVar;
        this.sources = n7cVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        n7c[] n7cVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == n7cVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            n7cVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.o7c
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.o7c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.o7c
    public void onSubscribe(w7c w7cVar) {
        this.sd.a(w7cVar);
    }
}
