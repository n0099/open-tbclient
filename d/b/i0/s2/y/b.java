package d.b.i0.s2.y;

import android.net.Uri;
import android.text.TextUtils;
import d.b.c.a.e;
import d.b.h0.c.d;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d> f61756a;

    /* renamed from: d.b.i0.s2.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1585b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f61757a;

        /* renamed from: b  reason: collision with root package name */
        public String f61758b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f61759c;

        public C1585b(String str) {
            this.f61757a = false;
            Uri parse = Uri.parse(str);
            boolean z = !TextUtils.isEmpty(parse.getScheme());
            this.f61757a = z;
            if (z) {
                this.f61758b = parse.getAuthority() + parse.getPath();
                this.f61759c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f61759c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f61758b = "";
            this.f61759c = new HashMap<>();
        }

        public static C1585b a(String str) {
            return new C1585b(str);
        }

        public String b() {
            return this.f61758b;
        }

        public HashMap<String, String> c() {
            return this.f61759c;
        }

        public boolean d() {
            return this.f61757a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f61760a = new b();
    }

    public static b a() {
        return c.f61760a;
    }

    public void b(d.b.h0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d dVar) {
        this.f61756a.put(str, dVar);
    }

    public void d(Object obj, String str, HashMap<String, String> hashMap, e eVar) {
        if (str == null) {
            return;
        }
        C1585b a2 = C1585b.a(str);
        d dVar = this.f61756a.get(a2.b());
        if (dVar == null || !a2.d()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f61756a = new HashMap<>();
    }
}
