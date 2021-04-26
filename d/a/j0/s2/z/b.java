package d.a.j0.s2.z;

import android.net.Uri;
import android.text.TextUtils;
import d.a.c.a.e;
import d.a.i0.c.d;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f60373a;

    /* renamed from: d.a.j0.s2.z.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1551b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60374a;

        /* renamed from: b  reason: collision with root package name */
        public String f60375b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f60376c;

        public C1551b(String str) {
            this.f60374a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f60374a = z;
            if (z) {
                this.f60375b = parse.getAuthority() + parse.getPath();
                this.f60376c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f60376c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f60375b = "";
            this.f60376c = new HashMap<>();
        }

        public static C1551b a(String str) {
            return new C1551b(str);
        }

        public String b() {
            return this.f60375b;
        }

        public HashMap<String, String> c() {
            return this.f60376c;
        }

        public boolean d() {
            return this.f60374a;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f60377a = new b();
    }

    public static b a() {
        return c.f60377a;
    }

    public void b(d.a.i0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f60373a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1551b a2 = C1551b.a(str);
        d dVar = this.f60373a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f60373a = new HashMap<>();
    }
}
