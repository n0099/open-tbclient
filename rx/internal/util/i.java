package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes12.dex */
public final class i implements k {
    private volatile boolean pPt;
    private List<k> pUy;

    public i() {
    }

    public i(k... kVarArr) {
        this.pUy = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.pUy = new LinkedList();
        this.pUy.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pPt;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pPt) {
                synchronized (this) {
                    if (!this.pPt) {
                        List list = this.pUy;
                        if (list == null) {
                            list = new LinkedList();
                            this.pUy = list;
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
        if (!this.pPt) {
            synchronized (this) {
                List<k> list = this.pUy;
                if (!this.pPt && list != null) {
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
        if (!this.pPt) {
            synchronized (this) {
                if (!this.pPt) {
                    this.pPt = true;
                    List<k> list = this.pUy;
                    this.pUy = null;
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
            rx.exceptions.a.hg(arrayList);
        }
    }
}
