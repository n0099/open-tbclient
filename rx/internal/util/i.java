package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes14.dex */
public final class i implements k {
    private volatile boolean qoe;
    private List<k> qth;

    public i() {
    }

    public i(k... kVarArr) {
        this.qth = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qth = new LinkedList();
        this.qth.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qoe;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qoe) {
                synchronized (this) {
                    if (!this.qoe) {
                        List list = this.qth;
                        if (list == null) {
                            list = new LinkedList();
                            this.qth = list;
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
        if (!this.qoe) {
            synchronized (this) {
                List<k> list = this.qth;
                if (!this.qoe && list != null) {
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
        if (!this.qoe) {
            synchronized (this) {
                if (!this.qoe) {
                    this.qoe = true;
                    List<k> list = this.qth;
                    this.qth = null;
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
