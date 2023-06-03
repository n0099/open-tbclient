package rx.internal.operators;

import com.baidu.tieba.gmb;
import com.baidu.tieba.hmb;
import com.baidu.tieba.hrb;
import com.baidu.tieba.irb;
import com.baidu.tieba.pmb;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements gmb.f {
    public final Iterable<? extends gmb> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements hmb {
        public static final long serialVersionUID = -7965400327305809232L;
        public final hmb actual;
        public final hrb sd = new hrb();
        public final Iterator<? extends gmb> sources;

        public ConcatInnerSubscriber(hmb hmbVar, Iterator<? extends gmb> it) {
            this.actual = hmbVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends gmb> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        gmb next = it.next();
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

        @Override // com.baidu.tieba.hmb
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.hmb
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.hmb
        public void onSubscribe(pmb pmbVar) {
            this.sd.a(pmbVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends gmb> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gmb.f, com.baidu.tieba.wmb
    public void call(hmb hmbVar) {
        try {
            Iterator<? extends gmb> it = this.a.iterator();
            if (it == null) {
                hmbVar.onSubscribe(irb.c());
                hmbVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(hmbVar, it);
            hmbVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            hmbVar.onSubscribe(irb.c());
            hmbVar.onError(th);
        }
    }
}
