package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes7.dex */
public final class b implements k {
    private volatile boolean oNL;
    private Set<k> oUu;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oNL;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.oNL) {
                synchronized (this) {
                    if (!this.oNL) {
                        if (this.oUu == null) {
                            this.oUu = new HashSet(4);
                        }
                        this.oUu.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.oNL) {
            synchronized (this) {
                if (!this.oNL && this.oUu != null) {
                    boolean remove = this.oUu.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.oNL) {
            synchronized (this) {
                if (!this.oNL) {
                    this.oNL = true;
                    Set<k> set = this.oUu;
                    this.oUu = null;
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
            rx.exceptions.a.gl(arrayList);
        }
    }
}
