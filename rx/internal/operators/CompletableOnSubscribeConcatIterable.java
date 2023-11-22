package rx.internal.operators;

import com.baidu.tieba.hjc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.ooc;
import com.baidu.tieba.poc;
import com.baidu.tieba.qjc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements hjc.f {
    public final Iterable<? extends hjc> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements ijc {
        public static final long serialVersionUID = -7965400327305809232L;
        public final ijc actual;
        public final ooc sd = new ooc();
        public final Iterator<? extends hjc> sources;

        public ConcatInnerSubscriber(ijc ijcVar, Iterator<? extends hjc> it) {
            this.actual = ijcVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends hjc> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        hjc next = it.next();
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

        @Override // com.baidu.tieba.ijc
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.ijc
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.ijc
        public void onSubscribe(qjc qjcVar) {
            this.sd.a(qjcVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends hjc> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xjc
    /* renamed from: a */
    public void call(ijc ijcVar) {
        try {
            Iterator<? extends hjc> it = this.a.iterator();
            if (it == null) {
                ijcVar.onSubscribe(poc.c());
                ijcVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(ijcVar, it);
            ijcVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            ijcVar.onSubscribe(poc.c());
            ijcVar.onError(th);
        }
    }
}
