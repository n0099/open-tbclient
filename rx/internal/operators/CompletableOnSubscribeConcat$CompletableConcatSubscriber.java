package rx.internal.operators;

import com.baidu.tieba.mra;
import com.baidu.tieba.nra;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends ura<mra> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes9.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements nra {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.nra
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.nra
        public void onSubscribe(vra vraVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(vraVar);
        }

        @Override // com.baidu.tieba.nra
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
