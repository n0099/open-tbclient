package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean ojQ;
    private List<k> ooW;

    public i() {
    }

    public i(k... kVarArr) {
        this.ooW = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ooW = new LinkedList();
        this.ooW.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ojQ;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ojQ) {
                synchronized (this) {
                    if (!this.ojQ) {
                        List list = this.ooW;
                        if (list == null) {
                            list = new LinkedList();
                            this.ooW = list;
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
        if (!this.ojQ) {
            synchronized (this) {
                List<k> list = this.ooW;
                if (!this.ojQ && list != null) {
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
        if (!this.ojQ) {
            synchronized (this) {
                if (!this.ojQ) {
                    this.ojQ = true;
                    List<k> list = this.ooW;
                    this.ooW = null;
                    t(list);
                }
            }
        }
    }

    private static void t(Collection<k> collection) {
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
            rx.exceptions.a.fS(arrayList);
        }
    }
}
