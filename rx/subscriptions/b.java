package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean jUP;
    private Set<k> kcv;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jUP;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jUP) {
                synchronized (this) {
                    if (!this.jUP) {
                        if (this.kcv == null) {
                            this.kcv = new HashSet(4);
                        }
                        this.kcv.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.jUP) {
            synchronized (this) {
                if (!this.jUP && this.kcv != null) {
                    boolean remove = this.kcv.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.jUP) {
            synchronized (this) {
                if (!this.jUP) {
                    this.jUP = true;
                    Set<k> set = this.kcv;
                    this.kcv = null;
                    n(set);
                }
            }
        }
    }

    private static void n(Collection<k> collection) {
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
            rx.exceptions.a.eC(arrayList);
        }
    }
}
