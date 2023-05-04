package rx.internal.operators;

import com.baidu.tieba.q5b;
import com.baidu.tieba.w5b;
import com.baidu.tieba.x5b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements w5b, q5b {
    public static final long serialVersionUID = 4262875056400218316L;
    public x5b<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(x5b<? super Resource> x5bVar, Resource resource) {
        this.dispose = x5bVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.x5b<? super Resource>, Resource] */
    @Override // com.baidu.tieba.w5b
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

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        call();
    }
}
