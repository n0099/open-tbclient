package rx.internal.operators;

import com.baidu.tieba.f6c;
import com.baidu.tieba.g6c;
import com.baidu.tieba.mbc;
import com.baidu.tieba.nbc;
import com.baidu.tieba.o6c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements f6c.f {
    public final Iterable<? extends f6c> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements g6c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final g6c actual;
        public final mbc sd = new mbc();
        public final Iterator<? extends f6c> sources;

        public ConcatInnerSubscriber(g6c g6cVar, Iterator<? extends f6c> it) {
            this.actual = g6cVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends f6c> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        f6c next = it.next();
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

        @Override // com.baidu.tieba.g6c
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.g6c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.g6c
        public void onSubscribe(o6c o6cVar) {
            this.sd.a(o6cVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends f6c> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v6c
    /* renamed from: a */
    public void call(g6c g6cVar) {
        try {
            Iterator<? extends f6c> it = this.a.iterator();
            if (it == null) {
                g6cVar.onSubscribe(nbc.c());
                g6cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(g6cVar, it);
            g6cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            g6cVar.onSubscribe(nbc.c());
            g6cVar.onError(th);
        }
    }
}
