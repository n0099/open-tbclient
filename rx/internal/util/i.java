package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes14.dex */
public final class i implements k {
    private volatile boolean qod;
    private List<k> qtg;

    public i() {
    }

    public i(k... kVarArr) {
        this.qtg = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qtg = new LinkedList();
        this.qtg.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qod;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qod) {
                synchronized (this) {
                    if (!this.qod) {
                        List list = this.qtg;
                        if (list == null) {
                            list = new LinkedList();
                            this.qtg = list;
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
        if (!this.qod) {
            synchronized (this) {
                List<k> list = this.qtg;
                if (!this.qod && list != null) {
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
        if (!this.qod) {
            synchronized (this) {
                if (!this.qod) {
                    this.qod = true;
                    List<k> list = this.qtg;
                    this.qtg = null;
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
