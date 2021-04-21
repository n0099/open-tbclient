package d.b.j0.s2.y;

import android.net.Uri;
import android.text.TextUtils;
import d.b.c.a.e;
import d.b.i0.c.d;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f62177a;

    /* renamed from: d.b.j0.s2.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1608b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f62178a;

        /* renamed from: b  reason: collision with root package name */
        public String f62179b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f62180c;

        public C1608b(String str) {
            this.f62178a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f62178a = z;
            if (z) {
                this.f62179b = parse.getAuthority() + parse.getPath();
                this.f62180c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f62180c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f62179b = "";
            this.f62180c = new HashMap<>();
        }

        public static C1608b a(String str) {
            return new C1608b(str);
        }

        public String b() {
            return this.f62179b;
        }

        public HashMap<String, String> c() {
            return this.f62180c;
        }

        public boolean d() {
            return this.f62178a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f62181a = new b();
    }

    public static b a() {
        return c.f62181a;
    }

    public void b(d.b.i0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f62177a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1608b a2 = C1608b.a(str);
        d dVar = this.f62177a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f62177a = new HashMap<>();
    }
}
