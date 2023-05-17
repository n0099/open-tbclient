package rx.internal.operators;

import com.baidu.tieba.f7b;
import com.baidu.tieba.g7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes10.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends n7b<f7b> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes10.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements g7b {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.g7b
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.g7b
        public void onSubscribe(o7b o7bVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(o7bVar);
        }

        @Override // com.baidu.tieba.g7b
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
