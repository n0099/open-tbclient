package rx.internal.operators;

import com.baidu.tieba.v1c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<v1c<T>> {
    public final Collection<v1c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        v1c<T> v1cVar = get();
        if (v1cVar != null) {
            unsubscribeOthers(v1cVar);
        }
    }

    public void unsubscribeOthers(v1c<T> v1cVar) {
        for (v1c<T> v1cVar2 : this.ambSubscribers) {
            if (v1cVar2 != v1cVar) {
                v1cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
