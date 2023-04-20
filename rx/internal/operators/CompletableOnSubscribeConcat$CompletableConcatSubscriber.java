package rx.internal.operators;

import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends t1b<l1b> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes9.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements m1b {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.m1b
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.m1b
        public void onSubscribe(u1b u1bVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(u1bVar);
        }

        @Override // com.baidu.tieba.m1b
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
