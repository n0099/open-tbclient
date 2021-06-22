package d.a.m0.a.b2.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.m0.a.b2.a.c;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44593d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f44594a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f44595b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.d> f44596c = new ConcurrentHashMap();

    public static boolean a(c.d dVar, String str) {
        List<String> list;
        if ((dVar == null || (list = dVar.f44608b) == null || list.isEmpty()) ? false : true) {
            File file = new File(str);
            if (file.exists() && file.lastModified() == dVar.f44609c) {
                return true;
            }
        }
        return false;
    }

    public List<String> b() {
        return c.d();
    }

    public c.d c(String str, String str2, boolean z) {
        c.d dVar = this.f44596c.get(str2);
        if (a(dVar, c.i(str))) {
            d.h("SwanAppWebSafe", "read from cache: serverDomains.data=" + dVar.f44608b);
            return dVar;
        }
        if (dVar != null) {
            dVar.c();
        } else {
            dVar = new c.d();
        }
        c.h(z, str, str2, dVar);
        this.f44596c.put(str2, dVar);
        return dVar;
    }

    public List<String> d(boolean z) {
        if (a(this.f44595b, c.j())) {
            d.h("SwanAppWebSafe", "read from cache: webActions.data=" + this.f44595b.f44608b);
            return this.f44595b.f44608b;
        }
        c.d dVar = this.f44595b;
        if (dVar != null) {
            dVar.c();
        } else {
            this.f44595b = new c.d();
        }
        c.k(z, this.f44595b);
        return this.f44595b.f44608b;
    }

    public List<String> e(@NonNull String str, boolean z) {
        if (a(this.f44594a, c.m(str))) {
            d.h("SwanAppWebSafe", "read from cache: webDomains.data=" + this.f44594a.f44608b);
            return this.f44594a.f44608b;
        }
        c.d dVar = this.f44594a;
        if (dVar != null) {
            dVar.c();
        } else {
            this.f44594a = new c.d();
        }
        c.l(z, str, this.f44594a);
        return this.f44594a.f44608b;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f44593d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        d(true);
        e(str, true);
    }

    public void g() {
        c.d dVar = this.f44594a;
        if (dVar != null) {
            dVar.c();
            this.f44594a = null;
        }
        c.d dVar2 = this.f44595b;
        if (dVar2 != null) {
            dVar2.c();
            this.f44595b = null;
        }
        d.h("SwanAppWebSafe", "release cache done");
    }
}
