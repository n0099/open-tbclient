package rx.internal.operators;

import com.baidu.tieba.qac;
import com.baidu.tieba.rac;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends yac<qac> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements rac {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.rac
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.rac
        public void onSubscribe(zac zacVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(zacVar);
        }

        @Override // com.baidu.tieba.rac
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
