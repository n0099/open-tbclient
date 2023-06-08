package rx.internal.operators;

import com.baidu.tieba.lmb;
import com.baidu.tieba.mmb;
import com.baidu.tieba.mrb;
import com.baidu.tieba.nrb;
import com.baidu.tieba.umb;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements lmb.f {
    public final Iterable<? extends lmb> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements mmb {
        public static final long serialVersionUID = -7965400327305809232L;
        public final mmb actual;
        public final mrb sd = new mrb();
        public final Iterator<? extends lmb> sources;

        public ConcatInnerSubscriber(mmb mmbVar, Iterator<? extends lmb> it) {
            this.actual = mmbVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends lmb> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        lmb next = it.next();
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

        @Override // com.baidu.tieba.mmb
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.mmb
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.mmb
        public void onSubscribe(umb umbVar) {
            this.sd.a(umbVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends lmb> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lmb.f, com.baidu.tieba.bnb
    public void call(mmb mmbVar) {
        try {
            Iterator<? extends lmb> it = this.a.iterator();
            if (it == null) {
                mmbVar.onSubscribe(nrb.c());
                mmbVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(mmbVar, it);
            mmbVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            mmbVar.onSubscribe(nrb.c());
            mmbVar.onError(th);
        }
    }
}
