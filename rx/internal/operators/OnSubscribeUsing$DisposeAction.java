package rx.internal.operators;

import com.baidu.tieba.m1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.t1b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements s1b, m1b {
    public static final long serialVersionUID = 4262875056400218316L;
    public t1b<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(t1b<? super Resource> t1bVar, Resource resource) {
        this.dispose = t1bVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.t1b<? super Resource>, Resource] */
    @Override // com.baidu.tieba.s1b
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

    @Override // com.baidu.tieba.m1b
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        call();
    }
}
