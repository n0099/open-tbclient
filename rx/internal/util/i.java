package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes7.dex */
public final class i implements k {
    private volatile boolean oNL;
    private List<k> oSQ;

    public i() {
    }

    public i(k... kVarArr) {
        this.oSQ = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.oSQ = new LinkedList();
        this.oSQ.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oNL;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.oNL) {
                synchronized (this) {
                    if (!this.oNL) {
                        List list = this.oSQ;
                        if (list == null) {
                            list = new LinkedList();
                            this.oSQ = list;
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
        if (!this.oNL) {
            synchronized (this) {
                List<k> list = this.oSQ;
                if (!this.oNL && list != null) {
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
        if (!this.oNL) {
            synchronized (this) {
                if (!this.oNL) {
                    this.oNL = true;
                    List<k> list = this.oSQ;
                    this.oSQ = null;
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
            rx.exceptions.a.gl(arrayList);
        }
    }
}
