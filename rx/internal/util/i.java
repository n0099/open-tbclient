package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean obg;
    private List<k> ogo;

    public i() {
    }

    public i(k... kVarArr) {
        this.ogo = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ogo = new LinkedList();
        this.ogo.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.obg;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.obg) {
                synchronized (this) {
                    if (!this.obg) {
                        List list = this.ogo;
                        if (list == null) {
                            list = new LinkedList();
                            this.ogo = list;
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
        if (!this.obg) {
            synchronized (this) {
                List<k> list = this.ogo;
                if (!this.obg && list != null) {
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
        if (!this.obg) {
            synchronized (this) {
                if (!this.obg) {
                    this.obg = true;
                    List<k> list = this.ogo;
                    this.ogo = null;
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
            rx.exceptions.a.fJ(arrayList);
        }
    }
}
