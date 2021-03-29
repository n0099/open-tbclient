package d.b.i0.r2.v;

import android.net.Uri;
import android.text.TextUtils;
import d.b.b.a.e;
import d.b.h0.c.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f59863a;

    /* renamed from: d.b.i0.r2.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1509b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59864a;

        /* renamed from: b  reason: collision with root package name */
        public String f59865b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f59866c;

        public C1509b(String str) {
            this.f59864a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f59864a = z;
            if (z) {
                this.f59865b = parse.getAuthority() + parse.getPath();
                this.f59866c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f59866c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f59865b = "";
            this.f59866c = new HashMap<>();
        }

        public static C1509b a(String str) {
            return new C1509b(str);
        }

        public String b() {
            return this.f59865b;
        }

        public HashMap<String, String> c() {
            return this.f59866c;
        }

        public boolean d() {
            return this.f59864a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f59867a = new b();
    }

    public static b a() {
        return c.f59867a;
    }

    public void b(d.b.h0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f59863a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1509b a2 = C1509b.a(str);
        d dVar = this.f59863a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f59863a = new HashMap<>();
    }
}
