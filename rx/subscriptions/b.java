package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes16.dex */
public final class b implements k {
    private volatile boolean pdb;
    private Set<k> pjN;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pdb;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pdb) {
                synchronized (this) {
                    if (!this.pdb) {
                        if (this.pjN == null) {
                            this.pjN = new HashSet(4);
                        }
                        this.pjN.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.pdb) {
            synchronized (this) {
                if (!this.pdb && this.pjN != null) {
                    boolean remove = this.pjN.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.pdb) {
            synchronized (this) {
                if (!this.pdb) {
                    this.pdb = true;
                    Set<k> set = this.pjN;
                    this.pjN = null;
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
            rx.exceptions.a.go(arrayList);
        }
    }
}
