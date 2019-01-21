package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean iFF;
    private Set<k> iSR;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFF;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iFF) {
                synchronized (this) {
                    if (!this.iFF) {
                        if (this.iSR == null) {
                            this.iSR = new HashSet(4);
                        }
                        this.iSR.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iFF) {
            synchronized (this) {
                if (!this.iFF && this.iSR != null) {
                    boolean remove = this.iSR.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.iFF) {
            synchronized (this) {
                if (!this.iFF) {
                    this.iFF = true;
                    Set<k> set = this.iSR;
                    this.iSR = null;
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
