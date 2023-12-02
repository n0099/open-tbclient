package rx.internal.operators;

import com.baidu.tieba.boc;
import com.baidu.tieba.coc;
import com.baidu.tieba.itc;
import com.baidu.tieba.jtc;
import com.baidu.tieba.koc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements boc.f {
    public final Iterable<? extends boc> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements coc {
        public static final long serialVersionUID = -7965400327305809232L;
        public final coc actual;
        public final itc sd = new itc();
        public final Iterator<? extends boc> sources;

        public ConcatInnerSubscriber(coc cocVar, Iterator<? extends boc> it) {
            this.actual = cocVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends boc> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        boc next = it.next();
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

        @Override // com.baidu.tieba.coc
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.coc
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.coc
        public void onSubscribe(koc kocVar) {
            this.sd.a(kocVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends boc> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    public void call(coc cocVar) {
        try {
            Iterator<? extends boc> it = this.a.iterator();
            if (it == null) {
                cocVar.onSubscribe(jtc.c());
                cocVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(cocVar, it);
            cocVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            cocVar.onSubscribe(jtc.c());
            cocVar.onError(th);
        }
    }
}
