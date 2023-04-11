package rx.internal.operators;

import com.baidu.tieba.b6b;
import com.baidu.tieba.c6b;
import com.baidu.tieba.d1b;
import com.baidu.tieba.e1b;
import com.baidu.tieba.m1b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatIterable implements d1b.f {
    public final Iterable<? extends d1b> a;

    /* loaded from: classes9.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements e1b {
        public static final long serialVersionUID = -7965400327305809232L;
        public final e1b actual;
        public final b6b sd = new b6b();
        public final Iterator<? extends d1b> sources;

        public ConcatInnerSubscriber(e1b e1bVar, Iterator<? extends d1b> it) {
            this.actual = e1bVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends d1b> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        d1b next = it.next();
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

        @Override // com.baidu.tieba.e1b
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.e1b
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.e1b
        public void onSubscribe(m1b m1bVar) {
            this.sd.a(m1bVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends d1b> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d1b.f, com.baidu.tieba.t1b
    public void call(e1b e1bVar) {
        try {
            Iterator<? extends d1b> it = this.a.iterator();
            if (it == null) {
                e1bVar.onSubscribe(c6b.c());
                e1bVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(e1bVar, it);
            e1bVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            e1bVar.onSubscribe(c6b.c());
            e1bVar.onError(th);
        }
    }
}
