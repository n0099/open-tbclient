package rx.internal.operators;

import com.baidu.tieba.pmb;
import com.baidu.tieba.vmb;
import com.baidu.tieba.wmb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements vmb, pmb {
    public static final long serialVersionUID = 4262875056400218316L;
    public wmb<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(wmb<? super Resource> wmbVar, Resource resource) {
        this.dispose = wmbVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.wmb<? super Resource>] */
    @Override // com.baidu.tieba.vmb
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

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        call();
    }
}
