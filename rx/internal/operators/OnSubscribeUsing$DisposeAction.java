package rx.internal.operators;

import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import com.baidu.tieba.v7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements u7b, o7b {
    public static final long serialVersionUID = 4262875056400218316L;
    public v7b<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(v7b<? super Resource> v7bVar, Resource resource) {
        this.dispose = v7bVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.v7b<? super Resource>, Resource] */
    @Override // com.baidu.tieba.u7b
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

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        call();
    }
}
