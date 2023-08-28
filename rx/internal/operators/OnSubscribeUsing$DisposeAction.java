package rx.internal.operators;

import com.baidu.tieba.c8c;
import com.baidu.tieba.d8c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements c8c, w7c {
    public static final long serialVersionUID = 4262875056400218316L;
    public d8c<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(d8c<? super Resource> d8cVar, Resource resource) {
        this.dispose = d8cVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.d8c<? super Resource>] */
    @Override // com.baidu.tieba.c8c
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

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        call();
    }
}
