package rx.internal.operators;

import com.baidu.tieba.jkc;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<jkc<T>> {
    public final Collection<jkc<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        jkc<T> jkcVar = get();
        if (jkcVar != null) {
            unsubscribeOthers(jkcVar);
        }
    }

    public void unsubscribeOthers(jkc<T> jkcVar) {
        for (jkc<T> jkcVar2 : this.ambSubscribers) {
            if (jkcVar2 != jkcVar) {
                jkcVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
