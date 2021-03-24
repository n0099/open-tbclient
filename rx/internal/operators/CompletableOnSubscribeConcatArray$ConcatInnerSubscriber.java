package rx.internal.operators;

import h.b;
import h.c;
import h.k;
import h.u.d;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements c {
    public static final long serialVersionUID = -7965400327305809232L;
    public final c actual;
    public int index;
    public final d sd = new d();
    public final b[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(c cVar, b[] bVarArr) {
        this.actual = cVar;
        this.sources = bVarArr;
    }

    public void next() {
        if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
            b[] bVarArr = this.sources;
            while (!this.sd.isUnsubscribed()) {
                int i = this.index;
                this.index = i + 1;
                if (i == bVarArr.length) {
                    this.actual.onCompleted();
                    return;
                }
                bVarArr[i].j(this);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // h.c
    public void onCompleted() {
        next();
    }

    @Override // h.c
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        this.sd.a(kVar);
    }
}
