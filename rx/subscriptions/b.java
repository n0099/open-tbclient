package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean iEx;
    private Set<k> iRJ;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iEx;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iEx) {
                synchronized (this) {
                    if (!this.iEx) {
                        if (this.iRJ == null) {
                            this.iRJ = new HashSet(4);
                        }
                        this.iRJ.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iEx) {
            synchronized (this) {
                if (!this.iEx && this.iRJ != null) {
                    boolean remove = this.iRJ.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.iEx) {
            synchronized (this) {
                if (!this.iEx) {
                    this.iEx = true;
                    Set<k> set = this.iRJ;
                    this.iRJ = null;
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
            rx.exceptions.a.eA(arrayList);
        }
    }
}
