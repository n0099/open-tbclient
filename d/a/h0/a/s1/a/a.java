package d.a.h0.a.s1.a;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.a.s1.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43995d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f43996a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f43997b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.d> f43998c = new HashMap<>();

    public ArrayList<String> a() {
        c.d dVar = new c.d();
        c.e(dVar);
        return dVar.f44010b;
    }

    public c.d b(String str, String str2, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f43998c.get(str2);
        if (dVar != null && (arrayList = dVar.f44010b) != null && arrayList.size() > 0) {
            if (f43995d) {
                Log.e("SwanAppWebSafe", "read serverDomains from cache: data= " + dVar.f44010b);
            }
            return dVar;
        }
        if (dVar != null) {
            dVar.f44010b.clear();
            dVar.f44009a = "";
        } else {
            dVar = new c.d();
        }
        c.f(z, str, str2, dVar);
        this.f43998c.put(str2, dVar);
        return dVar;
    }

    public ArrayList<String> c(boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f43997b;
        if (dVar != null && (arrayList = dVar.f44010b) != null && arrayList.size() > 0) {
            if (f43995d) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.f43997b.f44009a + ", data=" + this.f43997b.f44010b);
            }
            return this.f43997b.f44010b;
        }
        c.d dVar2 = this.f43997b;
        if (dVar2 != null) {
            dVar2.f44009a = "";
            dVar2.f44010b.clear();
        } else {
            this.f43997b = new c.d();
        }
        c.g(z, this.f43997b);
        return this.f43997b.f44010b;
    }

    public ArrayList<String> d(String str, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f43996a;
        if (dVar != null && (arrayList = dVar.f44010b) != null && arrayList.size() > 0) {
            if (f43995d) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.f43996a.f44009a + ", data=" + this.f43996a.f44010b);
            }
            return this.f43996a.f44010b;
        }
        c.d dVar2 = this.f43996a;
        if (dVar2 != null) {
            dVar2.f44009a = "";
            dVar2.f44010b.clear();
        } else {
            this.f43996a = new c.d();
        }
        c.h(z, str, this.f43996a);
        return this.f43996a.f44010b;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f43995d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        c(true);
        d(str, true);
    }

    public void f() {
        c.d dVar = this.f43996a;
        if (dVar != null) {
            dVar.f44010b.clear();
        }
        c.d dVar2 = this.f43997b;
        if (dVar2 != null) {
            dVar2.f44010b.clear();
        }
        this.f43996a = null;
        this.f43997b = null;
        if (f43995d) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
