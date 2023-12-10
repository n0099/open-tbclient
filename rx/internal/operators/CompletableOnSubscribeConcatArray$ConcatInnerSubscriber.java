package rx.internal.operators;

import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.jtc;
import com.baidu.tieba.loc;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements doc {
    public static final long serialVersionUID = -7965400327305809232L;
    public final doc actual;
    public int index;
    public final jtc sd = new jtc();
    public final coc[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(doc docVar, coc[] cocVarArr) {
        this.actual = docVar;
        this.sources = cocVarArr;
    }

    public void next() {
        if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
            return;
        }
        coc[] cocVarArr = this.sources;
        while (!this.sd.isUnsubscribed()) {
            int i = this.index;
            this.index = i + 1;
            if (i == cocVarArr.length) {
                this.actual.onCompleted();
                return;
            }
            cocVarArr[i].j(this);
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.doc
    public void onCompleted() {
        next();
    }

    @Override // com.baidu.tieba.doc
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // com.baidu.tieba.doc
    public void onSubscribe(loc locVar) {
        this.sd.a(locVar);
    }
}
