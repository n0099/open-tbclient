package rx.internal.operators;

import com.baidu.tieba.a6c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.x0c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements x0c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final x0c actual;
    public int index;
    public final a6c sd = new a6c();
    public final w0c[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(x0c x0cVar, w0c[] w0cVarArr) {
        this.actual = x0cVar;
        this.sources = w0cVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        w0c[] w0cVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == w0cVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            w0cVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.x0c
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.x0c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.x0c
    public void onSubscribe(f1c f1cVar) {
        this.sd.a(f1cVar);
    }
}
