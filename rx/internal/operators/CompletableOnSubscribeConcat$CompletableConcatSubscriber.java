package rx.internal.operators;

import com.baidu.tieba.gmb;
import com.baidu.tieba.hmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends omb<gmb> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements hmb {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.hmb
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.hmb
        public void onSubscribe(pmb pmbVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(pmbVar);
        }

        @Override // com.baidu.tieba.hmb
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
