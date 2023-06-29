package rx.internal.operators;

import com.baidu.tieba.vtb;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<vtb<T>> {
    public final Collection<vtb<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        vtb<T> vtbVar = get();
        if (vtbVar != null) {
            unsubscribeOthers(vtbVar);
        }
    }

    public void unsubscribeOthers(vtb<T> vtbVar) {
        for (vtb<T> vtbVar2 : this.ambSubscribers) {
            if (vtbVar2 != vtbVar) {
                vtbVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
