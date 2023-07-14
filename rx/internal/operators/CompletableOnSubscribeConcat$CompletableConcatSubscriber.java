package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.s1c;
import com.baidu.tieba.t1c;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends a2c<s1c> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements t1c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.t1c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.t1c
        public void onSubscribe(b2c b2cVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(b2cVar);
        }

        @Override // com.baidu.tieba.t1c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
