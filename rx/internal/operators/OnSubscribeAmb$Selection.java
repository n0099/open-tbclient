package rx.internal.operators;

import com.baidu.tieba.fpc;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<fpc<T>> {
    public final Collection<fpc<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        fpc<T> fpcVar = get();
        if (fpcVar != null) {
            unsubscribeOthers(fpcVar);
        }
    }

    public void unsubscribeOthers(fpc<T> fpcVar) {
        for (fpc<T> fpcVar2 : this.ambSubscribers) {
            if (fpcVar2 != fpcVar) {
                fpcVar2.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
