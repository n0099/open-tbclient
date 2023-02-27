package rx.internal.operators;

import com.baidu.tieba.fna;
import com.baidu.tieba.gna;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements fna, zma {
    public static final long serialVersionUID = 4262875056400218316L;
    public gna<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(gna<? super Resource> gnaVar, Resource resource) {
        this.dispose = gnaVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.gna<? super Resource>] */
    @Override // com.baidu.tieba.fna
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

    @Override // com.baidu.tieba.zma
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        call();
    }
}
