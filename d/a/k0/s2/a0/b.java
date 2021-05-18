package d.a.k0.s2.a0;

import android.net.Uri;
import android.text.TextUtils;
import d.a.c.a.e;
import d.a.j0.c.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f60794a;

    /* renamed from: d.a.k0.s2.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1608b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60795a;

        /* renamed from: b  reason: collision with root package name */
        public String f60796b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f60797c;

        public C1608b(String str) {
            this.f60795a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f60795a = z;
            if (z) {
                this.f60796b = parse.getAuthority() + parse.getPath();
                this.f60797c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f60797c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f60796b = "";
            this.f60797c = new HashMap<>();
        }

        public static C1608b a(String str) {
            return new C1608b(str);
        }

        public String b() {
            return this.f60796b;
        }

        public HashMap<String, String> c() {
            return this.f60797c;
        }

        public boolean d() {
            return this.f60795a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f60798a = new b();
    }

    public static b a() {
        return c.f60798a;
    }

    public void b(d.a.j0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f60794a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1608b a2 = C1608b.a(str);
        d dVar = this.f60794a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f60794a = new HashMap<>();
    }
}
