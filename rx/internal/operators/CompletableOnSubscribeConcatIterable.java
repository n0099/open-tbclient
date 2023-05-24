package rx.internal.operators;

import com.baidu.tieba.g7b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.hcb;
import com.baidu.tieba.icb;
import com.baidu.tieba.p7b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class CompletableOnSubscribeConcatIterable implements g7b.f {
    public final Iterable<? extends g7b> a;

    /* loaded from: classes10.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements h7b {
        public static final long serialVersionUID = -7965400327305809232L;
        public final h7b actual;
        public final hcb sd = new hcb();
        public final Iterator<? extends g7b> sources;

        public ConcatInnerSubscriber(h7b h7bVar, Iterator<? extends g7b> it) {
            this.actual = h7bVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends g7b> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        g7b next = it.next();
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

        @Override // com.baidu.tieba.h7b
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.h7b
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.h7b
        public void onSubscribe(p7b p7bVar) {
            this.sd.a(p7bVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends g7b> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g7b.f, com.baidu.tieba.w7b
    public void call(h7b h7bVar) {
        try {
            Iterator<? extends g7b> it = this.a.iterator();
            if (it == null) {
                h7bVar.onSubscribe(icb.c());
                h7bVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(h7bVar, it);
            h7bVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            h7bVar.onSubscribe(icb.c());
            h7bVar.onError(th);
        }
    }
}
