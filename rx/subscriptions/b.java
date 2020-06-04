package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean nFs;
    private Set<k> nMc;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nFs;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nFs) {
                synchronized (this) {
                    if (!this.nFs) {
                        if (this.nMc == null) {
                            this.nMc = new HashSet(4);
                        }
                        this.nMc.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.nFs) {
            synchronized (this) {
                if (!this.nFs && this.nMc != null) {
                    boolean remove = this.nMc.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.nFs) {
            synchronized (this) {
                if (!this.nFs) {
                    this.nFs = true;
                    Set<k> set = this.nMc;
                    this.nMc = null;
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
            rx.exceptions.a.fx(arrayList);
        }
    }
}
