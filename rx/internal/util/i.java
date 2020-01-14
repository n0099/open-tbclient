package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes5.dex */
public final class i implements k {
    private volatile boolean nMK;
    private List<k> nRO;

    public i() {
    }

    public i(k... kVarArr) {
        this.nRO = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nRO = new LinkedList();
        this.nRO.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.nMK;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.nMK) {
                synchronized (this) {
                    if (!this.nMK) {
                        List list = this.nRO;
                        if (list == null) {
                            list = new LinkedList();
                            this.nRO = list;
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
        if (!this.nMK) {
            synchronized (this) {
                List<k> list = this.nRO;
                if (!this.nMK && list != null) {
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
        if (!this.nMK) {
            synchronized (this) {
                if (!this.nMK) {
                    this.nMK = true;
                    List<k> list = this.nRO;
                    this.nRO = null;
                    r(list);
                }
            }
        }
    }

    private static void r(Collection<k> collection) {
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
            rx.exceptions.a.fG(arrayList);
        }
    }
}
