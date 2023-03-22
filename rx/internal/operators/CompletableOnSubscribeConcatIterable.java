package rx.internal.operators;

import com.baidu.tieba.kwa;
import com.baidu.tieba.lwa;
import com.baidu.tieba.mra;
import com.baidu.tieba.nra;
import com.baidu.tieba.vra;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatIterable implements mra.f {
    public final Iterable<? extends mra> a;

    /* loaded from: classes9.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements nra {
        public static final long serialVersionUID = -7965400327305809232L;
        public final nra actual;
        public final kwa sd = new kwa();
        public final Iterator<? extends mra> sources;

        public ConcatInnerSubscriber(nra nraVar, Iterator<? extends mra> it) {
            this.actual = nraVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends mra> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        mra next = it.next();
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

        @Override // com.baidu.tieba.nra
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.nra
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.nra
        public void onSubscribe(vra vraVar) {
            this.sd.a(vraVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends mra> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mra.f, com.baidu.tieba.csa
    public void call(nra nraVar) {
        try {
            Iterator<? extends mra> it = this.a.iterator();
            if (it == null) {
                nraVar.onSubscribe(lwa.c());
                nraVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(nraVar, it);
            nraVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            nraVar.onSubscribe(lwa.c());
            nraVar.onError(th);
        }
    }
}
