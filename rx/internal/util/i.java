package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes12.dex */
public final class i implements k {
    private volatile boolean pPv;
    private List<k> pUA;

    public i() {
    }

    public i(k... kVarArr) {
        this.pUA = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.pUA = new LinkedList();
        this.pUA.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pPv;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pPv) {
                synchronized (this) {
                    if (!this.pPv) {
                        List list = this.pUA;
                        if (list == null) {
                            list = new LinkedList();
                            this.pUA = list;
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
        if (!this.pPv) {
            synchronized (this) {
                List<k> list = this.pUA;
                if (!this.pPv && list != null) {
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
        if (!this.pPv) {
            synchronized (this) {
                if (!this.pPv) {
                    this.pPv = true;
                    List<k> list = this.pUA;
                    this.pUA = null;
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
