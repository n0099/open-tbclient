package rx.internal.operators;

import com.baidu.tieba.g6b;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<g6b<T>> {
    public final Collection<g6b<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        g6b<T> g6bVar = get();
        if (g6bVar != null) {
            unsubscribeOthers(g6bVar);
        }
    }

    public void unsubscribeOthers(g6b<T> g6bVar) {
        for (g6b<T> g6bVar2 : this.ambSubscribers) {
            if (g6bVar2 != g6bVar) {
                g6bVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
