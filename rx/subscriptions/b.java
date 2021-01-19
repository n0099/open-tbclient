package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes14.dex */
public final class b implements k {
    private volatile boolean qoe;
    private Set<k> quL;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qoe;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qoe) {
                synchronized (this) {
                    if (!this.qoe) {
                        if (this.quL == null) {
                            this.quL = new HashSet(4);
                        }
                        this.quL.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qoe) {
            synchronized (this) {
                if (!this.qoe && this.quL != null) {
                    boolean remove = this.quL.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qoe) {
            synchronized (this) {
                if (!this.qoe) {
                    this.qoe = true;
                    Set<k> set = this.quL;
                    this.quL = null;
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
            rx.exceptions.a.ho(arrayList);
        }
    }
}
