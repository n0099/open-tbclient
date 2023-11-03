package rx.internal.operators;

import com.baidu.tieba.pjc;
import com.baidu.tieba.vjc;
import com.baidu.tieba.wjc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements vjc, pjc {
    public static final long serialVersionUID = 4262875056400218316L;
    public wjc<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(wjc<? super Resource> wjcVar, Resource resource) {
        this.dispose = wjcVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.wjc<? super Resource>] */
    @Override // com.baidu.tieba.vjc
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

    @Override // com.baidu.tieba.pjc
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
        call();
    }
}
