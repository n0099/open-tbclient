package d.b.i0.r2.v;

import android.net.Uri;
import android.text.TextUtils;
import d.b.b.a.e;
import d.b.h0.c.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f59862a;

    /* renamed from: d.b.i0.r2.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1508b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59863a;

        /* renamed from: b  reason: collision with root package name */
        public String f59864b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f59865c;

        public C1508b(String str) {
            this.f59863a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f59863a = z;
            if (z) {
                this.f59864b = parse.getAuthority() + parse.getPath();
                this.f59865c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f59865c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f59864b = "";
            this.f59865c = new HashMap<>();
        }

        public static C1508b a(String str) {
            return new C1508b(str);
        }

        public String b() {
            return this.f59864b;
        }

        public HashMap<String, String> c() {
            return this.f59865c;
        }

        public boolean d() {
            return this.f59863a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f59866a = new b();
    }

    public static b a() {
        return c.f59866a;
    }

    public void b(d.b.h0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f59862a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1508b a2 = C1508b.a(str);
        d dVar = this.f59862a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f59862a = new HashMap<>();
    }
}
