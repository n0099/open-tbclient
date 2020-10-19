package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes16.dex */
public final class i implements k {
    private volatile boolean pdb;
    private List<k> pii;

    public i() {
    }

    public i(k... kVarArr) {
        this.pii = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.pii = new LinkedList();
        this.pii.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.pdb;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.pdb) {
                synchronized (this) {
                    if (!this.pdb) {
                        List list = this.pii;
                        if (list == null) {
                            list = new LinkedList();
                            this.pii = list;
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
        if (!this.pdb) {
            synchronized (this) {
                List<k> list = this.pii;
                if (!this.pdb && list != null) {
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
        if (!this.pdb) {
            synchronized (this) {
                if (!this.pdb) {
                    this.pdb = true;
                    List<k> list = this.pii;
                    this.pii = null;
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
            rx.exceptions.a.go(arrayList);
        }
    }
}
