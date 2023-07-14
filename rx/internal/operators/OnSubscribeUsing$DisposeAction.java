package rx.internal.operators;

import com.baidu.tieba.b2c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.i2c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OnSubscribeUsing$DisposeAction<Resource> extends AtomicBoolean implements h2c, b2c {
    public static final long serialVersionUID = 4262875056400218316L;
    public i2c<? super Resource> dispose;
    public Resource resource;

    public OnSubscribeUsing$DisposeAction(i2c<? super Resource> i2cVar, Resource resource) {
        this.dispose = i2cVar;
        this.resource = resource;
        lazySet(false);
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: Resource, ? super Resource */
    /* JADX WARN: Type inference failed for: r0v2, types: [Resource, com.baidu.tieba.i2c<? super Resource>] */
    @Override // com.baidu.tieba.h2c
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

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        return get();
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        call();
    }
}
