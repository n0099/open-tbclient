package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean obd;
    private Set<k> ohQ;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.obd;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.obd) {
                synchronized (this) {
                    if (!this.obd) {
                        if (this.ohQ == null) {
                            this.ohQ = new HashSet(4);
                        }
                        this.ohQ.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.obd) {
            synchronized (this) {
                if (!this.obd && this.ohQ != null) {
                    boolean remove = this.ohQ.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.obd) {
            synchronized (this) {
                if (!this.obd) {
                    this.obd = true;
                    Set<k> set = this.ohQ;
                    this.ohQ = null;
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
            rx.exceptions.a.fJ(arrayList);
        }
    }
}
