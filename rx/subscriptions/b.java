package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nNM;
    private Set<k> nUt;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nNM;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nNM) {
                synchronized (this) {
                    if (!this.nNM) {
                        if (this.nUt == null) {
                            this.nUt = new HashSet(4);
                        }
                        this.nUt.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nNM) {
            synchronized (this) {
                if (!this.nNM && this.nUt != null) {
                    boolean remove = this.nUt.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nNM) {
            synchronized (this) {
                if (!this.nNM) {
                    this.nNM = true;
                    Set<k> set = this.nUt;
                    this.nUt = null;
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
            rx.exceptions.a.fA(arrayList);
        }
    }
}
