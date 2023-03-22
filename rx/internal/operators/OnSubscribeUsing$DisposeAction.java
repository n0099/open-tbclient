package rx.internal.operators;

import com.baidu.tieba.bsa;
import com.baidu.tieba.csa;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements bsa, vra {
    public static final long serialVersionUID = 4262875056400218316L;
    public csa<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(csa<? super Resource> csaVar, Resource resource) {
        this.dispose = csaVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.csa<? super Resource>, Resource] */
    @Override // com.baidu.tieba.bsa
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

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        call();
    }
}
