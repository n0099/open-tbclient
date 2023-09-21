package rx.internal.operators;

import com.baidu.tieba.jdc;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<jdc<T>> {
    public final Collection<jdc<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        jdc<T> jdcVar = get();
        if (jdcVar != null) {
            unsubscribeOthers(jdcVar);
        }
    }

    public void unsubscribeOthers(jdc<T> jdcVar) {
        for (jdc<T> jdcVar2 : this.ambSubscribers) {
            if (jdcVar2 != jdcVar) {
                jdcVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
