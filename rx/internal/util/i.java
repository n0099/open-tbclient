package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private volatile boolean kng;
    private List<k> ksR;

    public i() {
    }

    public i(k... kVarArr) {
        this.ksR = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ksR = new LinkedList();
        this.ksR.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kng;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kng) {
                synchronized (this) {
                    if (!this.kng) {
                        List list = this.ksR;
                        if (list == null) {
                            list = new LinkedList();
                            this.ksR = list;
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
        if (!this.kng) {
            synchronized (this) {
                List<k> list = this.ksR;
                if (!this.kng && list != null) {
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
        if (!this.kng) {
            synchronized (this) {
                if (!this.kng) {
                    this.kng = true;
                    List<k> list = this.ksR;
                    this.ksR = null;
                    n(list);
                }
            }
        }
    }

    private static void n(Collection<k> collection) {
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
            rx.exceptions.a.eK(arrayList);
        }
    }
}
