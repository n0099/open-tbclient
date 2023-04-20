package rx.internal.operators;

import com.baidu.tieba.k2b;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<k2b<T>> {
    public final Collection<k2b<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        k2b<T> k2bVar = get();
        if (k2bVar != null) {
            unsubscribeOthers(k2bVar);
        }
    }

    public void unsubscribeOthers(k2b<T> k2bVar) {
        for (k2b<T> k2bVar2 : this.ambSubscribers) {
            if (k2bVar2 != k2bVar) {
                k2bVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
