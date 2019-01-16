package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class j implements k {
    private volatile boolean iFE;
    private List<k> iQz;

    public j() {
    }

    public j(k... kVarArr) {
        this.iQz = new LinkedList(Arrays.asList(kVarArr));
    }

    public j(k kVar) {
        this.iQz = new LinkedList();
        this.iQz.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iFE;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iFE) {
                synchronized (this) {
                    if (!this.iFE) {
                        List list = this.iQz;
                        if (list == null) {
                            list = new LinkedList();
                            this.iQz = list;
                        }
                        list.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iFE) {
            synchronized (this) {
                List<k> list = this.iQz;
                if (!this.iFE && list != null) {
                    boolean remove = list.remove(kVar);
                    if (remove) {
                        kVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (!this.iFE) {
            synchronized (this) {
                if (!this.iFE) {
                    this.iFE = true;
                    List<k> list = this.iQz;
                    this.iQz = null;
                    n(list);
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
            rx.exceptions.a.eB(arrayList);
        }
    }
}
