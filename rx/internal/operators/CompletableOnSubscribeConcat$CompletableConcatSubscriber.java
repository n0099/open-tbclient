package rx.internal.operators;

import com.baidu.tieba.l7c;
import com.baidu.tieba.m7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends t7c<l7c> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements m7c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.m7c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.m7c
        public void onSubscribe(u7c u7cVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(u7cVar);
        }

        @Override // com.baidu.tieba.m7c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
