package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
/* loaded from: classes4.dex */
public final class CompletableOnSubscribeConcatArray implements b.a {
    final rx.b[] sources;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: a */
    public void call(rx.c cVar) {
        ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(cVar, this.sources);
        cVar.onSubscribe(concatInnerSubscriber.sd);
        concatInnerSubscriber.next();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements rx.c {
        private static final long serialVersionUID = -7965400327305809232L;
        final rx.c actual;
        int index;
        final rx.subscriptions.d sd = new rx.subscriptions.d();
        final rx.b[] sources;

        public ConcatInnerSubscriber(rx.c cVar, rx.b[] bVarArr) {
            this.actual = cVar;
            this.sources = bVarArr;
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
                rx.b[] bVarArr = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    int i = this.index;
                    this.index = i + 1;
                    if (i == bVarArr.length) {
                        this.actual.onCompleted();
                        return;
                    }
                    bVarArr[i].b(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }
}
