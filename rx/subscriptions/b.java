package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> kGs;
    private volatile boolean kyP;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kyP;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kyP) {
                synchronized (this) {
                    if (!this.kyP) {
                        if (this.kGs == null) {
                            this.kGs = new HashSet(4);
                        }
                        this.kGs.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.kyP) {
            synchronized (this) {
                if (!this.kyP && this.kGs != null) {
                    boolean remove = this.kGs.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.kyP) {
            synchronized (this) {
                if (!this.kyP) {
                    this.kyP = true;
                    Set<k> set = this.kGs;
                    this.kGs = null;
                    l(set);
                }
            }
        }
    }

    private static void l(Collection<k> collection) {
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
            rx.exceptions.a.fa(arrayList);
        }
    }
}
