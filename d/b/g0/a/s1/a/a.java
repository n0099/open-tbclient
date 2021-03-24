package d.b.g0.a.s1.a;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.s1.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45902d = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f45903a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f45904b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.d> f45905c = new HashMap<>();

    public ArrayList<String> a() {
        c.d dVar = new c.d();
        c.e(dVar);
        return dVar.f45917b;
    }

    public c.d b(String str, String str2, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f45905c.get(str2);
        if (dVar != null && (arrayList = dVar.f45917b) != null && arrayList.size() > 0) {
            if (f45902d) {
                Log.e("SwanAppWebSafe", "read serverDomains from cache: data= " + dVar.f45917b);
            }
            return dVar;
        }
        if (dVar != null) {
            dVar.f45917b.clear();
            dVar.f45916a = "";
        } else {
            dVar = new c.d();
        }
        c.f(z, str, str2, dVar);
        this.f45905c.put(str2, dVar);
        return dVar;
    }

    public ArrayList<String> c(boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f45904b;
        if (dVar != null && (arrayList = dVar.f45917b) != null && arrayList.size() > 0) {
            if (f45902d) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.f45904b.f45916a + ", data=" + this.f45904b.f45917b);
            }
            return this.f45904b.f45917b;
        }
        c.d dVar2 = this.f45904b;
        if (dVar2 != null) {
            dVar2.f45916a = "";
            dVar2.f45917b.clear();
        } else {
            this.f45904b = new c.d();
        }
        c.g(z, this.f45904b);
        return this.f45904b.f45917b;
    }

    public ArrayList<String> d(String str, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f45903a;
        if (dVar != null && (arrayList = dVar.f45917b) != null && arrayList.size() > 0) {
            if (f45902d) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.f45903a.f45916a + ", data=" + this.f45903a.f45917b);
            }
            return this.f45903a.f45917b;
        }
        c.d dVar2 = this.f45903a;
        if (dVar2 != null) {
            dVar2.f45916a = "";
            dVar2.f45917b.clear();
        } else {
            this.f45903a = new c.d();
        }
        c.h(z, str, this.f45903a);
        return this.f45903a.f45917b;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f45902d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        c(true);
        d(str, true);
    }

    public void f() {
        c.d dVar = this.f45903a;
        if (dVar != null) {
            dVar.f45917b.clear();
        }
        c.d dVar2 = this.f45904b;
        if (dVar2 != null) {
            dVar2.f45917b.clear();
        }
        this.f45903a = null;
        this.f45904b = null;
        if (f45902d) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
