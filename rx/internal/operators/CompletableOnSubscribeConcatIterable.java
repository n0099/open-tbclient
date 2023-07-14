package rx.internal.operators;

import com.baidu.tieba.b2c;
import com.baidu.tieba.s1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.w6c;
import com.baidu.tieba.x6c;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements s1c.f {
    public final Iterable<? extends s1c> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements t1c {
        public static final long serialVersionUID = -7965400327305809232L;
        public final t1c actual;
        public final w6c sd = new w6c();
        public final Iterator<? extends s1c> sources;

        public ConcatInnerSubscriber(t1c t1cVar, Iterator<? extends s1c> it) {
            this.actual = t1cVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends s1c> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        s1c next = it.next();
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

        @Override // com.baidu.tieba.t1c
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.t1c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.t1c
        public void onSubscribe(b2c b2cVar) {
            this.sd.a(b2cVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends s1c> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
    public void call(t1c t1cVar) {
        try {
            Iterator<? extends s1c> it = this.a.iterator();
            if (it == null) {
                t1cVar.onSubscribe(x6c.c());
                t1cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(t1cVar, it);
            t1cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            t1cVar.onSubscribe(x6c.c());
            t1cVar.onError(th);
        }
    }
}
