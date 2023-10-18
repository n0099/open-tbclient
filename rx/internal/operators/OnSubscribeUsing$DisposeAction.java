package rx.internal.operators;

import com.baidu.tieba.o6c;
import com.baidu.tieba.u6c;
import com.baidu.tieba.v6c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements u6c, o6c {
    public static final long serialVersionUID = 4262875056400218316L;
    public v6c<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(v6c<? super Resource> v6cVar, Resource resource) {
        this.dispose = v6cVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.v6c<? super Resource>, Resource] */
    @Override // com.baidu.tieba.u6c
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

    @Override // com.baidu.tieba.o6c
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
        call();
    }
}
