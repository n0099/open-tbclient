package rx.internal.operators;

import com.baidu.tieba.ayb;
import com.baidu.tieba.etb;
import com.baidu.tieba.vsb;
import com.baidu.tieba.wsb;
import com.baidu.tieba.zxb;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements vsb.f {
    public final Iterable<? extends vsb> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements wsb {
        public static final long serialVersionUID = -7965400327305809232L;
        public final wsb actual;
        public final zxb sd = new zxb();
        public final Iterator<? extends vsb> sources;

        public ConcatInnerSubscriber(wsb wsbVar, Iterator<? extends vsb> it) {
            this.actual = wsbVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends vsb> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        vsb next = it.next();
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

        @Override // com.baidu.tieba.wsb
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.wsb
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.wsb
        public void onSubscribe(etb etbVar) {
            this.sd.a(etbVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends vsb> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vsb.f, com.baidu.tieba.ltb
    public void call(wsb wsbVar) {
        try {
            Iterator<? extends vsb> it = this.a.iterator();
            if (it == null) {
                wsbVar.onSubscribe(ayb.c());
                wsbVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(wsbVar, it);
            wsbVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            wsbVar.onSubscribe(ayb.c());
            wsbVar.onError(th);
        }
    }
}
