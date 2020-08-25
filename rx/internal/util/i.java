package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes5.dex */
public final class i implements k {
    private volatile boolean oDO;
    private List<k> oIT;

    public i() {
    }

    public i(k... kVarArr) {
        this.oIT = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.oIT = new LinkedList();
        this.oIT.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oDO;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.oDO) {
                synchronized (this) {
                    if (!this.oDO) {
                        List list = this.oIT;
                        if (list == null) {
                            list = new LinkedList();
                            this.oIT = list;
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
        if (!this.oDO) {
            synchronized (this) {
                List<k> list = this.oIT;
                if (!this.oDO && list != null) {
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
        if (!this.oDO) {
            synchronized (this) {
                if (!this.oDO) {
                    this.oDO = true;
                    List<k> list = this.oIT;
                    this.oIT = null;
                    v(list);
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
            rx.exceptions.a.gc(arrayList);
        }
    }
}
