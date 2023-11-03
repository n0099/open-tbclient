package rx.internal.operators;

import com.baidu.tieba.gjc;
import com.baidu.tieba.hjc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.pjc;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends ojc<gjc> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements hjc {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.hjc
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.hjc
        public void onSubscribe(pjc pjcVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(pjcVar);
        }

        @Override // com.baidu.tieba.hjc
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
