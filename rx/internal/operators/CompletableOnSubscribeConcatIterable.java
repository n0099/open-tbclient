package rx.internal.operators;

import com.baidu.tieba.j6b;
import com.baidu.tieba.k6b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.u1b;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatIterable implements l1b.f {
    public final Iterable<? extends l1b> a;

    /* loaded from: classes9.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements m1b {
        public static final long serialVersionUID = -7965400327305809232L;
        public final m1b actual;
        public final j6b sd = new j6b();
        public final Iterator<? extends l1b> sources;

        public ConcatInnerSubscriber(m1b m1bVar, Iterator<? extends l1b> it) {
            this.actual = m1bVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends l1b> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        l1b next = it.next();
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

        @Override // com.baidu.tieba.m1b
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.m1b
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.m1b
        public void onSubscribe(u1b u1bVar) {
            this.sd.a(u1bVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends l1b> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l1b.f, com.baidu.tieba.b2b
    public void call(m1b m1bVar) {
        try {
            Iterator<? extends l1b> it = this.a.iterator();
            if (it == null) {
                m1bVar.onSubscribe(k6b.c());
                m1bVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(m1bVar, it);
            m1bVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            m1bVar.onSubscribe(k6b.c());
            m1bVar.onError(th);
        }
    }
}
