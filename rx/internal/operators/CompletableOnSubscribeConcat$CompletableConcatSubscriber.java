package rx.internal.operators;

import com.baidu.tieba.hjc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.qjc;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends pjc<hjc> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements ijc {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.ijc
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.ijc
        public void onSubscribe(qjc qjcVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(qjcVar);
        }

        @Override // com.baidu.tieba.ijc
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
