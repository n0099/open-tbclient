package rx.internal.operators;

import com.baidu.tieba.pna;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<pna<T>> {
    public final Collection<pna<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        pna<T> pnaVar = get();
        if (pnaVar != null) {
            unsubscribeOthers(pnaVar);
        }
    }

    public void unsubscribeOthers(pna<T> pnaVar) {
        for (pna<T> pnaVar2 : this.ambSubscribers) {
            if (pnaVar2 != pnaVar) {
                pnaVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
