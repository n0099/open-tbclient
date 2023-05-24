package rx.internal.operators;

import com.baidu.tieba.f8b;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<f8b<T>> {
    public final Collection<f8b<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        f8b<T> f8bVar = get();
        if (f8bVar != null) {
            unsubscribeOthers(f8bVar);
        }
    }

    public void unsubscribeOthers(f8b<T> f8bVar) {
        for (f8b<T> f8bVar2 : this.ambSubscribers) {
            if (f8bVar2 != f8bVar) {
                f8bVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
