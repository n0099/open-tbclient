package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean njf;
    private Set<k> npR;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.njf;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.njf) {
                synchronized (this) {
                    if (!this.njf) {
                        if (this.npR == null) {
                            this.npR = new HashSet(4);
                        }
                        this.npR.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.njf) {
            synchronized (this) {
                if (!this.njf && this.npR != null) {
                    boolean remove = this.npR.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.njf) {
            synchronized (this) {
                if (!this.njf) {
                    this.njf = true;
                    Set<k> set = this.npR;
                    this.npR = null;
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
            rx.exceptions.a.fo(arrayList);
        }
    }
}
