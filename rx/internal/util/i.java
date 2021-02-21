package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes5.dex */
public final class i implements k {
    private List<k> qDK;
    private volatile boolean qyH;

    public i() {
    }

    public i(k... kVarArr) {
        this.qDK = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.qDK = new LinkedList();
        this.qDK.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.qyH;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.qyH) {
                synchronized (this) {
                    if (!this.qyH) {
                        List list = this.qDK;
                        if (list == null) {
                            list = new LinkedList();
                            this.qDK = list;
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
        if (!this.qyH) {
            synchronized (this) {
                List<k> list = this.qDK;
                if (!this.qyH && list != null) {
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
        if (!this.qyH) {
            synchronized (this) {
                if (!this.qyH) {
                    this.qyH = true;
                    List<k> list = this.qDK;
                    this.qDK = null;
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
            rx.exceptions.a.hk(arrayList);
        }
    }
}
