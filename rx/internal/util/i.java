package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean ojS;
    private List<k> ooY;

    public i() {
    }

    public i(k... kVarArr) {
        this.ooY = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ooY = new LinkedList();
        this.ooY.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.ojS;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.ojS) {
                synchronized (this) {
                    if (!this.ojS) {
                        List list = this.ooY;
                        if (list == null) {
                            list = new LinkedList();
                            this.ooY = list;
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
        if (!this.ojS) {
            synchronized (this) {
                List<k> list = this.ooY;
                if (!this.ojS && list != null) {
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
        if (!this.ojS) {
            synchronized (this) {
                if (!this.ojS) {
                    this.ojS = true;
                    List<k> list = this.ooY;
                    this.ooY = null;
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
            rx.exceptions.a.fS(arrayList);
        }
    }
}
