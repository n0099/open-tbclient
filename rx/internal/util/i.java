package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class i implements k {
    private List<k> kDH;
    private volatile boolean kxY;

    public i() {
    }

    public i(k... kVarArr) {
        this.kDH = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.kDH = new LinkedList();
        this.kDH.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.kxY;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.kxY) {
                synchronized (this) {
                    if (!this.kxY) {
                        List list = this.kDH;
                        if (list == null) {
                            list = new LinkedList();
                            this.kDH = list;
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
        if (!this.kxY) {
            synchronized (this) {
                List<k> list = this.kDH;
                if (!this.kxY && list != null) {
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
        if (!this.kxY) {
            synchronized (this) {
                if (!this.kxY) {
                    this.kxY = true;
                    List<k> list = this.kDH;
                    this.kDH = null;
                    l(list);
                }
            }
        }
    }

    private static void l(Collection<k> collection) {
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
            rx.exceptions.a.fa(arrayList);
        }
    }
}
