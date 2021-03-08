package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes4.dex */
public final class i implements k {
    private List<k> qEm;
    private volatile boolean qzj;

    public i() {
    }

    public i(k... kVarArr) {
        this.qEm = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qEm = new LinkedList();
        this.qEm.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qzj;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qzj) {
                synchronized (this) {
                    if (!this.qzj) {
                        List list = this.qEm;
                        if (list == null) {
                            list = new LinkedList();
                            this.qEm = list;
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
        if (!this.qzj) {
            synchronized (this) {
                List<k> list = this.qEm;
                if (!this.qzj && list != null) {
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
        if (!this.qzj) {
            synchronized (this) {
                if (!this.qzj) {
                    this.qzj = true;
                    List<k> list = this.qEm;
                    this.qEm = null;
                    u(list);
                }
            }
        }
    }

    private static void u(Collection<k> collection) {
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
            rx.exceptions.a.hj(arrayList);
        }
    }
}
