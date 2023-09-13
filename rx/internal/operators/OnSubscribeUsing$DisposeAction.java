package rx.internal.operators;

import com.baidu.tieba.fbc;
import com.baidu.tieba.gbc;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements fbc, zac {
    public static final long serialVersionUID = 4262875056400218316L;
    public gbc<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(gbc<? super Resource> gbcVar, Resource resource) {
        this.dispose = gbcVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.gbc<? super Resource>, Resource] */
    @Override // com.baidu.tieba.fbc
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

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        call();
    }
}
