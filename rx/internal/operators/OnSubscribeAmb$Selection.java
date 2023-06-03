package rx.internal.operators;

import com.baidu.tieba.fnb;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<fnb<T>> {
    public final Collection<fnb<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        fnb<T> fnbVar = get();
        if (fnbVar != null) {
            unsubscribeOthers(fnbVar);
        }
    }

    public void unsubscribeOthers(fnb<T> fnbVar) {
        for (fnb<T> fnbVar2 : this.ambSubscribers) {
            if (fnbVar2 != fnbVar) {
                fnbVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
