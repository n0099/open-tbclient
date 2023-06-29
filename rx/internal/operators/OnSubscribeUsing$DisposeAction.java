package rx.internal.operators;

import com.baidu.tieba.etb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.ltb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements ktb, etb {
    public static final long serialVersionUID = 4262875056400218316L;
    public ltb<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(ltb<? super Resource> ltbVar, Resource resource) {
        this.dispose = ltbVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.ltb<? super Resource>] */
    @Override // com.baidu.tieba.ktb
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

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        call();
    }
}
