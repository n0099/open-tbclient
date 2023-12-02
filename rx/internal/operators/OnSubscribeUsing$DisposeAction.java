package rx.internal.operators;

import com.baidu.tieba.koc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.roc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements qoc, koc {
    public static final long serialVersionUID = 4262875056400218316L;
    public roc<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(roc<? super Resource> rocVar, Resource resource) {
        this.dispose = rocVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.roc<? super Resource>, Resource] */
    @Override // com.baidu.tieba.qoc
    public void call() {
        if (compareAndSet(false, true)) {
            ?? r0 = (Resource) false;
            try {
                this.dispose.call((Resource) this.resource);
            } finally {
                this.resource = null;
                this.dispose = null;
            }
        }
    }

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        call();
    }
}
