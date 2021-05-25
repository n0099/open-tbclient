package d.a.n0.t2.a0;

import android.net.Uri;
import android.text.TextUtils;
import d.a.c.a.e;
import d.a.m0.c.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f60896a;

    /* renamed from: d.a.n0.t2.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1614b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f60897a;

        /* renamed from: b  reason: collision with root package name */
        public String f60898b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f60899c;

        public C1614b(String str) {
            this.f60897a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f60897a = z;
            if (z) {
                this.f60898b = parse.getAuthority() + parse.getPath();
                this.f60899c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f60899c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f60898b = "";
            this.f60899c = new HashMap<>();
        }

        public static C1614b a(String str) {
            return new C1614b(str);
        }

        public String b() {
            return this.f60898b;
        }

        public HashMap<String, String> c() {
            return this.f60899c;
        }

        public boolean d() {
            return this.f60897a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f60900a = new b();
    }

    public static b a() {
        return c.f60900a;
    }

    public void b(d.a.m0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f60896a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1614b a2 = C1614b.a(str);
        d dVar = this.f60896a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f60896a = new HashMap<>();
    }
}
