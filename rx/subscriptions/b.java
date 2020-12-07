package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes12.dex */
public final class b implements k {
    private volatile boolean pPt;
    private Set<k> pWc;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pPt;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pPt) {
                synchronized (this) {
                    if (!this.pPt) {
                        if (this.pWc == null) {
                            this.pWc = new HashSet(4);
                        }
                        this.pWc.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.pPt) {
            synchronized (this) {
                if (!this.pPt && this.pWc != null) {
                    boolean remove = this.pWc.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.pPt) {
            synchronized (this) {
                if (!this.pPt) {
                    this.pPt = true;
                    Set<k> set = this.pWc;
                    this.pWc = null;
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
