package d.a.i0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.f1.g.b;
import d.a.i0.a.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f41679d = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f41680e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f41681a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f41682b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41683c;

    /* renamed from: d.a.i0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0623a implements d.a.i0.a.v2.e1.b<b> {
        public C0623a() {
        }

        public final void a(String str, String str2) {
            if (a.f41679d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (a.f41679d) {
                c();
            }
        }

        public final synchronized void c() {
            a("SwanLaunch", "\n\n\n");
            a("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.f41683c);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : a.this.f41681a.entrySet()) {
                sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
            }
            for (b.C0624b c0624b : a.this.f41682b.i()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : c0624b.f41691b) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                for (String str2 : c0624b.f41690a) {
                    String h2 = a.this.f41682b.h();
                    a(TextUtils.isEmpty(c0624b.f41692c) ? h2 : c0624b.f41692c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                }
            }
        }
    }

    public a(String str) {
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f41682b = bVar;
        this.f41683c = str;
    }

    public static a d(String str) {
        a aVar = f41680e.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            f41680e.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final d.a.i0.a.v2.e1.b<b> c() {
        return new C0623a();
    }

    public b.C0624b e() {
        return this.f41682b.d();
    }

    public b.C0624b f(String str) {
        return this.f41682b.e(str);
    }

    public b.C0624b g(String str, String str2) {
        return this.f41682b.f(str, str2);
    }

    public synchronized a h() {
        this.f41682b.j();
        return this;
    }
}
