package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes4.dex */
public final class i implements k {
    private volatile boolean ndG;
    private List<k> niM;

    public i() {
    }

    public i(k... kVarArr) {
        this.niM = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.niM = new LinkedList();
        this.niM.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ndG;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ndG) {
                synchronized (this) {
                    if (!this.ndG) {
                        List list = this.niM;
                        if (list == null) {
                            list = new LinkedList();
                            this.niM = list;
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
        if (!this.ndG) {
            synchronized (this) {
                List<k> list = this.niM;
                if (!this.ndG && list != null) {
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
        if (!this.ndG) {
            synchronized (this) {
                if (!this.ndG) {
                    this.ndG = true;
                    List<k> list = this.niM;
                    this.niM = null;
                    q(list);
                }
            }
        }
    }

    private static void q(Collection<k> collection) {
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
            rx.exceptions.a.fF(arrayList);
        }
    }
}
