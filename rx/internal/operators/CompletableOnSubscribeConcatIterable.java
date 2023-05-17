package rx.internal.operators;

import com.baidu.tieba.f7b;
import com.baidu.tieba.g7b;
import com.baidu.tieba.gcb;
import com.baidu.tieba.hcb;
import com.baidu.tieba.o7b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class CompletableOnSubscribeConcatIterable implements f7b.f {
    public final Iterable<? extends f7b> a;

    /* loaded from: classes10.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements g7b {
        public static final long serialVersionUID = -7965400327305809232L;
        public final g7b actual;
        public final gcb sd = new gcb();
        public final Iterator<? extends f7b> sources;

        public ConcatInnerSubscriber(g7b g7bVar, Iterator<? extends f7b> it) {
            this.actual = g7bVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends f7b> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        f7b next = it.next();
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

        @Override // com.baidu.tieba.g7b
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.g7b
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.g7b
        public void onSubscribe(o7b o7bVar) {
            this.sd.a(o7bVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends f7b> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f7b.f, com.baidu.tieba.v7b
    public void call(g7b g7bVar) {
        try {
            Iterator<? extends f7b> it = this.a.iterator();
            if (it == null) {
                g7bVar.onSubscribe(hcb.c());
                g7bVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(g7bVar, it);
            g7bVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            g7bVar.onSubscribe(hcb.c());
            g7bVar.onError(th);
        }
    }
}
