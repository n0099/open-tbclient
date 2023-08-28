package rx.internal.operators;

import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.scc;
import com.baidu.tieba.tcc;
import com.baidu.tieba.w7c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements n7c.f {
    public final Iterable<? extends n7c> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements o7c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final o7c actual;
        public final scc sd = new scc();
        public final Iterator<? extends n7c> sources;

        public ConcatInnerSubscriber(o7c o7cVar, Iterator<? extends n7c> it) {
            this.actual = o7cVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends n7c> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        n7c next = it.next();
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

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.o7c
        public void onSubscribe(w7c w7cVar) {
            this.sd.a(w7cVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends n7c> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n7c.f, com.baidu.tieba.d8c
    public void call(o7c o7cVar) {
        try {
            Iterator<? extends n7c> it = this.a.iterator();
            if (it == null) {
                o7cVar.onSubscribe(tcc.c());
                o7cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(o7cVar, it);
            o7cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            o7cVar.onSubscribe(tcc.c());
            o7cVar.onError(th);
        }
    }
}
