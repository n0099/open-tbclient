package d.a.m0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46041d = d.a.m0.a.k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f46042a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f46043b;

    /* renamed from: c  reason: collision with root package name */
    public final int f46044c;

    public g(int i2) {
        if (i2 < 1) {
            if (f46041d) {
                throw new RuntimeException("MasterPool size can not less than 1");
            }
            i2 = 1;
        }
        this.f46044c = i2;
        this.f46043b = new Object();
        this.f46042a = new LinkedList();
    }

    public void a(Collection<k> collection) {
        boolean z = collection == null || collection.size() <= 0;
        if (f46041d) {
            StringBuilder sb = new StringBuilder();
            sb.append("master pool clear, excludes size - ");
            sb.append(collection != null ? collection.size() : 0);
            Log.i("MasterPool", sb.toString());
            if (collection != null) {
                for (k kVar : collection) {
                    if (kVar.i() != null) {
                        Log.i("MasterPool", "excludes  - " + kVar.i().b());
                    }
                }
            }
        }
        synchronized (this.f46043b) {
            ArrayList arrayList = new ArrayList();
            for (k kVar2 : this.f46042a) {
                if (z || !collection.contains(kVar2)) {
                    arrayList.add(kVar2);
                }
            }
            b(arrayList);
        }
    }

    public final void b(Collection<k> collection) {
        if (collection.size() > 0) {
            long currentTimeMillis = f46041d ? System.currentTimeMillis() : 0L;
            this.f46042a.removeAll(collection);
            if (f46041d) {
                Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
            }
            for (k kVar : collection) {
                if (kVar.i() != null) {
                    kVar.i().destroy();
                    if (f46041d) {
                        Log.i("MasterPool", "master destroy, id - " + kVar.i().b() + ", isReady - " + kVar.n() + ", is Default - " + kVar.l() + ", is Prefetch - " + kVar.j());
                    }
                }
            }
            if (f46041d) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "_default_id_")) {
            return;
        }
        synchronized (this.f46043b) {
            ArrayList arrayList = new ArrayList();
            for (k kVar : this.f46042a) {
                if (TextUtils.equals(kVar.h(), str)) {
                    arrayList.add(kVar);
                }
            }
            b(arrayList);
        }
    }

    public k d(String str) {
        k kVar = null;
        if (TextUtils.isEmpty(str)) {
            if (f46041d) {
                Log.w("MasterPool", "appId can not be empty");
            }
            return null;
        }
        synchronized (this.f46043b) {
            if (TextUtils.equals(str, "_default_id_")) {
                if (f46041d) {
                    Log.i("MasterPool", "get default master manger for id - " + str);
                }
                return e();
            }
            int size = this.f46042a.size() - 1;
            int i2 = size;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                k kVar2 = this.f46042a.get(i2);
                if (TextUtils.equals(kVar2.h(), str)) {
                    if (f46041d) {
                        Log.i("MasterPool", "get master in pool for id - " + str);
                    }
                    kVar = kVar2;
                } else {
                    i2--;
                }
            }
            if (kVar != null && i2 != size) {
                this.f46042a.remove(i2);
                this.f46042a.add(kVar);
            }
            if (f46041d) {
                if (kVar == null) {
                    Log.i("MasterPool", "find no master for id - " + str);
                } else {
                    Log.i("MasterPool", "hit a master cache for id - " + str);
                }
            }
            return kVar;
        }
    }

    public final k e() {
        for (k kVar : this.f46042a) {
            if (kVar.l()) {
                return kVar;
            }
        }
        if (f46041d) {
            throw new RuntimeException("there must be one default master in pool, you should add default one first");
        }
        return null;
    }

    public void f(k kVar) {
        if (kVar == null) {
            return;
        }
        synchronized (this.f46043b) {
            if (!this.f46042a.contains(kVar)) {
                this.f46042a.add(kVar);
            }
            h();
        }
    }

    public void g(Collection<k> collection) {
        if (this.f46044c >= 3) {
            boolean z = true;
            if (this.f46042a.size() > 1) {
                if (collection != null && collection.size() > 0) {
                    z = false;
                }
                synchronized (this.f46043b) {
                    ArrayList arrayList = new ArrayList();
                    for (k kVar : this.f46042a) {
                        if (!kVar.l() && kVar.j() && (z || !collection.contains(kVar))) {
                            arrayList.add(kVar);
                        }
                    }
                    if (f46041d) {
                        Log.d("MasterPool", "remove all prefetch event master, size - " + arrayList.size());
                    }
                    b(arrayList);
                }
                return;
            }
        }
        if (f46041d) {
            Log.d("MasterPool", "no need to remove prefetch master");
            Log.d("MasterPool", "max size - " + this.f46044c);
            Log.d("MasterPool", "current cache size - " + this.f46042a.size());
        }
    }

    public final void h() {
        int size = this.f46042a.size();
        if (size <= this.f46044c) {
            return;
        }
        if (f46041d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.f46044c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f46042a.get(i2);
            if (!kVar.l() || z) {
                arrayList.add(kVar);
                if (arrayList.size() >= size - this.f46044c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
