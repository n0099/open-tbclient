package rx.internal.operators;

import com.baidu.tieba.e8b;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<e8b<T>> {
    public final Collection<e8b<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        e8b<T> e8bVar = get();
        if (e8bVar != null) {
            unsubscribeOthers(e8bVar);
        }
    }

    public void unsubscribeOthers(e8b<T> e8bVar) {
        for (e8b<T> e8bVar2 : this.ambSubscribers) {
            if (e8bVar2 != e8bVar) {
                e8bVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
