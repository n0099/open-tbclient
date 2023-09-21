package rx.internal.operators;

import com.baidu.tieba.icc;
import com.baidu.tieba.jcc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends qcc<icc> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements jcc {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.jcc
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.jcc
        public void onSubscribe(rcc rccVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(rccVar);
        }

        @Override // com.baidu.tieba.jcc
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
