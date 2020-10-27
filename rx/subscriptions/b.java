package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes16.dex */
public final class b implements k {
    private volatile boolean pUu;
    private Set<k> qbd;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pUu;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pUu) {
                synchronized (this) {
                    if (!this.pUu) {
                        if (this.qbd == null) {
                            this.qbd = new HashSet(4);
                        }
                        this.qbd.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.pUu) {
            synchronized (this) {
                if (!this.pUu && this.qbd != null) {
                    boolean remove = this.qbd.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.pUu) {
            synchronized (this) {
                if (!this.pUu) {
                    this.pUu = true;
                    Set<k> set = this.qbd;
                    this.qbd = null;
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
            rx.exceptions.a.gK(arrayList);
        }
    }
}
