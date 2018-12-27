package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class j implements k {
    private volatile boolean iEx;
    private List<k> iPs;

    public j() {
    }

    public j(k... kVarArr) {
        this.iPs = new LinkedList(Arrays.asList(kVarArr));
    }

    public j(k kVar) {
        this.iPs = new LinkedList();
        this.iPs.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iEx;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iEx) {
                synchronized (this) {
                    if (!this.iEx) {
                        List list = this.iPs;
                        if (list == null) {
                            list = new LinkedList();
                            this.iPs = list;
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
        if (!this.iEx) {
            synchronized (this) {
                List<k> list = this.iPs;
                if (!this.iEx && list != null) {
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
        if (!this.iEx) {
            synchronized (this) {
                if (!this.iEx) {
                    this.iEx = true;
                    List<k> list = this.iPs;
                    this.iPs = null;
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
            rx.exceptions.a.eA(arrayList);
        }
    }
}
