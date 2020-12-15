package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes12.dex */
public final class b implements k {
    private volatile boolean pPv;
    private Set<k> pWe;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pPv;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pPv) {
                synchronized (this) {
                    if (!this.pPv) {
                        if (this.pWe == null) {
                            this.pWe = new HashSet(4);
                        }
                        this.pWe.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.pPv) {
            synchronized (this) {
                if (!this.pPv && this.pWe != null) {
                    boolean remove = this.pWe.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.pPv) {
            synchronized (this) {
                if (!this.pPv) {
                    this.pPv = true;
                    Set<k> set = this.pWe;
                    this.pWe = null;
                    u(set);
                }
            }
        }
    }

    private static void u(Collection<k> collection) {
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
            rx.exceptions.a.hg(arrayList);
        }
    }
}
