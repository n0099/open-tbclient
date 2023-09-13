package rx.internal.operators;

import com.baidu.tieba.rbc;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<rbc<T>> {
    public final Collection<rbc<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        rbc<T> rbcVar = get();
        if (rbcVar != null) {
            unsubscribeOthers(rbcVar);
        }
    }

    public void unsubscribeOthers(rbc<T> rbcVar) {
        for (rbc<T> rbcVar2 : this.ambSubscribers) {
            if (rbcVar2 != rbcVar) {
                rbcVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
