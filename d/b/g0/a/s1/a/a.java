package d.b.g0.a.s1.a;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.s1.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45903d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f45904a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f45905b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, c.d> f45906c = new HashMap<>();

    public ArrayList<String> a() {
        c.d dVar = new c.d();
        c.e(dVar);
        return dVar.f45918b;
    }

    public c.d b(String str, String str2, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f45906c.get(str2);
        if (dVar != null && (arrayList = dVar.f45918b) != null && arrayList.size() > 0) {
            if (f45903d) {
                Log.e("SwanAppWebSafe", "read serverDomains from cache: data= " + dVar.f45918b);
            }
            return dVar;
        }
        if (dVar != null) {
            dVar.f45918b.clear();
            dVar.f45917a = "";
        } else {
            dVar = new c.d();
        }
        c.f(z, str, str2, dVar);
        this.f45906c.put(str2, dVar);
        return dVar;
    }

    public ArrayList<String> c(boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f45905b;
        if (dVar != null && (arrayList = dVar.f45918b) != null && arrayList.size() > 0) {
            if (f45903d) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.f45905b.f45917a + ", data=" + this.f45905b.f45918b);
            }
            return this.f45905b.f45918b;
        }
        c.d dVar2 = this.f45905b;
        if (dVar2 != null) {
            dVar2.f45917a = "";
            dVar2.f45918b.clear();
        } else {
            this.f45905b = new c.d();
        }
        c.g(z, this.f45905b);
        return this.f45905b.f45918b;
    }

    public ArrayList<String> d(String str, boolean z) {
        ArrayList<String> arrayList;
        c.d dVar = this.f45904a;
        if (dVar != null && (arrayList = dVar.f45918b) != null && arrayList.size() > 0) {
            if (f45903d) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.f45904a.f45917a + ", data=" + this.f45904a.f45918b);
            }
            return this.f45904a.f45918b;
        }
        c.d dVar2 = this.f45904a;
        if (dVar2 != null) {
            dVar2.f45917a = "";
            dVar2.f45918b.clear();
        } else {
            this.f45904a = new c.d();
        }
        c.h(z, str, this.f45904a);
        return this.f45904a.f45918b;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f45903d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        c(true);
        d(str, true);
    }

    public void f() {
        c.d dVar = this.f45904a;
        if (dVar != null) {
            dVar.f45918b.clear();
        }
        c.d dVar2 = this.f45905b;
        if (dVar2 != null) {
            dVar2.f45918b.clear();
        }
        this.f45904a = null;
        this.f45905b = null;
        if (f45903d) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
