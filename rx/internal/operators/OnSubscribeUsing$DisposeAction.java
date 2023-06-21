package rx.internal.operators;

import com.baidu.tieba.nob;
import com.baidu.tieba.tob;
import com.baidu.tieba.uob;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements tob, nob {
    public static final long serialVersionUID = 4262875056400218316L;
    public uob<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(uob<? super Resource> uobVar, Resource resource) {
        this.dispose = uobVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.uob<? super Resource>, Resource] */
    @Override // com.baidu.tieba.tob
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

    @Override // com.baidu.tieba.nob
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
        call();
    }
}
