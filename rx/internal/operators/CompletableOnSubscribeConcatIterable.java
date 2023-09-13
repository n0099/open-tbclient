package rx.internal.operators;

import com.baidu.tieba.qac;
import com.baidu.tieba.rac;
import com.baidu.tieba.vfc;
import com.baidu.tieba.wfc;
import com.baidu.tieba.zac;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements qac.f {
    public final Iterable<? extends qac> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements rac {
        public static final long serialVersionUID = -7965400327305809232L;
        public final rac actual;
        public final vfc sd = new vfc();
        public final Iterator<? extends qac> sources;

        public ConcatInnerSubscriber(rac racVar, Iterator<? extends qac> it) {
            this.actual = racVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends qac> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        qac next = it.next();
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

        @Override // com.baidu.tieba.rac
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.rac
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.rac
        public void onSubscribe(zac zacVar) {
            this.sd.a(zacVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends qac> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
    public void call(rac racVar) {
        try {
            Iterator<? extends qac> it = this.a.iterator();
            if (it == null) {
                racVar.onSubscribe(wfc.c());
                racVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(racVar, it);
            racVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            racVar.onSubscribe(wfc.c());
            racVar.onError(th);
        }
    }
}
