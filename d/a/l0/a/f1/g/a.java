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
    public static final boolean f45529d = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f45530e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f45531a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f45532b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45533c;

    /* renamed from: d.a.l0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0690a implements d.a.l0.a.v2.e1.b<b> {
        public C0690a() {
        }

        public final void a(String str, String str2) {
            if (a.f45529d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f45529d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f45533c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f45531a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0691b c0691b : a.this.f45532b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0691b.f45541b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0691b.f45540a) {
                    String h2 = a.this.f45532b.h();
                    a(TextUtils.isEmpty(c0691b.f45542c) ? h2 : c0691b.f45542c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f45532b = bVar;
        this.f45533c = str;
    }

    public static a d(String str) {
        a aVar = f45530e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f45530e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.a.l0.a.v2.e1.b<b> c() {
        return new C0690a();
    }

    public b.C0691b e() {
        return this.f45532b.d();
    }

    public b.C0691b f(String str) {
        return this.f45532b.e(str);
    }

    public b.C0691b g(String str, String str2) {
        return this.f45532b.f(str, str2);
    }

    public synchronized a h() {
        this.f45532b.j();
        return this;
    }
}
