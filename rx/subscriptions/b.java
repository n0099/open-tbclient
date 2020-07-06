package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes6.dex */
public final class b implements k {
    private volatile boolean obg;
    private Set<k> ohT;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.obg;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.obg) {
                synchronized (this) {
                    if (!this.obg) {
                        if (this.ohT == null) {
                            this.ohT = new HashSet(4);
                        }
                        this.ohT.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.obg) {
            synchronized (this) {
                if (!this.obg && this.ohT != null) {
                    boolean remove = this.ohT.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.obg) {
            synchronized (this) {
                if (!this.obg) {
                    this.obg = true;
                    Set<k> set = this.ohT;
                    this.ohT = null;
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
