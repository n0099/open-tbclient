package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.vsb;
import com.baidu.tieba.wsb;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends dtb<vsb> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements wsb {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.wsb
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.wsb
        public void onSubscribe(etb etbVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(etbVar);
        }

        @Override // com.baidu.tieba.wsb
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
