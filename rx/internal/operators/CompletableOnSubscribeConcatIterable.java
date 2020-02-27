package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
/* loaded from: classes6.dex */
public final class CompletableOnSubscribeConcatIterable implements b.a {
    final Iterable<? extends rx.b> nwm;

    public CompletableOnSubscribeConcatIterable(Iterable<? extends rx.b> iterable) {
        this.nwm = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: a */
    public void call(rx.c cVar) {
        try {
            Iterator<? extends rx.b> it = this.nwm.iterator();
            if (it == null) {
                cVar.onSubscribe(rx.subscriptions.e.dPA());
                cVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(cVar, it);
            cVar.onSubscribe(concatInnerSubscriber.sd);
            concatInnerSubscriber.next();
        } catch (Throwable th) {
            cVar.onSubscribe(rx.subscriptions.e.dPA());
            cVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements rx.c {
        private static final long serialVersionUID = -7965400327305809232L;
        final rx.c actual;
        final rx.subscriptions.d sd = new rx.subscriptions.d();
        final Iterator<? extends rx.b> sources;

        public ConcatInnerSubscriber(rx.c cVar, Iterator<? extends rx.b> it) {
            this.actual = cVar;
            this.sources = it;
        }

        @Override // rx.c
        public void onSubscribe(rx.k kVar) {
            this.sd.f(kVar);
        }

        @Override // rx.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // rx.c
        public void onCompleted() {
            next();
        }

        void next() {
            if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends rx.b> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            rx.b next = it.next();
                            if (next == null) {
                                this.actual.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            next.b(this);
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
        }
    }
}
