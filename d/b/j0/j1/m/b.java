package d.b.j0.j1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.b.i0.c.d> f57773a;

    /* renamed from: d.b.j0.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1380b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f57774a;

        /* renamed from: b  reason: collision with root package name */
        public String f57775b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f57776c;

        public C1380b(String str) {
            this.f57774a = false;
            Uri parse = Uri.parse(str);
            this.f57774a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f57775b = parse.getAuthority() + parse.getPath();
                this.f57776c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f57776c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f57775b = "";
            this.f57776c = new HashMap<>();
        }

        public static C1380b a(String str) {
            return new C1380b(str);
        }

        public String b() {
            return this.f57775b;
        }

        public HashMap<String, String> c() {
            return this.f57776c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f57776c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f57776c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f57774a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f57777a = new b();
    }

    public static b a() {
        return c.f57777a;
    }

    public void b(d.b.i0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.b.i0.c.d dVar) {
        this.f57773a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1380b a2 = C1380b.a(str);
        d.b.i0.c.d dVar = this.f57773a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.b.c.a.e eVar) {
        if (str == null) {
            return;
        }
        C1380b a2 = C1380b.a(str);
        d.b.i0.c.d dVar = this.f57773a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f57773a = new HashMap<>();
    }
}
