package d.a.h0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42137d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public List<d> f42138a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f42139b;

    /* renamed from: c  reason: collision with root package name */
    public final int f42140c;

    public b(int i2) {
        if (i2 >= 1) {
            this.f42140c = i2;
            this.f42139b = new Object();
            this.f42138a = new LinkedList();
            return;
        }
        throw new RuntimeException("MasterPool size can not less than 1");
    }

    public void a(Collection<d> collection) {
        boolean z = collection == null || collection.size() <= 0;
        if (f42137d) {
            StringBuilder sb = new StringBuilder();
            sb.append("master pool clear, excludes size - ");
            sb.append(collection != null ? collection.size() : 0);
            Log.i("MasterPool", sb.toString());
            if (collection != null) {
                for (d dVar : collection) {
                    if (dVar.j() != null) {
                        Log.i("MasterPool", "excludes  - " + dVar.j().c());
                    }
                }
            }
        }
        synchronized (this.f42139b) {
            ArrayList arrayList = new ArrayList();
            for (d dVar2 : this.f42138a) {
                if (z || !collection.contains(dVar2)) {
                    arrayList.add(dVar2);
                }
            }
            b(arrayList);
        }
    }

    public final void b(Collection<d> collection) {
        if (collection.size() > 0) {
            long currentTimeMillis = f42137d ? System.currentTimeMillis() : 0L;
            this.f42138a.removeAll(collection);
            if (f42137d) {
                Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
            }
            for (d dVar : collection) {
                if (dVar.j() != null) {
                    dVar.j().destroy();
                    if (f42137d) {
                        Log.i("MasterPool", "master destroy, id - " + dVar.j().c() + ", isReady - " + dVar.n() + ", is Default - " + dVar.l());
                    }
                }
            }
            if (f42137d) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public d c(String str) {
        d dVar = null;
        if (TextUtils.isEmpty(str)) {
            if (f42137d) {
                Log.w("MasterPool", "appId can not be empty");
            }
            return null;
        }
        synchronized (this.f42139b) {
            if (TextUtils.equals(str, "_default_id_")) {
                if (f42137d) {
                    Log.i("MasterPool", "get default master manger for id - " + str);
                }
                return d();
            }
            int size = this.f42138a.size() - 1;
            int i2 = size;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                d dVar2 = this.f42138a.get(i2);
                if (TextUtils.equals(dVar2.i(), str)) {
                    if (f42137d) {
                        Log.i("MasterPool", "get master in pool for id - " + str);
                    }
                    dVar = dVar2;
                } else {
                    i2--;
                }
            }
            if (dVar != null && i2 != size) {
                this.f42138a.remove(i2);
                this.f42138a.add(dVar);
            }
            if (f42137d) {
                if (dVar == null) {
                    Log.i("MasterPool", "find no master for id - " + str);
                } else {
                    Log.i("MasterPool", "hit a master cache for id - " + str);
                }
            }
            return dVar;
        }
    }

    public final d d() {
        for (d dVar : this.f42138a) {
            if (dVar.l()) {
                return dVar;
            }
        }
        if (f42137d) {
            throw new RuntimeException("there must be one default master in pool, you should add default one first");
        }
        return null;
    }

    public void e(d dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.f42139b) {
            if (!this.f42138a.contains(dVar)) {
                this.f42138a.add(dVar);
            }
            f();
        }
    }

    public final void f() {
        int size = this.f42138a.size();
        if (size <= this.f42140c) {
            return;
        }
        if (f42137d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.f42140c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.f42138a.get(i2);
            if (!dVar.l() || z) {
                arrayList.add(dVar);
                if (arrayList.size() >= size - this.f42140c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
