package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.k;
/* loaded from: classes6.dex */
public final class i implements k {
    private volatile boolean obd;
    private List<k> ogl;

    public i() {
    }

    public i(k... kVarArr) {
        this.ogl = new LinkedList(Arrays.asList(kVarArr));
    }

    public i(k kVar) {
        this.ogl = new LinkedList();
        this.ogl.add(kVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.obd;
    }

    public void add(k kVar) {
        if (!kVar.isUnsubscribed()) {
            if (!this.obd) {
                synchronized (this) {
                    if (!this.obd) {
                        List list = this.ogl;
                        if (list == null) {
                            list = new LinkedList();
                            this.ogl = list;
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
        if (!this.obd) {
            synchronized (this) {
                List<k> list = this.ogl;
                if (!this.obd && list != null) {
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
        if (!this.obd) {
            synchronized (this) {
                if (!this.obd) {
                    this.obd = true;
                    List<k> list = this.ogl;
                    this.ogl = null;
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
            rx.exceptions.a.fJ(arrayList);
        }
    }
}
