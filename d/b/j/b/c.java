package d.b.j.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import d.b.j.b.a;
import d.b.j.g.a;
import d.b.j.l;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.j.b.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1727a f63656f;

    /* renamed from: g  reason: collision with root package name */
    public b f63657g;

    /* loaded from: classes2.dex */
    public static class a {
        public static boolean a(a.C1727a c1727a, d.b.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1727a != null && !c1727a.f().equals(aVar.a())) {
                    c1727a.f().setExecutable(true, false);
                    c1727a = c1727a.i();
                }
                return true;
            }
            while (c1727a != null) {
                if (!b(c1727a.f())) {
                    return false;
                }
                c1727a = c1727a.i();
            }
            return b(aVar.a());
        }

        public static boolean b(File file) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    int i = Os.stat(file.getAbsolutePath()).st_mode;
                    if ((i & 1) == 0) {
                        Os.chmod(file.getAbsolutePath(), i | 1);
                    }
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public long f63659b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f63660c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63661d;

        /* renamed from: a  reason: collision with root package name */
        public d.b.j.i.b f63658a = new d.b.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f63662e = true;

        public b() {
        }

        public long a() {
            return this.f63659b;
        }

        public void b(long j) {
            if (this.f63659b != j) {
                this.f63659b = j;
                this.f63661d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f63658a.a(j, j2)) {
                this.f63661d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f63660c)) {
                return;
            }
            this.f63660c = aVar;
            this.f63661d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f63656f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f63662e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f63659b = jSONObject.getLong("pub_lst_ts");
                    this.f63660c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f63661d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f63660c;
        }

        public boolean h() {
            return f(c.this.f63656f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f63662e) {
                if (this.f63661d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f63660c.m());
                        jSONObject.put("pub_lst_ts", this.f63659b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f63656f.e("pub.dat", jSONObject.toString(), true);
                        this.f63661d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f63656f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.b.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1725c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f63664d;

        /* renamed from: e  reason: collision with root package name */
        public long f63665e;

        /* renamed from: f  reason: collision with root package name */
        public long f63666f;

        /* renamed from: g  reason: collision with root package name */
        public long f63667g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f63668h;

        public C1725c(c cVar, String str) {
            super(cVar.f63656f, str);
        }

        @Override // d.b.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f63664d = jSONObject.getString("pkg");
            this.f63666f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f63665e = jSONObject.getLong("last_fe_ts");
            this.f63668h = l.c(jSONObject.getString("info"));
            this.f63667g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f63664d);
            jSONObject.put("last_fe_ts", this.f63665e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f63666f);
            jSONObject.put("info", this.f63668h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f63667g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f63665e != j) {
                this.f63665e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f63668h)) {
                return false;
            }
            this.f63668h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f63664d)) {
                return false;
            }
            this.f63664d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f63666f != j) {
                this.f63666f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f63664d;
        }

        public boolean l(long j) {
            if (this.f63667g != j) {
                this.f63667g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f63668h;
        }

        public long n() {
            return this.f63667g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f63657g = new b();
    }

    public static boolean i(File file, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Os.chmod(file.getAbsolutePath(), z ? 436 : 432);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        try {
            if (z) {
                return file.setReadable(true, false);
            }
            return file.setReadable(false, false) && file.setReadable(true, true);
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // d.b.j.b.a
    public a.f a(a.e eVar, l.a aVar) {
        Context context = this.f63643a.f63647a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f63657g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f63657g.i();
                j();
                this.f63657g.i();
                this.f63657g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.b.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C1725c c1725c = null;
        try {
            packageInfo = this.f63643a.f63647a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f63652a) {
            c1725c = new C1725c(this, str);
            c1725c.c();
            if (str.equals(c1725c.k()) && packageInfo.lastUpdateTime == c1725c.n()) {
                g2 = c1725c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f63652a && c1725c != null) {
                c1725c.f(bVar);
                c1725c.g(System.currentTimeMillis());
                c1725c.l(packageInfo.lastUpdateTime);
                c1725c.i(str);
                c1725c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.b.j.b.a
    public void e(a.d dVar) {
        this.f63656f = this.f63644b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f63657g.h();
        this.f63656f.d();
        if (aVar.equals(this.f63657g.g())) {
            return a.f.b();
        }
        this.f63657g.d(aVar);
        this.f63657g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f63657g.c(a.a(this.f63656f, this.f63643a.f63648b) ? 1 : 2, 3L);
    }
}
