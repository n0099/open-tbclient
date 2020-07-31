package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean ojQ;
    private Set<k> oqC;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ojQ;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ojQ) {
                synchronized (this) {
                    if (!this.ojQ) {
                        if (this.oqC == null) {
                            this.oqC = new HashSet(4);
                        }
                        this.oqC.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.ojQ) {
            synchronized (this) {
                if (!this.ojQ && this.oqC != null) {
                    boolean remove = this.oqC.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.ojQ) {
            synchronized (this) {
                if (!this.ojQ) {
                    this.ojQ = true;
                    Set<k> set = this.oqC;
                    this.oqC = null;
                    t(set);
                }
            }
        }
    }

    private static void t(Collection<k> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (k kVar : collection) {
                try {
                    kVar.unsubscribe();
                } catch (Throwable th) {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(th);
                    arrayList = arrayList2;
                }
            }
            rx.exceptions.a.fS(arrayList);
        }
    }
}
