package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes5.dex */
public final class i implements k {
    private volatile boolean oEg;
    private List<k> oJl;

    public i() {
    }

    public i(k... kVarArr) {
        this.oJl = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.oJl = new LinkedList();
        this.oJl.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.oEg;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.oEg) {
                synchronized (this) {
                    if (!this.oEg) {
                        List list = this.oJl;
                        if (list == null) {
                            list = new LinkedList();
                            this.oJl = list;
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
        if (!this.oEg) {
            synchronized (this) {
                List<k> list = this.oJl;
                if (!this.oEg && list != null) {
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
        if (!this.oEg) {
            synchronized (this) {
                if (!this.oEg) {
                    this.oEg = true;
                    List<k> list = this.oJl;
                    this.oJl = null;
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
            rx.exceptions.a.gc(arrayList);
        }
    }
}
