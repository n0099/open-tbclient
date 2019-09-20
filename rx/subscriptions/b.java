package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.k;
/* loaded from: classes2.dex */
public final class b implements k {
    private Set<k> kFL;
    private volatile boolean kyh;

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kyh;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kyh) {
                synchronized (this) {
                    if (!this.kyh) {
                        if (this.kFL == null) {
                            this.kFL = new HashSet(4);
                        }
                        this.kFL.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.kyh) {
            synchronized (this) {
                if (!this.kyh && this.kFL != null) {
                    boolean remove = this.kFL.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.kyh) {
            synchronized (this) {
                if (!this.kyh) {
                    this.kyh = true;
                    Set<k> set = this.kFL;
                    this.kFL = null;
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
            rx.exceptions.a.eM(arrayList);
        }
    }
}
