package rx.internal.operators;

import com.baidu.tieba.qjc;
import com.baidu.tieba.wjc;
import com.baidu.tieba.xjc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements wjc, qjc {
    public static final long serialVersionUID = 4262875056400218316L;
    public xjc<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(xjc<? super Resource> xjcVar, Resource resource) {
        this.dispose = xjcVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.xjc<? super Resource>, Resource] */
    @Override // com.baidu.tieba.wjc
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

    @Override // com.baidu.tieba.qjc
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
        call();
    }
}
