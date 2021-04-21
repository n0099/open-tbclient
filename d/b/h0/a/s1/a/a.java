package d.b.h0.a.s1.a;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
import d.b.h0.a.s1.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46624d = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f46625a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f46626b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.d> f46627c = new HashMap<>();

    public ArrayList<String> a() {
        c.d dVar = new c.d();
        c.e(dVar);
        return dVar.f46639b;
    }

    public c.d b(String str, String str2, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f46627c.get(str2);
        if (dVar != null && (arrayList = dVar.f46639b) != null && arrayList.size() > 0) {
            if (f46624d) {
                Log.e("SwanAppWebSafe", "read serverDomains from cache: data= " + dVar.f46639b);
            }
            return dVar;
        }
        if (dVar != null) {
            dVar.f46639b.clear();
            dVar.f46638a = "";
        } else {
            dVar = new c.d();
        }
        c.f(z, str, str2, dVar);
        this.f46627c.put(str2, dVar);
        return dVar;
    }

    public ArrayList<String> c(boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f46626b;
        if (dVar != null && (arrayList = dVar.f46639b) != null && arrayList.size() > 0) {
            if (f46624d) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.f46626b.f46638a + ", data=" + this.f46626b.f46639b);
            }
            return this.f46626b.f46639b;
        }
        c.d dVar2 = this.f46626b;
        if (dVar2 != null) {
            dVar2.f46638a = "";
            dVar2.f46639b.clear();
        } else {
            this.f46626b = new c.d();
        }
        c.g(z, this.f46626b);
        return this.f46626b.f46639b;
    }

    public ArrayList<String> d(String str, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f46625a;
        if (dVar != null && (arrayList = dVar.f46639b) != null && arrayList.size() > 0) {
            if (f46624d) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.f46625a.f46638a + ", data=" + this.f46625a.f46639b);
            }
            return this.f46625a.f46639b;
        }
        c.d dVar2 = this.f46625a;
        if (dVar2 != null) {
            dVar2.f46638a = "";
            dVar2.f46639b.clear();
        } else {
            this.f46625a = new c.d();
        }
        c.h(z, str, this.f46625a);
        return this.f46625a.f46639b;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46624d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        c(true);
        d(str, true);
    }

    public void f() {
        c.d dVar = this.f46625a;
        if (dVar != null) {
            dVar.f46639b.clear();
        }
        c.d dVar2 = this.f46626b;
        if (dVar2 != null) {
            dVar2.f46639b.clear();
        }
        this.f46625a = null;
        this.f46626b = null;
        if (f46624d) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
