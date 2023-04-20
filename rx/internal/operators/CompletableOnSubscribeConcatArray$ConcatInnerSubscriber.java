package rx.internal.operators;

import com.baidu.tieba.j6b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.u1b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements m1b {
    public static final long serialVersionUID = -7965400327305809232L;
    public final m1b actual;
    public int index;
    public final j6b sd = new j6b();
    public final l1b[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(m1b m1bVar, l1b[] l1bVarArr) {
        this.actual = m1bVar;
        this.sources = l1bVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        l1b[] l1bVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == l1bVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            l1bVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m1b
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.m1b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.m1b
    public void onSubscribe(u1b u1bVar) {
        this.sd.a(u1bVar);
    }
}
