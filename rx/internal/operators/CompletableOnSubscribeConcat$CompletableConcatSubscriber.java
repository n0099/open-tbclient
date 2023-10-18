package rx.internal.operators;

import com.baidu.tieba.f6c;
import com.baidu.tieba.g6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends n6c<f6c> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements g6c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.g6c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.g6c
        public void onSubscribe(o6c o6cVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(o6cVar);
        }

        @Override // com.baidu.tieba.g6c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
