package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.w0c;
import com.baidu.tieba.x0c;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends e1c<w0c> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements x0c {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.x0c
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.x0c
        public void onSubscribe(f1c f1cVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(f1cVar);
        }

        @Override // com.baidu.tieba.x0c
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
