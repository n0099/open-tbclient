package d.b.g0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.y0.g.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47107d = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f47108e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f47109a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f47110b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47111c;

    /* renamed from: d.b.g0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0884a implements d.b.g0.a.i2.u0.b<b> {
        public C0884a() {
        }

        public final void a(String str, String str2) {
            if (a.f47107d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f47107d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f47111c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f47109a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0885b c0885b : a.this.f47110b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0885b.f47119b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0885b.f47118a) {
                    String h2 = a.this.f47110b.h();
                    a(TextUtils.isEmpty(c0885b.f47120c) ? h2 : c0885b.f47120c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f47110b = bVar;
        this.f47111c = str;
    }

    public static a d(String str) {
        a aVar = f47108e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f47108e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.b.g0.a.i2.u0.b<b> c() {
        return new C0884a();
    }

    public b.C0885b e() {
        return this.f47110b.d();
    }

    public b.C0885b f(String str) {
        return this.f47110b.e(str);
    }

    public b.C0885b g(String str, String str2) {
        return this.f47110b.f(str, str2);
    }

    public synchronized a h() {
        this.f47110b.j();
        return this;
    }
}
