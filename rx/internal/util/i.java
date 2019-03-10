package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean jVE;
    private List<k> kbq;

    public i() {
    }

    public i(k... kVarArr) {
        this.kbq = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kbq = new LinkedList();
        this.kbq.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.jVE;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.jVE) {
                synchronized (this) {
                    if (!this.jVE) {
                        List list = this.kbq;
                        if (list == null) {
                            list = new LinkedList();
                            this.kbq = list;
                        }
                        list.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void a(k kVar) {
        if (!this.jVE) {
            synchronized (this) {
                List<k> list = this.kbq;
                if (!this.jVE && list != null) {
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
        if (!this.jVE) {
            synchronized (this) {
                if (!this.jVE) {
                    this.jVE = true;
                    List<k> list = this.kbq;
                    this.kbq = null;
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
            rx.exceptions.a.eF(arrayList);
        }
    }
}
