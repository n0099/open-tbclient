package rx.internal.operators;

import com.baidu.tieba.a6c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.v0c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.z5c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements v0c.f {
    public final Iterable<? extends v0c> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements w0c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final w0c actual;
        public final z5c sd = new z5c();
        public final Iterator<? extends v0c> sources;

        public ConcatInnerSubscriber(w0c w0cVar, Iterator<? extends v0c> it) {
            this.actual = w0cVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends v0c> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        v0c next = it.next();
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

        @Override // com.baidu.tieba.w0c
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.w0c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.w0c
        public void onSubscribe(e1c e1cVar) {
            this.sd.a(e1cVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends v0c> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v0c.f, com.baidu.tieba.l1c
    public void call(w0c w0cVar) {
        try {
            Iterator<? extends v0c> it = this.a.iterator();
            if (it == null) {
                w0cVar.onSubscribe(a6c.c());
                w0cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(w0cVar, it);
            w0cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            w0cVar.onSubscribe(a6c.c());
            w0cVar.onError(th);
        }
    }
}
