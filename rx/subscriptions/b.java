package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes5.dex */
public final class b implements k {
    private volatile boolean nMK;
    private Set<k> nTs;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMK;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nMK) {
                synchronized (this) {
                    if (!this.nMK) {
                        if (this.nTs == null) {
                            this.nTs = new HashSet(4);
                        }
                        this.nTs.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nMK) {
            synchronized (this) {
                if (!this.nMK && this.nTs != null) {
                    boolean remove = this.nTs.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nMK) {
            synchronized (this) {
                if (!this.nMK) {
                    this.nMK = true;
                    Set<k> set = this.nTs;
                    this.nTs = null;
                    r(set);
                }
            }
        }
    }

    private static void r(Collection<k> collection) {
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
            rx.exceptions.a.fG(arrayList);
        }
    }
}
