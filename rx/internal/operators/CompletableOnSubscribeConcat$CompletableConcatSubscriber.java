package rx.internal.operators;

import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends v7c<n7c> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements o7c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.o7c
        public void onSubscribe(w7c w7cVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(w7cVar);
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
