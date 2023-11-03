package rx.internal.operators;

import com.baidu.tieba.gjc;
import com.baidu.tieba.hjc;
import com.baidu.tieba.noc;
import com.baidu.tieba.ooc;
import com.baidu.tieba.pjc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements gjc.f {
    public final Iterable<? extends gjc> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements hjc {
        public static final long serialVersionUID = -7965400327305809232L;
        public final hjc actual;
        public final noc sd = new noc();
        public final Iterator<? extends gjc> sources;

        public ConcatInnerSubscriber(hjc hjcVar, Iterator<? extends gjc> it) {
            this.actual = hjcVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends gjc> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        gjc next = it.next();
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

        @Override // com.baidu.tieba.hjc
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.hjc
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.hjc
        public void onSubscribe(pjc pjcVar) {
            this.sd.a(pjcVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends gjc> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wjc
    /* renamed from: a */
    public void call(hjc hjcVar) {
        try {
            Iterator<? extends gjc> it = this.a.iterator();
            if (it == null) {
                hjcVar.onSubscribe(ooc.c());
                hjcVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(hjcVar, it);
            hjcVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            hjcVar.onSubscribe(ooc.c());
            hjcVar.onError(th);
        }
    }
}
