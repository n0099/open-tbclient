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
    public static final boolean f47108d = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f47109e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f47110a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f47111b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47112c;

    /* renamed from: d.b.g0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0885a implements d.b.g0.a.i2.u0.b<b> {
        public C0885a() {
        }

        public final void a(String str, String str2) {
            if (a.f47108d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f47108d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f47112c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f47110a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0886b c0886b : a.this.f47111b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0886b.f47120b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0886b.f47119a) {
                    String h2 = a.this.f47111b.h();
                    a(TextUtils.isEmpty(c0886b.f47121c) ? h2 : c0886b.f47121c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f47111b = bVar;
        this.f47112c = str;
    }

    public static a d(String str) {
        a aVar = f47109e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f47109e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.b.g0.a.i2.u0.b<b> c() {
        return new C0885a();
    }

    public b.C0886b e() {
        return this.f47111b.d();
    }

    public b.C0886b f(String str) {
        return this.f47111b.e(str);
    }

    public b.C0886b g(String str, String str2) {
        return this.f47111b.f(str, str2);
    }

    public synchronized a h() {
        this.f47111b.j();
        return this;
    }
}
