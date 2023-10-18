package rx.internal.operators;

import com.baidu.tieba.i7c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<i7c<T>> {
    public final Collection<i7c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        i7c<T> i7cVar = get();
        if (i7cVar != null) {
            unsubscribeOthers(i7cVar);
        }
    }

    public void unsubscribeOthers(i7c<T> i7cVar) {
        for (i7c<T> i7cVar2 : this.ambSubscribers) {
            if (i7cVar2 != i7cVar) {
                i7cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
