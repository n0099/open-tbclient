package d.b.h0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
import d.b.h0.a.y0.g.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47829d = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f47830e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f47831a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f47832b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47833c;

    /* renamed from: d.b.h0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0917a implements d.b.h0.a.i2.u0.b<b> {
        public C0917a() {
        }

        public final void a(String str, String str2) {
            if (a.f47829d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f47829d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f47833c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f47831a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0918b c0918b : a.this.f47832b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0918b.f47841b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0918b.f47840a) {
                    String h2 = a.this.f47832b.h();
                    a(TextUtils.isEmpty(c0918b.f47842c) ? h2 : c0918b.f47842c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f47832b = bVar;
        this.f47833c = str;
    }

    public static a d(String str) {
        a aVar = f47830e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f47830e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.b.h0.a.i2.u0.b<b> c() {
        return new C0917a();
    }

    public b.C0918b e() {
        return this.f47832b.d();
    }

    public b.C0918b f(String str) {
        return this.f47832b.e(str);
    }

    public b.C0918b g(String str, String str2) {
        return this.f47832b.f(str, str2);
    }

    public synchronized a h() {
        this.f47832b.j();
        return this;
    }
}
