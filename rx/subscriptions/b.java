package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean iFE;
    private Set<k> iSQ;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFE;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iFE) {
                synchronized (this) {
                    if (!this.iFE) {
                        if (this.iSQ == null) {
                            this.iSQ = new HashSet(4);
                        }
                        this.iSQ.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iFE) {
            synchronized (this) {
                if (!this.iFE && this.iSQ != null) {
                    boolean remove = this.iSQ.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.iFE) {
            synchronized (this) {
                if (!this.iFE) {
                    this.iFE = true;
                    Set<k> set = this.iSQ;
                    this.iSQ = null;
                    n(set);
                }
            }
        }
    }

    private static void n(Collection<k> collection) {
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
            rx.exceptions.a.eB(arrayList);
        }
    }
}
