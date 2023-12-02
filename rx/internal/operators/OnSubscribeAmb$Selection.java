package rx.internal.operators;

import com.baidu.tieba.epc;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<epc<T>> {
    public final Collection<epc<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        epc<T> epcVar = get();
        if (epcVar != null) {
            unsubscribeOthers(epcVar);
        }
    }

    public void unsubscribeOthers(epc<T> epcVar) {
        for (epc<T> epcVar2 : this.ambSubscribers) {
            if (epcVar2 != epcVar) {
                epcVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
