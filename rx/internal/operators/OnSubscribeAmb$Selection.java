package rx.internal.operators;

import h.o.a.c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<c<T>> {
    public final Collection<c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        c<T> cVar = get();
        if (cVar != null) {
            unsubscribeOthers(cVar);
        }
    }

    public void unsubscribeOthers(c<T> cVar) {
        for (c<T> cVar2 : this.ambSubscribers) {
            if (cVar2 != cVar) {
                cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
