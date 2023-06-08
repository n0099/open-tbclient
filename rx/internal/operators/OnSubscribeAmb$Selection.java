package rx.internal.operators;

import com.baidu.tieba.knb;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<knb<T>> {
    public final Collection<knb<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        knb<T> knbVar = get();
        if (knbVar != null) {
            unsubscribeOthers(knbVar);
        }
    }

    public void unsubscribeOthers(knb<T> knbVar) {
        for (knb<T> knbVar2 : this.ambSubscribers) {
            if (knbVar2 != knbVar) {
                knbVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
