package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.v0c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.z5c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements w0c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final w0c actual;
    public int index;
    public final z5c sd = new z5c();
    public final v0c[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(w0c w0cVar, v0c[] v0cVarArr) {
        this.actual = w0cVar;
        this.sources = v0cVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        v0c[] v0cVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == v0cVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            v0cVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.w0c
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.w0c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.w0c
    public void onSubscribe(e1c e1cVar) {
        this.sd.a(e1cVar);
    }
}
