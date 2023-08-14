package rx.internal.operators;

import com.baidu.tieba.w1c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<w1c<T>> {
    public final Collection<w1c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        w1c<T> w1cVar = get();
        if (w1cVar != null) {
            unsubscribeOthers(w1cVar);
        }
    }

    public void unsubscribeOthers(w1c<T> w1cVar) {
        for (w1c<T> w1cVar2 : this.ambSubscribers) {
            if (w1cVar2 != w1cVar) {
                w1cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
