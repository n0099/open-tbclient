package rx.internal.operators;

import com.baidu.tieba.b6b;
import com.baidu.tieba.d1b;
import com.baidu.tieba.e1b;
import com.baidu.tieba.m1b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements e1b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final e1b actual;
    public int index;
    public final b6b sd = new b6b();
    public final d1b[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(e1b e1bVar, d1b[] d1bVarArr) {
        this.actual = e1bVar;
        this.sources = d1bVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        d1b[] d1bVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == d1bVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            d1bVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.e1b
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.e1b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.e1b
    public void onSubscribe(m1b m1bVar) {
        this.sd.a(m1bVar);
    }
}
