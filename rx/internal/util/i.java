package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes16.dex */
public final class i implements k {
    private volatile boolean pUu;
    private List<k> pZz;

    public i() {
    }

    public i(k... kVarArr) {
        this.pZz = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.pZz = new LinkedList();
        this.pZz.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pUu;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pUu) {
                synchronized (this) {
                    if (!this.pUu) {
                        List list = this.pZz;
                        if (list == null) {
                            list = new LinkedList();
                            this.pZz = list;
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
        if (!this.pUu) {
            synchronized (this) {
                List<k> list = this.pZz;
                if (!this.pUu && list != null) {
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
        if (!this.pUu) {
            synchronized (this) {
                if (!this.pUu) {
                    this.pUu = true;
                    List<k> list = this.pZz;
                    this.pZz = null;
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
            rx.exceptions.a.gK(arrayList);
        }
    }
}
