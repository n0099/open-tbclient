package rx.internal.operators;

import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.jtc;
import com.baidu.tieba.ktc;
import com.baidu.tieba.loc;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcatIterable implements coc.f {
    public final Iterable<? extends coc> a;

    /* loaded from: classes2.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements doc {
        public static final long serialVersionUID = -7965400327305809232L;
        public final doc actual;
        public final jtc sd = new jtc();
        public final Iterator<? extends coc> sources;

        public ConcatInnerSubscriber(doc docVar, Iterator<? extends coc> it) {
            this.actual = docVar;
            this.sources = it;
        }

        public void next() {
            if (this.sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends coc> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        coc next = it.next();
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

        @Override // com.baidu.tieba.doc
        public void onCompleted() {
            next();
        }

        @Override // com.baidu.tieba.doc
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // com.baidu.tieba.doc
        public void onSubscribe(loc locVar) {
            this.sd.a(locVar);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends coc> iterable) {
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.soc
    /* renamed from: a */
    public void call(doc docVar) {
        try {
            Iterator<? extends coc> it = this.a.iterator();
            if (it == null) {
                docVar.onSubscribe(ktc.c());
                docVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(docVar, it);
            docVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            docVar.onSubscribe(ktc.c());
            docVar.onError(th);
        }
    }
}
