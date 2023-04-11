package rx.internal.operators;

import com.baidu.tieba.c2b;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<c2b<T>> {
    public final Collection<c2b<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        c2b<T> c2bVar = get();
        if (c2bVar != null) {
            unsubscribeOthers(c2bVar);
        }
    }

    public void unsubscribeOthers(c2b<T> c2bVar) {
        for (c2b<T> c2bVar2 : this.ambSubscribers) {
            if (c2bVar2 != c2bVar) {
                c2bVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
