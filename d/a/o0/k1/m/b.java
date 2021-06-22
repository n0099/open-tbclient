package d.a.o0.k1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.n0.c.d> f60439a;

    /* renamed from: d.a.o0.k1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1469b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60440a;

        /* renamed from: b  reason: collision with root package name */
        public String f60441b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f60442c;

        public C1469b(String str) {
            this.f60440a = false;
            Uri parse = Uri.parse(str);
            this.f60440a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f60441b = parse.getAuthority() + parse.getPath();
                this.f60442c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f60442c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f60441b = "";
            this.f60442c = new HashMap<>();
        }

        public static C1469b a(String str) {
            return new C1469b(str);
        }

        public String b() {
            return this.f60441b;
        }

        public HashMap<String, String> c() {
            return this.f60442c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f60442c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f60442c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f60440a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f60443a = new b();
    }

    public static b a() {
        return c.f60443a;
    }

    public void b(d.a.n0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.a.n0.c.d dVar) {
        this.f60439a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1469b a2 = C1469b.a(str);
        d.a.n0.c.d dVar = this.f60439a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.a.c.a.e eVar) {
        if (str == null) {
            return;
        }
        C1469b a2 = C1469b.a(str);
        d.a.n0.c.d dVar = this.f60439a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f60439a = new HashMap<>();
    }
}
