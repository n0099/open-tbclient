package rx.internal.operators;

import com.baidu.tieba.o8c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<o8c<T>> {
    public final Collection<o8c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        o8c<T> o8cVar = get();
        if (o8cVar != null) {
            unsubscribeOthers(o8cVar);
        }
    }

    public void unsubscribeOthers(o8c<T> o8cVar) {
        for (o8c<T> o8cVar2 : this.ambSubscribers) {
            if (o8cVar2 != o8cVar) {
                o8cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
