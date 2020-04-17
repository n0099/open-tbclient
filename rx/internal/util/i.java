package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean njf;
    private List<k> nok;

    public i() {
    }

    public i(k... kVarArr) {
        this.nok = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.nok = new LinkedList();
        this.nok.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.njf;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.njf) {
                synchronized (this) {
                    if (!this.njf) {
                        List list = this.nok;
                        if (list == null) {
                            list = new LinkedList();
                            this.nok = list;
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
        if (!this.njf) {
            synchronized (this) {
                List<k> list = this.nok;
                if (!this.njf && list != null) {
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
        if (!this.njf) {
            synchronized (this) {
                if (!this.njf) {
                    this.njf = true;
                    List<k> list = this.nok;
                    this.nok = null;
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
            rx.exceptions.a.fo(arrayList);
        }
    }
}
