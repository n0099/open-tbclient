package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private volatile boolean jUO;
    private Set<k> kcu;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jUO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jUO) {
                synchronized (this) {
                    if (!this.jUO) {
                        if (this.kcu == null) {
                            this.kcu = new HashSet(4);
                        }
                        this.kcu.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.jUO) {
            synchronized (this) {
                if (!this.jUO && this.kcu != null) {
                    boolean remove = this.kcu.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.jUO) {
            synchronized (this) {
                if (!this.jUO) {
                    this.jUO = true;
                    Set<k> set = this.kcu;
                    this.kcu = null;
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
