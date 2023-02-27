package rx.internal.operators;

import com.baidu.tieba.ora;
import com.baidu.tieba.pra;
import com.baidu.tieba.qma;
import com.baidu.tieba.rma;
import com.baidu.tieba.zma;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatIterable implements qma.f {
    public final Iterable<? extends qma> a;

    /* loaded from: classes9.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements rma {
        public static final long serialVersionUID = -7965400327305809232L;
        public final rma actual;
        public final ora sd = new ora();
        public final Iterator<? extends qma> sources;

        public ConcatInnerSubscriber(rma rmaVar, Iterator<? extends qma> it) {
            this.actual = rmaVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends qma> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        qma next = it.next();
                        if (next == null) {
                            this.actual.onError(new NullPointerException("The completable returned is null"));
                            return;
                        }
                        next.j(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        this.actual.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    this.actual.onError(th2);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.rma
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.rma
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.rma
        public void onSubscribe(zma zmaVar) {
            this.sd.a(zmaVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends qma> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qma.f, com.baidu.tieba.gna
    public void call(rma rmaVar) {
        try {
            Iterator<? extends qma> it = this.a.iterator();
            if (it == null) {
                rmaVar.onSubscribe(pra.c());
                rmaVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(rmaVar, it);
            rmaVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            rmaVar.onSubscribe(pra.c());
            rmaVar.onError(th);
        }
    }
}
