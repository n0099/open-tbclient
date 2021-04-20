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
    public static final boolean f46295d = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f46296a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f46297b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.d> f46298c = new HashMap<>();

    public ArrayList<String> a() {
        c.d dVar = new c.d();
        c.e(dVar);
        return dVar.f46310b;
    }

    public c.d b(String str, String str2, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f46298c.get(str2);
        if (dVar != null && (arrayList = dVar.f46310b) != null && arrayList.size() > 0) {
            if (f46295d) {
                Log.e("SwanAppWebSafe", "read serverDomains from cache: data= " + dVar.f46310b);
            }
            return dVar;
        }
        if (dVar != null) {
            dVar.f46310b.clear();
            dVar.f46309a = "";
        } else {
            dVar = new c.d();
        }
        c.f(z, str, str2, dVar);
        this.f46298c.put(str2, dVar);
        return dVar;
    }

    public ArrayList<String> c(boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f46297b;
        if (dVar != null && (arrayList = dVar.f46310b) != null && arrayList.size() > 0) {
            if (f46295d) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.f46297b.f46309a + ", data=" + this.f46297b.f46310b);
            }
            return this.f46297b.f46310b;
        }
        c.d dVar2 = this.f46297b;
        if (dVar2 != null) {
            dVar2.f46309a = "";
            dVar2.f46310b.clear();
        } else {
            this.f46297b = new c.d();
        }
        c.g(z, this.f46297b);
        return this.f46297b.f46310b;
    }

    public ArrayList<String> d(String str, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f46296a;
        if (dVar != null && (arrayList = dVar.f46310b) != null && arrayList.size() > 0) {
            if (f46295d) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.f46296a.f46309a + ", data=" + this.f46296a.f46310b);
            }
            return this.f46296a.f46310b;
        }
        c.d dVar2 = this.f46296a;
        if (dVar2 != null) {
            dVar2.f46309a = "";
            dVar2.f46310b.clear();
        } else {
            this.f46296a = new c.d();
        }
        c.h(z, str, this.f46296a);
        return this.f46296a.f46310b;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46295d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        c(true);
        d(str, true);
    }

    public void f() {
        c.d dVar = this.f46296a;
        if (dVar != null) {
            dVar.f46310b.clear();
        }
        c.d dVar2 = this.f46297b;
        if (dVar2 != null) {
            dVar2.f46310b.clear();
        }
        this.f46296a = null;
        this.f46297b = null;
        if (f46295d) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
