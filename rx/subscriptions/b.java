package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> kFB;
    private volatile boolean kxY;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kxY;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kxY) {
                synchronized (this) {
                    if (!this.kxY) {
                        if (this.kFB == null) {
                            this.kFB = new HashSet(4);
                        }
                        this.kFB.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.kxY) {
            synchronized (this) {
                if (!this.kxY && this.kFB != null) {
                    boolean remove = this.kFB.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.kxY) {
            synchronized (this) {
                if (!this.kxY) {
                    this.kxY = true;
                    Set<k> set = this.kFB;
                    this.kFB = null;
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
