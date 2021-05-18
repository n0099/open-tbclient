package rx.internal.operators;

import h.b;
import h.c;
import h.j;
import h.k;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes7.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends j<b> {

    /* renamed from: e  reason: collision with root package name */
    public final SequentialSubscription f69022e;

    /* loaded from: classes7.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // h.c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.b();
        }

        @Override // h.c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.c(th);
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.f69022e.set(kVar);
        }
    }

    public abstract void b();

    public abstract void c(Throwable th);
}
