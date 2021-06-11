package d.a.n0.t2.a0;

import android.net.Uri;
import android.text.TextUtils;
import d.a.c.a.e;
import d.a.m0.c.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f64588a;

    /* renamed from: d.a.n0.t2.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1670b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64589a;

        /* renamed from: b  reason: collision with root package name */
        public String f64590b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f64591c;

        public C1670b(String str) {
            this.f64589a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f64589a = z;
            if (z) {
                this.f64590b = parse.getAuthority() + parse.getPath();
                this.f64591c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f64591c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f64590b = "";
            this.f64591c = new HashMap<>();
        }

        public static C1670b a(String str) {
            return new C1670b(str);
        }

        public String b() {
            return this.f64590b;
        }

        public HashMap<String, String> c() {
            return this.f64591c;
        }

        public boolean d() {
            return this.f64589a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f64592a = new b();
    }

    public static b a() {
        return c.f64592a;
    }

    public void b(d.a.m0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f64588a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1670b a2 = C1670b.a(str);
        d dVar = this.f64588a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f64588a = new HashMap<>();
    }
}
