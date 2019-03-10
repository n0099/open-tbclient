package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean jVE;
    private Set<k> kdk;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jVE;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jVE) {
                synchronized (this) {
                    if (!this.jVE) {
                        if (this.kdk == null) {
                            this.kdk = new HashSet(4);
                        }
                        this.kdk.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.jVE) {
            synchronized (this) {
                if (!this.jVE && this.kdk != null) {
                    boolean remove = this.kdk.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.jVE) {
            synchronized (this) {
                if (!this.jVE) {
                    this.jVE = true;
                    Set<k> set = this.kdk;
                    this.kdk = null;
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
            rx.exceptions.a.eF(arrayList);
        }
    }
}
