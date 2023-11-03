package rx.internal.operators;

import com.baidu.tieba.gjc;
import com.baidu.tieba.hjc;
import com.baidu.tieba.noc;
import com.baidu.tieba.pjc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements hjc {
    public static final long serialVersionUID = -7965400327305809232L;
    public final hjc actual;
    public int index;
    public final noc sd = new noc();
    public final gjc[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(hjc hjcVar, gjc[] gjcVarArr) {
        this.actual = hjcVar;
        this.sources = gjcVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        gjc[] gjcVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == gjcVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            gjcVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.hjc
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.hjc
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.hjc
    public void onSubscribe(pjc pjcVar) {
        this.sd.a(pjcVar);
    }
}
