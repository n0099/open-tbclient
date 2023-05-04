package rx.internal.operators;

import com.baidu.tieba.h5b;
import com.baidu.tieba.i5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends p5b<h5b> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes9.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements i5b {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.i5b
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.i5b
        public void onSubscribe(q5b q5bVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(q5bVar);
        }

        @Override // com.baidu.tieba.i5b
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
