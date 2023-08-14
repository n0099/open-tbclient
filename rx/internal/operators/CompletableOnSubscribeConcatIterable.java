package rx.internal.operators;

import com.baidu.tieba.a6c;
import com.baidu.tieba.b6c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.x0c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements w0c.f {
    public final Iterable<? extends w0c> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements x0c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final x0c actual;
        public final a6c sd = new a6c();
        public final Iterator<? extends w0c> sources;

        public ConcatInnerSubscriber(x0c x0cVar, Iterator<? extends w0c> it) {
            this.actual = x0cVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends w0c> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        w0c next = it.next();
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

        @Override // com.baidu.tieba.x0c
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.x0c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.x0c
        public void onSubscribe(f1c f1cVar) {
            this.sd.a(f1cVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends w0c> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w0c.f, com.baidu.tieba.m1c
    public void call(x0c x0cVar) {
        try {
            Iterator<? extends w0c> it = this.a.iterator();
            if (it == null) {
                x0cVar.onSubscribe(b6c.c());
                x0cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(x0cVar, it);
            x0cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            x0cVar.onSubscribe(b6c.c());
            x0cVar.onError(th);
        }
    }
}
