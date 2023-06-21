package rx.internal.operators;

import com.baidu.tieba.dpb;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<dpb<T>> {
    public final Collection<dpb<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        dpb<T> dpbVar = get();
        if (dpbVar != null) {
            unsubscribeOthers(dpbVar);
        }
    }

    public void unsubscribeOthers(dpb<T> dpbVar) {
        for (dpb<T> dpbVar2 : this.ambSubscribers) {
            if (dpbVar2 != dpbVar) {
                dpbVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
