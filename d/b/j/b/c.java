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
/* loaded from: classes.dex */
public class c extends d.b.j.b.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1728a f63657f;

    /* renamed from: g  reason: collision with root package name */
    public b f63658g;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(a.C1728a c1728a, d.b.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1728a != null && !c1728a.f().equals(aVar.a())) {
                    c1728a.f().setExecutable(true, false);
                    c1728a = c1728a.i();
                }
                return true;
            }
            while (c1728a != null) {
                if (!b(c1728a.f())) {
                    return false;
                }
                c1728a = c1728a.i();
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

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public long f63660b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f63661c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63662d;

        /* renamed from: a  reason: collision with root package name */
        public d.b.j.i.b f63659a = new d.b.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f63663e = true;

        public b() {
        }

        public long a() {
            return this.f63660b;
        }

        public void b(long j) {
            if (this.f63660b != j) {
                this.f63660b = j;
                this.f63662d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f63659a.a(j, j2)) {
                this.f63662d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f63661c)) {
                return;
            }
            this.f63661c = aVar;
            this.f63662d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f63657f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f63663e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f63660b = jSONObject.getLong("pub_lst_ts");
                    this.f63661c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f63662d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f63661c;
        }

        public boolean h() {
            return f(c.this.f63657f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f63663e) {
                if (this.f63662d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f63661c.m());
                        jSONObject.put("pub_lst_ts", this.f63660b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f63657f.e("pub.dat", jSONObject.toString(), true);
                        this.f63662d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f63657f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.b.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1726c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f63665d;

        /* renamed from: e  reason: collision with root package name */
        public long f63666e;

        /* renamed from: f  reason: collision with root package name */
        public long f63667f;

        /* renamed from: g  reason: collision with root package name */
        public long f63668g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f63669h;

        public C1726c(c cVar, String str) {
            super(cVar.f63657f, str);
        }

        @Override // d.b.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f63665d = jSONObject.getString("pkg");
            this.f63667f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f63666e = jSONObject.getLong("last_fe_ts");
            this.f63669h = l.c(jSONObject.getString("info"));
            this.f63668g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f63665d);
            jSONObject.put("last_fe_ts", this.f63666e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f63667f);
            jSONObject.put("info", this.f63669h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f63668g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f63666e != j) {
                this.f63666e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f63669h)) {
                return false;
            }
            this.f63669h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f63665d)) {
                return false;
            }
            this.f63665d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f63667f != j) {
                this.f63667f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f63665d;
        }

        public boolean l(long j) {
            if (this.f63668g != j) {
                this.f63668g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f63669h;
        }

        public long n() {
            return this.f63668g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f63658g = new b();
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
        Context context = this.f63644a.f63648a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f63658g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f63658g.i();
                j();
                this.f63658g.i();
                this.f63658g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.b.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C1726c c1726c = null;
        try {
            packageInfo = this.f63644a.f63648a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f63653a) {
            c1726c = new C1726c(this, str);
            c1726c.c();
            if (str.equals(c1726c.k()) && packageInfo.lastUpdateTime == c1726c.n()) {
                g2 = c1726c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f63653a && c1726c != null) {
                c1726c.f(bVar);
                c1726c.g(System.currentTimeMillis());
                c1726c.l(packageInfo.lastUpdateTime);
                c1726c.i(str);
                c1726c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.b.j.b.a
    public void e(a.d dVar) {
        this.f63657f = this.f63645b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f63658g.h();
        this.f63657f.d();
        if (aVar.equals(this.f63658g.g())) {
            return a.f.b();
        }
        this.f63658g.d(aVar);
        this.f63658g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f63658g.c(a.a(this.f63657f, this.f63644a.f63649b) ? 1 : 2, 3L);
    }
}
