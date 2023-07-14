package rx.internal.operators;

import com.baidu.tieba.b2c;
import com.baidu.tieba.s1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.w6c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements t1c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final t1c actual;
    public int index;
    public final w6c sd = new w6c();
    public final s1c[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(t1c t1cVar, s1c[] s1cVarArr) {
        this.actual = t1cVar;
        this.sources = s1cVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        s1c[] s1cVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == s1cVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            s1cVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.t1c
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.t1c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.t1c
    public void onSubscribe(b2c b2cVar) {
        this.sd.a(b2cVar);
    }
}
