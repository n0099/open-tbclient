package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes5.dex */
public final class b implements k {
    private volatile boolean oDO;
    private Set<k> oKy;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oDO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.oDO) {
                synchronized (this) {
                    if (!this.oDO) {
                        if (this.oKy == null) {
                            this.oKy = new HashSet(4);
                        }
                        this.oKy.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.oDO) {
            synchronized (this) {
                if (!this.oDO && this.oKy != null) {
                    boolean remove = this.oKy.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.oDO) {
            synchronized (this) {
                if (!this.oDO) {
                    this.oDO = true;
                    Set<k> set = this.oKy;
                    this.oKy = null;
                    v(set);
                }
            }
        }
    }

    private static void v(Collection<k> collection) {
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
            rx.exceptions.a.gc(arrayList);
        }
    }
}
