package rx.internal.operators;

import com.baidu.tieba.icc;
import com.baidu.tieba.jcc;
import com.baidu.tieba.nhc;
import com.baidu.tieba.ohc;
import com.baidu.tieba.rcc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements icc.f {
    public final Iterable<? extends icc> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements jcc {
        public static final long serialVersionUID = -7965400327305809232L;
        public final jcc actual;
        public final nhc sd = new nhc();
        public final Iterator<? extends icc> sources;

        public ConcatInnerSubscriber(jcc jccVar, Iterator<? extends icc> it) {
            this.actual = jccVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends icc> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        icc next = it.next();
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

        @Override // com.baidu.tieba.jcc
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.jcc
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.jcc
        public void onSubscribe(rcc rccVar) {
            this.sd.a(rccVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends icc> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.icc.f, com.baidu.tieba.ycc
    public void call(jcc jccVar) {
        try {
            Iterator<? extends icc> it = this.a.iterator();
            if (it == null) {
                jccVar.onSubscribe(ohc.c());
                jccVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(jccVar, it);
            jccVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            jccVar.onSubscribe(ohc.c());
            jccVar.onError(th);
        }
    }
}
