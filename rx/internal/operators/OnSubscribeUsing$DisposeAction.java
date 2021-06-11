package rx.internal.operators;

import h.k;
import h.n.a;
import h.n.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements a, k {
    public static final long serialVersionUID = 4262875056400218316L;
    public b<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(b<? super Resource> bVar, Resource resource) {
        this.dispose = bVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, h.n.b<? super Resource>] */
    @Override // h.n.a
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

    @Override // h.k
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // h.k
    public void unsubscribe() {
        call();
    }
}
