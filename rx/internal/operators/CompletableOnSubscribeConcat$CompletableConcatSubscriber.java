package rx.internal.operators;

import com.baidu.tieba.d1b;
import com.baidu.tieba.e1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends l1b<d1b> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes9.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements e1b {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.e1b
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.e1b
        public void onSubscribe(m1b m1bVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(m1bVar);
        }

        @Override // com.baidu.tieba.e1b
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
