package d.a.i0.a.b2.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.i0.a.b2.a.c;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40635d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public c.d f40636a;

    /* renamed from: b  reason: collision with root package name */
    public c.d f40637b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, c.d> f40638c = new ConcurrentHashMap();

    public static boolean a(c.d dVar, String str) {
        List<String> list;
        if ((dVar == null || (list = dVar.f40650b) == null || list.isEmpty()) ? false : true) {
            File file = new File(str);
            if (file.exists() && file.lastModified() == dVar.f40651c) {
                return true;
            }
        }
        return false;
    }

    public List<String> b() {
        return c.d();
    }

    public c.d c(String str, String str2, boolean z) {
        c.d dVar = this.f40638c.get(str2);
        if (a(dVar, c.i(str))) {
            d.h("SwanAppWebSafe", "read from cache: serverDomains.data=" + dVar.f40650b);
            return dVar;
        }
        if (dVar != null) {
            dVar.c();
        } else {
            dVar = new c.d();
        }
        c.h(z, str, str2, dVar);
        this.f40638c.put(str2, dVar);
        return dVar;
    }

    public List<String> d(boolean z) {
        if (a(this.f40637b, c.j())) {
            d.h("SwanAppWebSafe", "read from cache: webActions.data=" + this.f40637b.f40650b);
            return this.f40637b.f40650b;
        }
        c.d dVar = this.f40637b;
        if (dVar != null) {
            dVar.c();
        } else {
            this.f40637b = new c.d();
        }
        c.k(z, this.f40637b);
        return this.f40637b.f40650b;
    }

    public List<String> e(@NonNull String str, boolean z) {
        if (a(this.f40636a, c.m(str))) {
            d.h("SwanAppWebSafe", "read from cache: webDomains.data=" + this.f40636a.f40650b);
            return this.f40636a.f40650b;
        }
        c.d dVar = this.f40636a;
        if (dVar != null) {
            dVar.c();
        } else {
            this.f40636a = new c.d();
        }
        c.l(z, str, this.f40636a);
        return this.f40636a.f40650b;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f40635d) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        d(true);
        e(str, true);
    }

    public void g() {
        c.d dVar = this.f40636a;
        if (dVar != null) {
            dVar.c();
            this.f40636a = null;
        }
        c.d dVar2 = this.f40637b;
        if (dVar2 != null) {
            dVar2.c();
            this.f40637b = null;
        }
        d.h("SwanAppWebSafe", "release cache done");
    }
}
