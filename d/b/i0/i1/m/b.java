package d.b.i0.i1.m;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.b.h0.c.d> f55904a;

    /* renamed from: d.b.i0.i1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1300b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f55905a;

        /* renamed from: b  reason: collision with root package name */
        public String f55906b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f55907c;

        public C1300b(String str) {
            this.f55905a = false;
            Uri parse = Uri.parse(str);
            this.f55905a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f55906b = parse.getAuthority() + parse.getPath();
                this.f55907c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f55907c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f55906b = "";
            this.f55907c = new HashMap<>();
        }

        public static C1300b a(String str) {
            return new C1300b(str);
        }

        public String b() {
            return this.f55906b;
        }

        public HashMap<String, String> c() {
            return this.f55907c;
        }

        public String d(String str) {
            if (!TextUtils.isEmpty(str) && e()) {
                for (String str2 : this.f55907c.keySet()) {
                    if (str.equals(str2)) {
                        return this.f55907c.get(str2);
                    }
                }
            }
            return null;
        }

        public boolean e() {
            return this.f55905a;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f55908a = new b();
    }

    public static b a() {
        return c.f55908a;
    }

    public void b(d.b.h0.c.a aVar) {
        c(aVar.c(), aVar);
    }

    public void c(String str, d.b.h0.c.d dVar) {
        this.f55904a.put(str, dVar);
    }

    public void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        C1300b a2 = C1300b.a(str);
        d.b.h0.c.d dVar = this.f55904a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.b.b.a.e eVar) {
        if (str == null) {
            return;
        }
        C1300b a2 = C1300b.a(str);
        d.b.h0.c.d dVar = this.f55904a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
        this.f55904a = new HashMap<>();
    }
}
