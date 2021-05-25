package d.a.n0.k1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.m0.c.d> f56625a;

    /* renamed from: d.a.n0.k1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1409b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f56626a;

        /* renamed from: b  reason: collision with root package name */
        public String f56627b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f56628c;

        public C1409b(String str) {
            this.f56626a = false;
            Uri parse = Uri.parse(str);
            this.f56626a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f56627b = parse.getAuthority() + parse.getPath();
                this.f56628c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f56628c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f56627b = "";
            this.f56628c = new HashMap<>();
        }

        public static C1409b a(String str) {
            return new C1409b(str);
        }

        public String b() {
            return this.f56627b;
        }

        public HashMap<String, String> c() {
            return this.f56628c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f56628c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f56628c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f56626a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f56629a = new b();
    }

    public static b a() {
        return c.f56629a;
    }

    public void b(d.a.m0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.a.m0.c.d dVar) {
        this.f56625a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1409b a2 = C1409b.a(str);
        d.a.m0.c.d dVar = this.f56625a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.a.c.a.e eVar) {
        if (str == null) {
            return;
        }
        C1409b a2 = C1409b.a(str);
        d.a.m0.c.d dVar = this.f56625a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f56625a = new HashMap<>();
    }
}
