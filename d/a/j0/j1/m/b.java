package d.a.j0.j1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.i0.c.d> f55738a;

    /* renamed from: d.a.j0.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1319b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f55739a;

        /* renamed from: b  reason: collision with root package name */
        public String f55740b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f55741c;

        public C1319b(String str) {
            this.f55739a = false;
            Uri parse = Uri.parse(str);
            this.f55739a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f55740b = parse.getAuthority() + parse.getPath();
                this.f55741c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f55741c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f55740b = "";
            this.f55741c = new HashMap<>();
        }

        public static C1319b a(String str) {
            return new C1319b(str);
        }

        public String b() {
            return this.f55740b;
        }

        public HashMap<String, String> c() {
            return this.f55741c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f55741c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f55741c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f55739a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f55742a = new b();
    }

    public static b a() {
        return c.f55742a;
    }

    public void b(d.a.i0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.a.i0.c.d dVar) {
        this.f55738a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1319b a2 = C1319b.a(str);
        d.a.i0.c.d dVar = this.f55738a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.a.c.a.e eVar) {
        if (str == null) {
            return;
        }
        C1319b a2 = C1319b.a(str);
        d.a.i0.c.d dVar = this.f55738a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f55738a = new HashMap<>();
    }
}
