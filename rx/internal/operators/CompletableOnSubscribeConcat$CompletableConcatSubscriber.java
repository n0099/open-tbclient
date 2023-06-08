package rx.internal.operators;

import com.baidu.tieba.lmb;
import com.baidu.tieba.mmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends tmb<lmb> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements mmb {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.mmb
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.mmb
        public void onSubscribe(umb umbVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(umbVar);
        }

        @Override // com.baidu.tieba.mmb
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
