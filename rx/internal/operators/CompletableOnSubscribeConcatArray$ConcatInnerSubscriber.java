package rx.internal.operators;

import com.baidu.tieba.f6c;
import com.baidu.tieba.g6c;
import com.baidu.tieba.mbc;
import com.baidu.tieba.o6c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements g6c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final g6c actual;
    public int index;
    public final mbc sd = new mbc();
    public final f6c[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(g6c g6cVar, f6c[] f6cVarArr) {
        this.actual = g6cVar;
        this.sources = f6cVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        f6c[] f6cVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == f6cVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            f6cVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.g6c
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.g6c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.g6c
    public void onSubscribe(o6c o6cVar) {
        this.sd.a(o6cVar);
    }
}
