package rx.internal.operators;

import com.baidu.tieba.h5b;
import com.baidu.tieba.hab;
import com.baidu.tieba.i5b;
import com.baidu.tieba.iab;
import com.baidu.tieba.q5b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatIterable implements h5b.f {
    public final Iterable<? extends h5b> a;

    /* loaded from: classes9.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements i5b {
        public static final long serialVersionUID = -7965400327305809232L;
        public final i5b actual;
        public final hab sd = new hab();
        public final Iterator<? extends h5b> sources;

        public ConcatInnerSubscriber(i5b i5bVar, Iterator<? extends h5b> it) {
            this.actual = i5bVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends h5b> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        h5b next = it.next();
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

        @Override // com.baidu.tieba.i5b
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.i5b
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.i5b
        public void onSubscribe(q5b q5bVar) {
            this.sd.a(q5bVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends h5b> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h5b.f, com.baidu.tieba.x5b
    public void call(i5b i5bVar) {
        try {
            Iterator<? extends h5b> it = this.a.iterator();
            if (it == null) {
                i5bVar.onSubscribe(iab.c());
                i5bVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(i5bVar, it);
            i5bVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            i5bVar.onSubscribe(iab.c());
            i5bVar.onError(th);
        }
    }
}
