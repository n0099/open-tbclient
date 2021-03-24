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
    public final SequentialSubscription f68147e;

    /* loaded from: classes7.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // h.c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.b();
            throw null;
        }

        @Override // h.c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.c(th);
            throw null;
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.f68147e.set(kVar);
        }
    }

    public void b() {
        throw null;
    }

    public void c(Throwable th) {
        throw null;
    }
}
