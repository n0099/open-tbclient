package d.a.m0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.f1.g.b;
import d.a.m0.a.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45637d = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f45638e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f45639a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f45640b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45641c;

    /* renamed from: d.a.m0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0693a implements d.a.m0.a.v2.e1.b<b> {
        public C0693a() {
        }

        public final void a(String str, String str2) {
            if (a.f45637d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f45637d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f45641c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f45639a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0694b c0694b : a.this.f45640b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0694b.f45649b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0694b.f45648a) {
                    String h2 = a.this.f45640b.h();
                    a(TextUtils.isEmpty(c0694b.f45650c) ? h2 : c0694b.f45650c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f45640b = bVar;
        this.f45641c = str;
    }

    public static a d(String str) {
        a aVar = f45638e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f45638e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.a.m0.a.v2.e1.b<b> c() {
        return new C0693a();
    }

    public b.C0694b e() {
        return this.f45640b.d();
    }

    public b.C0694b f(String str) {
        return this.f45640b.e(str);
    }

    public b.C0694b g(String str, String str2) {
        return this.f45640b.f(str, str2);
    }

    public synchronized a h() {
        this.f45640b.j();
        return this;
    }
}
