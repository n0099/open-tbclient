package rx.internal.operators;

import com.baidu.tieba.l7c;
import com.baidu.tieba.m7c;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.u7c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements l7c.f {
    public final Iterable<? extends l7c> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements m7c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final m7c actual;
        public final qcc sd = new qcc();
        public final Iterator<? extends l7c> sources;

        public ConcatInnerSubscriber(m7c m7cVar, Iterator<? extends l7c> it) {
            this.actual = m7cVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends l7c> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        l7c next = it.next();
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

        @Override // com.baidu.tieba.m7c
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.m7c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.m7c
        public void onSubscribe(u7c u7cVar) {
            this.sd.a(u7cVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends l7c> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l7c.f, com.baidu.tieba.b8c
    public void call(m7c m7cVar) {
        try {
            Iterator<? extends l7c> it = this.a.iterator();
            if (it == null) {
                m7cVar.onSubscribe(rcc.c());
                m7cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(m7cVar, it);
            m7cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            m7cVar.onSubscribe(rcc.c());
            m7cVar.onError(th);
        }
    }
}
