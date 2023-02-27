package rx.internal.operators;

import com.baidu.tieba.qma;
import com.baidu.tieba.rma;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends yma<qma> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes9.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements rma {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.rma
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.rma
        public void onSubscribe(zma zmaVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(zmaVar);
        }

        @Override // com.baidu.tieba.rma
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
