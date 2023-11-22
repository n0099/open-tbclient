package rx.internal.operators;

import com.baidu.tieba.kkc;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<kkc<T>> {
    public final Collection<kkc<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        kkc<T> kkcVar = get();
        if (kkcVar != null) {
            unsubscribeOthers(kkcVar);
        }
    }

    public void unsubscribeOthers(kkc<T> kkcVar) {
        for (kkc<T> kkcVar2 : this.ambSubscribers) {
            if (kkcVar2 != kkcVar) {
                kkcVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
