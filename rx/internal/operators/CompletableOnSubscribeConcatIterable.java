package rx.internal.operators;

import com.baidu.tieba.eob;
import com.baidu.tieba.fob;
import com.baidu.tieba.ftb;
import com.baidu.tieba.gtb;
import com.baidu.tieba.nob;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements eob.f {
    public final Iterable<? extends eob> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements fob {
        public static final long serialVersionUID = -7965400327305809232L;
        public final fob actual;
        public final ftb sd = new ftb();
        public final Iterator<? extends eob> sources;

        public ConcatInnerSubscriber(fob fobVar, Iterator<? extends eob> it) {
            this.actual = fobVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends eob> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        eob next = it.next();
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

        @Override // com.baidu.tieba.fob
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.fob
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.fob
        public void onSubscribe(nob nobVar) {
            this.sd.a(nobVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends eob> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.eob.f, com.baidu.tieba.uob
    public void call(fob fobVar) {
        try {
            Iterator<? extends eob> it = this.a.iterator();
            if (it == null) {
                fobVar.onSubscribe(gtb.c());
                fobVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(fobVar, it);
            fobVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            fobVar.onSubscribe(gtb.c());
            fobVar.onError(th);
        }
    }
}
