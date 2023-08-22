package rx.internal.operators;

import com.baidu.tieba.m8c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<m8c<T>> {
    public final Collection<m8c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        m8c<T> m8cVar = get();
        if (m8cVar != null) {
            unsubscribeOthers(m8cVar);
        }
    }

    public void unsubscribeOthers(m8c<T> m8cVar) {
        for (m8c<T> m8cVar2 : this.ambSubscribers) {
            if (m8cVar2 != m8cVar) {
                m8cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
