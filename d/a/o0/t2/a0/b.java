package d.a.o0.t2.a0;

import android.net.Uri;
import android.text.TextUtils;
import d.a.c.a.e;
import d.a.n0.c.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f64713a;

    /* renamed from: d.a.o0.t2.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1674b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64714a;

        /* renamed from: b  reason: collision with root package name */
        public String f64715b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f64716c;

        public C1674b(String str) {
            this.f64714a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f64714a = z;
            if (z) {
                this.f64715b = parse.getAuthority() + parse.getPath();
                this.f64716c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f64716c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f64715b = "";
            this.f64716c = new HashMap<>();
        }

        public static C1674b a(String str) {
            return new C1674b(str);
        }

        public String b() {
            return this.f64715b;
        }

        public HashMap<String, String> c() {
            return this.f64716c;
        }

        public boolean d() {
            return this.f64714a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f64717a = new b();
    }

    public static b a() {
        return c.f64717a;
    }

    public void b(d.a.n0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f64713a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1674b a2 = C1674b.a(str);
        d dVar = this.f64713a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f64713a = new HashMap<>();
    }
}
