package rx.internal.operators;

import com.baidu.tieba.f1c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.m1c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements l1c, f1c {
    public static final long serialVersionUID = 4262875056400218316L;
    public m1c<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(m1c<? super Resource> m1cVar, Resource resource) {
        this.dispose = m1cVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.m1c<? super Resource>] */
    @Override // com.baidu.tieba.l1c
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

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        call();
    }
}
