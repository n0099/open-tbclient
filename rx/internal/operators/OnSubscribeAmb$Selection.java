package rx.internal.operators;

import com.baidu.tieba.lsa;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<lsa<T>> {
    public final Collection<lsa<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        lsa<T> lsaVar = get();
        if (lsaVar != null) {
            unsubscribeOthers(lsaVar);
        }
    }

    public void unsubscribeOthers(lsa<T> lsaVar) {
        for (lsa<T> lsaVar2 : this.ambSubscribers) {
            if (lsaVar2 != lsaVar) {
                lsaVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
