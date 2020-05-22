package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes6.dex */
public final class CompletableOnSubscribeConcat implements b.a {
    final rx.d<rx.b> nEv;
    final int prefetch;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: a */
    public void call(rx.c cVar) {
        CompletableConcatSubscriber completableConcatSubscriber = new CompletableConcatSubscriber(cVar, this.prefetch);
        cVar.onSubscribe(completableConcatSubscriber);
        this.nEv.a((rx.j<? super rx.b>) completableConcatSubscriber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class CompletableConcatSubscriber extends rx.j<rx.b> {
        volatile boolean active;
        final rx.c actual;
        volatile boolean done;
        final rx.internal.util.a.q<rx.b> nEx;
        final SequentialSubscription nEw = new SequentialSubscription();
        final ConcatInnerSubscriber nEy = new ConcatInnerSubscriber();
        final AtomicBoolean once = new AtomicBoolean();

        public CompletableConcatSubscriber(rx.c cVar, int i) {
            this.actual = cVar;
            this.nEx = new rx.internal.util.a.q<>(i);
            add(this.nEw);
            request(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: a */
        public void onNext(rx.b bVar) {
            if (!this.nEx.offer(bVar)) {
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                rx.c.c.onError(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        void innerError(Throwable th) {
            unsubscribe();
            onError(th);
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void drain() {
            ConcatInnerSubscriber concatInnerSubscriber = this.nEy;
            if (concatInnerSubscriber.getAndIncrement() == 0) {
                while (!isUnsubscribed()) {
                    if (!this.active) {
                        boolean z = this.done;
                        rx.b poll = this.nEx.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.actual.onCompleted();
                            return;
                        } else if (!z2) {
                            this.active = true;
                            poll.c(concatInnerSubscriber);
                            request(1L);
                        }
                    }
                    if (concatInnerSubscriber.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public final class ConcatInnerSubscriber extends AtomicInteger implements rx.c {
            private static final long serialVersionUID = 7233503139645205620L;

            ConcatInnerSubscriber() {
            }

            @Override // rx.c
            public void onSubscribe(rx.k kVar) {
                CompletableConcatSubscriber.this.nEw.set(kVar);
            }

            @Override // rx.c
            public void onError(Throwable th) {
                CompletableConcatSubscriber.this.innerError(th);
            }

            @Override // rx.c
            public void onCompleted() {
                CompletableConcatSubscriber.this.innerComplete();
            }
        }
    }
}
