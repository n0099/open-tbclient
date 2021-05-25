package d.a.l0.a.b2.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.l0.a.b2.a.c;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40809d = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f40810a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f40811b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.d> f40812c = new ConcurrentHashMap();

    public static boolean a(c.d dVar, String str) {
        List<String> list;
        if ((dVar == null || (list = dVar.f40824b) == null || list.isEmpty()) ? false : true) {
            File file = new File(str);
            if (file.exists() && file.lastModified() == dVar.f40825c) {
                return true;
            }
        }
        return false;
    }

    public List<String> b() {
        return c.d();
    }

    public c.d c(String str, String str2, boolean z) {
        c.d dVar = this.f40812c.get(str2);
        if (a(dVar, c.i(str))) {
            d.h("SwanAppWebSafe", "read from cache: serverDomains.data=" + dVar.f40824b);
            return dVar;
        }
        if (dVar != null) {
            dVar.c();
        } else {
            dVar = new c.d();
        }
        c.h(z, str, str2, dVar);
        this.f40812c.put(str2, dVar);
        return dVar;
    }

    public List<String> d(boolean z) {
        if (a(this.f40811b, c.j())) {
            d.h("SwanAppWebSafe", "read from cache: webActions.data=" + this.f40811b.f40824b);
            return this.f40811b.f40824b;
        }
        c.d dVar = this.f40811b;
        if (dVar != null) {
            dVar.c();
        } else {
            this.f40811b = new c.d();
        }
        c.k(z, this.f40811b);
        return this.f40811b.f40824b;
    }

    public List<String> e(@NonNull String str, boolean z) {
        if (a(this.f40810a, c.m(str))) {
            d.h("SwanAppWebSafe", "read from cache: webDomains.data=" + this.f40810a.f40824b);
            return this.f40810a.f40824b;
        }
        c.d dVar = this.f40810a;
        if (dVar != null) {
            dVar.c();
        } else {
            this.f40810a = new c.d();
        }
        c.l(z, str, this.f40810a);
        return this.f40810a.f40824b;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f40809d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        d(true);
        e(str, true);
    }

    public void g() {
        c.d dVar = this.f40810a;
        if (dVar != null) {
            dVar.c();
            this.f40810a = null;
        }
        c.d dVar2 = this.f40811b;
        if (dVar2 != null) {
            dVar2.c();
            this.f40811b = null;
        }
        d.h("SwanAppWebSafe", "release cache done");
    }
}
