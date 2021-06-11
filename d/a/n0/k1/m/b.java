package d.a.n0.k1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.m0.c.d> f60314a;

    /* renamed from: d.a.n0.k1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1465b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60315a;

        /* renamed from: b  reason: collision with root package name */
        public String f60316b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f60317c;

        public C1465b(String str) {
            this.f60315a = false;
            Uri parse = Uri.parse(str);
            this.f60315a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f60316b = parse.getAuthority() + parse.getPath();
                this.f60317c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f60317c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f60316b = "";
            this.f60317c = new HashMap<>();
        }

        public static C1465b a(String str) {
            return new C1465b(str);
        }

        public String b() {
            return this.f60316b;
        }

        public HashMap<String, String> c() {
            return this.f60317c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f60317c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f60317c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f60315a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f60318a = new b();
    }

    public static b a() {
        return c.f60318a;
    }

    public void b(d.a.m0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.a.m0.c.d dVar) {
        this.f60314a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1465b a2 = C1465b.a(str);
        d.a.m0.c.d dVar = this.f60314a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.a.c.a.e eVar) {
        if (str == null) {
            return;
        }
        C1465b a2 = C1465b.a(str);
        d.a.m0.c.d dVar = this.f60314a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f60314a = new HashMap<>();
    }
}
