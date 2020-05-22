package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nEi;
    private Set<k> nKS;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nEi;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nEi) {
                synchronized (this) {
                    if (!this.nEi) {
                        if (this.nKS == null) {
                            this.nKS = new HashSet(4);
                        }
                        this.nKS.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nEi) {
            synchronized (this) {
                if (!this.nEi && this.nKS != null) {
                    boolean remove = this.nKS.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nEi) {
            synchronized (this) {
                if (!this.nEi) {
                    this.nEi = true;
                    Set<k> set = this.nKS;
                    this.nKS = null;
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
            rx.exceptions.a.fv(arrayList);
        }
    }
}
