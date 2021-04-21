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
    public a.C1154a f52552f;

    /* renamed from: g  reason: collision with root package name */
    public b f52553g;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(a.C1154a c1154a, d.b.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1154a != null && !c1154a.f().equals(aVar.a())) {
                    c1154a.f().setExecutable(true, false);
                    c1154a = c1154a.i();
                }
                return true;
            }
            while (c1154a != null) {
                if (!b(c1154a.f())) {
                    return false;
                }
                c1154a = c1154a.i();
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
        public long f52555b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f52556c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52557d;

        /* renamed from: a  reason: collision with root package name */
        public d.b.j.i.b f52554a = new d.b.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f52558e = true;

        public b() {
        }

        public long a() {
            return this.f52555b;
        }

        public void b(long j) {
            if (this.f52555b != j) {
                this.f52555b = j;
                this.f52557d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f52554a.a(j, j2)) {
                this.f52557d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f52556c)) {
                return;
            }
            this.f52556c = aVar;
            this.f52557d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f52552f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f52558e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f52555b = jSONObject.getLong("pub_lst_ts");
                    this.f52556c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f52557d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f52556c;
        }

        public boolean h() {
            return f(c.this.f52552f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f52558e) {
                if (this.f52557d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f52556c.m());
                        jSONObject.put("pub_lst_ts", this.f52555b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f52552f.e("pub.dat", jSONObject.toString(), true);
                        this.f52557d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f52552f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.b.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1152c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f52560d;

        /* renamed from: e  reason: collision with root package name */
        public long f52561e;

        /* renamed from: f  reason: collision with root package name */
        public long f52562f;

        /* renamed from: g  reason: collision with root package name */
        public long f52563g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f52564h;

        public C1152c(c cVar, String str) {
            super(cVar.f52552f, str);
        }

        @Override // d.b.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f52560d = jSONObject.getString("pkg");
            this.f52562f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f52561e = jSONObject.getLong("last_fe_ts");
            this.f52564h = l.c(jSONObject.getString("info"));
            this.f52563g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f52560d);
            jSONObject.put("last_fe_ts", this.f52561e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f52562f);
            jSONObject.put("info", this.f52564h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f52563g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f52561e != j) {
                this.f52561e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f52564h)) {
                return false;
            }
            this.f52564h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f52560d)) {
                return false;
            }
            this.f52560d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f52562f != j) {
                this.f52562f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f52560d;
        }

        public boolean l(long j) {
            if (this.f52563g != j) {
                this.f52563g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f52564h;
        }

        public long n() {
            return this.f52563g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f52553g = new b();
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
        Context context = this.f52539a.f52543a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f52553g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f52553g.i();
                j();
                this.f52553g.i();
                this.f52553g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.b.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C1152c c1152c = null;
        try {
            packageInfo = this.f52539a.f52543a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f52548a) {
            c1152c = new C1152c(this, str);
            c1152c.c();
            if (str.equals(c1152c.k()) && packageInfo.lastUpdateTime == c1152c.n()) {
                g2 = c1152c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f52548a && c1152c != null) {
                c1152c.f(bVar);
                c1152c.g(System.currentTimeMillis());
                c1152c.l(packageInfo.lastUpdateTime);
                c1152c.i(str);
                c1152c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.b.j.b.a
    public void e(a.d dVar) {
        this.f52552f = this.f52540b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f52553g.h();
        this.f52552f.d();
        if (aVar.equals(this.f52553g.g())) {
            return a.f.b();
        }
        this.f52553g.d(aVar);
        this.f52553g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f52553g.c(a.a(this.f52552f, this.f52539a.f52544b) ? 1 : 2, 3L);
    }
}
