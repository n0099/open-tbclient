package d.a.k0.j1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.j0.c.d> f56445a;

    /* renamed from: d.a.k0.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1391b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f56446a;

        /* renamed from: b  reason: collision with root package name */
        public String f56447b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f56448c;

        public C1391b(String str) {
            this.f56446a = false;
            Uri parse = Uri.parse(str);
            this.f56446a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f56447b = parse.getAuthority() + parse.getPath();
                this.f56448c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f56448c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f56447b = "";
            this.f56448c = new HashMap<>();
        }

        public static C1391b a(String str) {
            return new C1391b(str);
        }

        public String b() {
            return this.f56447b;
        }

        public HashMap<String, String> c() {
            return this.f56448c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f56448c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f56448c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f56446a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f56449a = new b();
    }

    public static b a() {
        return c.f56449a;
    }

    public void b(d.a.j0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.a.j0.c.d dVar) {
        this.f56445a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1391b a2 = C1391b.a(str);
        d.a.j0.c.d dVar = this.f56445a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.a.c.a.e eVar) {
        if (str == null) {
            return;
        }
        C1391b a2 = C1391b.a(str);
        d.a.j0.c.d dVar = this.f56445a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f56445a = new HashMap<>();
    }
}
