package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes2.dex */
public final class j implements k {
    private volatile boolean iBn;
    private List<k> iMi;

    public j() {
    }

    public j(k... kVarArr) {
        this.iMi = new LinkedList(Arrays.asList(kVarArr));
    }

    public j(k kVar) {
        this.iMi = new LinkedList();
        this.iMi.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.iBn;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.iBn) {
                synchronized (this) {
                    if (!this.iBn) {
                        List list = this.iMi;
                        if (list == null) {
                            list = new LinkedList();
                            this.iMi = list;
                        }
                        list.add(kVar);
                        return;
                    }
                }
            }
            kVar.unsubscribe();
        }
    }

    public void b(k kVar) {
        if (!this.iBn) {
            synchronized (this) {
                List<k> list = this.iMi;
                if (!this.iBn && list != null) {
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
        if (!this.iBn) {
            synchronized (this) {
                if (!this.iBn) {
                    this.iBn = true;
                    List<k> list = this.iMi;
                    this.iMi = null;
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
            rx.exceptions.a.ez(arrayList);
        }
    }
}
