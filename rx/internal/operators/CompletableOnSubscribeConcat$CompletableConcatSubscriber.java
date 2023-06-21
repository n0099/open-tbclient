package rx.internal.operators;

import com.baidu.tieba.eob;
import com.baidu.tieba.fob;
import com.baidu.tieba.mob;
import com.baidu.tieba.nob;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends mob<eob> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements fob {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.fob
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.fob
        public void onSubscribe(nob nobVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(nobVar);
        }

        @Override // com.baidu.tieba.fob
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
