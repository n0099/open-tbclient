package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> iHs;
    private volatile boolean iue;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iue;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iue) {
                synchronized (this) {
                    if (!this.iue) {
                        if (this.iHs == null) {
                            this.iHs = new HashSet(4);
                        }
                        this.iHs.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iue) {
            synchronized (this) {
                if (!this.iue && this.iHs != null) {
                    boolean remove = this.iHs.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.iue) {
            synchronized (this) {
                if (!this.iue) {
                    this.iue = true;
                    Set<k> set = this.iHs;
                    this.iHs = null;
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
            rx.exceptions.a.ev(arrayList);
        }
    }
}
