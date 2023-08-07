package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.v0c;
import com.baidu.tieba.w0c;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends d1c<v0c> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements w0c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.w0c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.w0c
        public void onSubscribe(e1c e1cVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(e1cVar);
        }

        @Override // com.baidu.tieba.w0c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
