package rx.internal.operators;

import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.koc;
import com.baidu.tieba.loc;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends koc<coc> {
    public final SequentialSubscription e;

    public abstract void g();

    public abstract void h(Throwable th);

    /* loaded from: classes2.dex */
    public final class ConcatInnerSubscriber extends AtomicInteger implements doc {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        @Override // com.baidu.tieba.doc
        public void onError(Throwable th) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.h(th);
        }

        @Override // com.baidu.tieba.doc
        public void onSubscribe(loc locVar) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.e.set(locVar);
        }

        @Override // com.baidu.tieba.doc
        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.g();
        }
    }
}
