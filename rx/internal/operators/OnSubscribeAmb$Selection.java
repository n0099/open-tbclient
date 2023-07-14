package rx.internal.operators;

import com.baidu.tieba.s2c;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<s2c<T>> {
    public final Collection<s2c<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        s2c<T> s2cVar = get();
        if (s2cVar != null) {
            unsubscribeOthers(s2cVar);
        }
    }

    public void unsubscribeOthers(s2c<T> s2cVar) {
        for (s2c<T> s2cVar2 : this.ambSubscribers) {
            if (s2cVar2 != s2cVar) {
                s2cVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
