package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes15.dex */
public final class i implements k {
    private volatile boolean qsF;
    private List<k> qxI;

    public i() {
    }

    public i(k... kVarArr) {
        this.qxI = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qxI = new LinkedList();
        this.qxI.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qsF;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qsF) {
                synchronized (this) {
                    if (!this.qsF) {
                        List list = this.qxI;
                        if (list == null) {
                            list = new LinkedList();
                            this.qxI = list;
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
        if (!this.qsF) {
            synchronized (this) {
                List<k> list = this.qxI;
                if (!this.qsF && list != null) {
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
        if (!this.qsF) {
            synchronized (this) {
                if (!this.qsF) {
                    this.qsF = true;
                    List<k> list = this.qxI;
                    this.qxI = null;
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
            rx.exceptions.a.ho(arrayList);
        }
    }
}
