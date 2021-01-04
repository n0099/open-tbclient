package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes15.dex */
public final class b implements k {
    private volatile boolean qqX;
    private Set<k> qxE;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qqX;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qqX) {
                synchronized (this) {
                    if (!this.qqX) {
                        if (this.qxE == null) {
                            this.qxE = new HashSet(4);
                        }
                        this.qxE.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.qqX) {
            synchronized (this) {
                if (!this.qqX && this.qxE != null) {
                    boolean remove = this.qxE.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.qqX) {
            synchronized (this) {
                if (!this.qqX) {
                    this.qqX = true;
                    Set<k> set = this.qxE;
                    this.qxE = null;
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
            rx.exceptions.a.hn(arrayList);
        }
    }
}
