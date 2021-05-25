package d.a.l0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.f1.g.b;
import d.a.l0.a.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f41853d = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f41854e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f41855a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f41856b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41857c;

    /* renamed from: d.a.l0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0634a implements d.a.l0.a.v2.e1.b<b> {
        public C0634a() {
        }

        public final void a(String str, String str2) {
            if (a.f41853d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f41853d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f41857c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f41855a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0635b c0635b : a.this.f41856b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0635b.f41865b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0635b.f41864a) {
                    String h2 = a.this.f41856b.h();
                    a(TextUtils.isEmpty(c0635b.f41866c) ? h2 : c0635b.f41866c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f41856b = bVar;
        this.f41857c = str;
    }

    public static a d(String str) {
        a aVar = f41854e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f41854e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.a.l0.a.v2.e1.b<b> c() {
        return new C0634a();
    }

    public b.C0635b e() {
        return this.f41856b.d();
    }

    public b.C0635b f(String str) {
        return this.f41856b.e(str);
    }

    public b.C0635b g(String str, String str2) {
        return this.f41856b.f(str, str2);
    }

    public synchronized a h() {
        this.f41856b.j();
        return this;
    }
}
