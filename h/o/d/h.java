package h.o.d;

import h.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public final class h implements k {

    /* renamed from: e  reason: collision with root package name */
    public List<k> f71940e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f71941f;

    public h() {
    }

    public static void c(Collection<k> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (k kVar : collection) {
            try {
                kVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        h.m.a.d(arrayList);
    }

    public void a(k kVar) {
        if (kVar.isUnsubscribed()) {
            return;
        }
        if (!this.f71941f) {
            synchronized (this) {
                if (!this.f71941f) {
                    List list = this.f71940e;
                    if (list == null) {
                        list = new LinkedList();
                        this.f71940e = list;
                    }
                    list.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        if (this.f71941f) {
            return;
        }
        synchronized (this) {
            List<k> list = this.f71940e;
            if (!this.f71941f && list != null) {
                boolean remove = list.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f71941f;
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.f71941f) {
            return;
        }
        synchronized (this) {
            if (this.f71941f) {
                return;
            }
            this.f71941f = true;
            List<k> list = this.f71940e;
            this.f71940e = null;
            c(list);
        }
    }

    public h(k... kVarArr) {
        this.f71940e = new LinkedList(Arrays.asList(kVarArr));
    }

    public h(k kVar) {
        LinkedList linkedList = new LinkedList();
        this.f71940e = linkedList;
        linkedList.add(kVar);
    }
}
