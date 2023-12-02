package rx.internal.operators;

import com.baidu.tieba.boc;
import com.baidu.tieba.coc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends joc<boc> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements coc {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.coc
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.coc
        public void onSubscribe(koc kocVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(kocVar);
        }

        @Override // com.baidu.tieba.coc
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
