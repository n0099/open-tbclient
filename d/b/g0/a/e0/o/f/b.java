package d.b.g0.a.e0.o.f;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44116d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public List<d> f44117a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f44118b;

    /* renamed from: c  reason: collision with root package name */
    public final int f44119c;

    public b(int i) {
        if (i >= 1) {
            this.f44119c = i;
            this.f44118b = new Object();
            this.f44117a = new LinkedList();
            return;
        }
        throw new RuntimeException("MasterPool size can not less than 1");
    }

    public void a(Collection<d> collection) {
        boolean z = collection == null || collection.size() <= 0;
        if (f44116d) {
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
        synchronized (this.f44118b) {
            ArrayList arrayList = new ArrayList();
            for (d dVar2 : this.f44117a) {
                if (z || !collection.contains(dVar2)) {
                    arrayList.add(dVar2);
                }
            }
            b(arrayList);
        }
    }

    public final void b(Collection<d> collection) {
        if (collection.size() > 0) {
            long currentTimeMillis = f44116d ? System.currentTimeMillis() : 0L;
            this.f44117a.removeAll(collection);
            if (f44116d) {
                Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
            }
            for (d dVar : collection) {
                if (dVar.j() != null) {
                    dVar.j().destroy();
                    if (f44116d) {
                        Log.i("MasterPool", "master destroy, id - " + dVar.j().c() + ", isReady - " + dVar.n() + ", is Default - " + dVar.l());
                    }
                }
            }
            if (f44116d) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public d c(String str) {
        d dVar = null;
        if (TextUtils.isEmpty(str)) {
            if (f44116d) {
                Log.w("MasterPool", "appId can not be empty");
            }
            return null;
        }
        synchronized (this.f44118b) {
            if (TextUtils.equals(str, "_default_id_")) {
                if (f44116d) {
                    Log.i("MasterPool", "get default master manger for id - " + str);
                }
                return d();
            }
            int size = this.f44117a.size() - 1;
            int i = size;
            while (true) {
                if (i < 0) {
                    break;
                }
                d dVar2 = this.f44117a.get(i);
                if (TextUtils.equals(dVar2.i(), str)) {
                    if (f44116d) {
                        Log.i("MasterPool", "get master in pool for id - " + str);
                    }
                    dVar = dVar2;
                } else {
                    i--;
                }
            }
            if (dVar != null && i != size) {
                this.f44117a.remove(i);
                this.f44117a.add(dVar);
            }
            if (f44116d) {
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
        for (d dVar : this.f44117a) {
            if (dVar.l()) {
                return dVar;
            }
        }
        if (f44116d) {
            throw new RuntimeException("there must be one default master in pool, you should add default one first");
        }
        return null;
    }

    public void e(d dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.f44118b) {
            if (!this.f44117a.contains(dVar)) {
                this.f44117a.add(dVar);
            }
            f();
        }
    }

    public final void f() {
        int size = this.f44117a.size();
        if (size <= this.f44119c) {
            return;
        }
        if (f44116d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.f44119c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            d dVar = this.f44117a.get(i);
            if (!dVar.l() || z) {
                arrayList.add(dVar);
                if (arrayList.size() >= size - this.f44119c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
