package rx.internal.operators;

import com.baidu.tieba.loc;
import com.baidu.tieba.roc;
import com.baidu.tieba.soc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements roc, loc {
    public static final long serialVersionUID = 4262875056400218316L;
    public soc<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(soc<? super Resource> socVar, Resource resource) {
        this.dispose = socVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.soc<? super Resource>, Resource] */
    @Override // com.baidu.tieba.roc
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

    @Override // com.baidu.tieba.loc
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
        call();
    }
}
