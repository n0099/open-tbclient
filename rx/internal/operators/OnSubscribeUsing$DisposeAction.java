package rx.internal.operators;

import com.baidu.tieba.anb;
import com.baidu.tieba.bnb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements anb, umb {
    public static final long serialVersionUID = 4262875056400218316L;
    public bnb<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(bnb<? super Resource> bnbVar, Resource resource) {
        this.dispose = bnbVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.bnb<? super Resource>, Resource] */
    @Override // com.baidu.tieba.anb
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

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        call();
    }
}
