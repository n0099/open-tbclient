package d.a.h0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.a.y0.g.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45264d = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f45265e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f45266a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f45267b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45268c;

    /* renamed from: d.a.h0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0856a implements d.a.h0.a.i2.u0.b<b> {
        public C0856a() {
        }

        public final void a(String str, String str2) {
            if (a.f45264d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f45264d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f45268c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f45266a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0857b c0857b : a.this.f45267b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0857b.f45276b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0857b.f45275a) {
                    String h2 = a.this.f45267b.h();
                    a(TextUtils.isEmpty(c0857b.f45277c) ? h2 : c0857b.f45277c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f45267b = bVar;
        this.f45268c = str;
    }

    public static a d(String str) {
        a aVar = f45265e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f45265e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.a.h0.a.i2.u0.b<b> c() {
        return new C0856a();
    }

    public b.C0857b e() {
        return this.f45267b.d();
    }

    public b.C0857b f(String str) {
        return this.f45267b.e(str);
    }

    public b.C0857b g(String str, String str2) {
        return this.f45267b.f(str, str2);
    }

    public synchronized a h() {
        this.f45267b.j();
        return this;
    }
}
