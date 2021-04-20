package d.b.g0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.y0.g.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47500d = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f47501e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f47502a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f47503b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47504c;

    /* renamed from: d.b.g0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0897a implements d.b.g0.a.i2.u0.b<b> {
        public C0897a() {
        }

        public final void a(String str, String str2) {
            if (a.f47500d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f47500d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f47504c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f47502a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0898b c0898b : a.this.f47503b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0898b.f47512b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0898b.f47511a) {
                    String h2 = a.this.f47503b.h();
                    a(TextUtils.isEmpty(c0898b.f47513c) ? h2 : c0898b.f47513c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f47503b = bVar;
        this.f47504c = str;
    }

    public static a d(String str) {
        a aVar = f47501e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f47501e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.b.g0.a.i2.u0.b<b> c() {
        return new C0897a();
    }

    public b.C0898b e() {
        return this.f47503b.d();
    }

    public b.C0898b f(String str) {
        return this.f47503b.e(str);
    }

    public b.C0898b g(String str, String str2) {
        return this.f47503b.f(str, str2);
    }

    public synchronized a h() {
        this.f47503b.j();
        return this;
    }
}
