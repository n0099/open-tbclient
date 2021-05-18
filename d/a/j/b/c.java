package d.a.j.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import d.a.j.b.a;
import d.a.j.g.a;
import d.a.j.l;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends d.a.j.b.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1087a f48455f;

    /* renamed from: g  reason: collision with root package name */
    public b f48456g;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(a.C1087a c1087a, d.a.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1087a != null && !c1087a.f().equals(aVar.a())) {
                    c1087a.f().setExecutable(true, false);
                    c1087a = c1087a.i();
                }
                return true;
            }
            while (c1087a != null) {
                if (!b(c1087a.f())) {
                    return false;
                }
                c1087a = c1087a.i();
            }
            return b(aVar.a());
        }

        public static boolean b(File file) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    int i2 = Os.stat(file.getAbsolutePath()).st_mode;
                    if ((i2 & 1) == 0) {
                        Os.chmod(file.getAbsolutePath(), i2 | 1);
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
        public long f48458b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f48459c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f48460d;

        /* renamed from: a  reason: collision with root package name */
        public d.a.j.i.b f48457a = new d.a.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f48461e = true;

        public b() {
        }

        public long a() {
            return this.f48458b;
        }

        public void b(long j) {
            if (this.f48458b != j) {
                this.f48458b = j;
                this.f48460d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f48457a.a(j, j2)) {
                this.f48460d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f48459c)) {
                return;
            }
            this.f48459c = aVar;
            this.f48460d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f48455f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f48461e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f48458b = jSONObject.getLong("pub_lst_ts");
                    this.f48459c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f48460d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f48459c;
        }

        public boolean h() {
            return f(c.this.f48455f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f48461e) {
                if (this.f48460d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f48459c.m());
                        jSONObject.put("pub_lst_ts", this.f48458b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f48455f.e("pub.dat", jSONObject.toString(), true);
                        this.f48460d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f48455f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.a.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1085c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f48463d;

        /* renamed from: e  reason: collision with root package name */
        public long f48464e;

        /* renamed from: f  reason: collision with root package name */
        public long f48465f;

        /* renamed from: g  reason: collision with root package name */
        public long f48466g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f48467h;

        public C1085c(c cVar, String str) {
            super(cVar.f48455f, str);
        }

        @Override // d.a.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f48463d = jSONObject.getString("pkg");
            this.f48465f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f48464e = jSONObject.getLong("last_fe_ts");
            this.f48467h = l.c(jSONObject.getString("info"));
            this.f48466g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f48463d);
            jSONObject.put("last_fe_ts", this.f48464e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f48465f);
            jSONObject.put("info", this.f48467h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f48466g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f48464e != j) {
                this.f48464e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f48467h)) {
                return false;
            }
            this.f48467h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f48463d)) {
                return false;
            }
            this.f48463d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f48465f != j) {
                this.f48465f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f48463d;
        }

        public boolean l(long j) {
            if (this.f48466g != j) {
                this.f48466g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f48467h;
        }

        public long n() {
            return this.f48466g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f48456g = new b();
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

    @Override // d.a.j.b.a
    public a.f a(a.e eVar, l.a aVar) {
        Context context = this.f48442a.f48446a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f48456g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f48456g.i();
                j();
                this.f48456g.i();
                this.f48456g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.a.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C1085c c1085c = null;
        try {
            packageInfo = this.f48442a.f48446a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f48451a) {
            c1085c = new C1085c(this, str);
            c1085c.c();
            if (str.equals(c1085c.k()) && packageInfo.lastUpdateTime == c1085c.n()) {
                g2 = c1085c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f48451a && c1085c != null) {
                c1085c.f(bVar);
                c1085c.g(System.currentTimeMillis());
                c1085c.l(packageInfo.lastUpdateTime);
                c1085c.i(str);
                c1085c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.a.j.b.a
    public void e(a.d dVar) {
        this.f48455f = this.f48443b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f48456g.h();
        this.f48455f.d();
        if (aVar.equals(this.f48456g.g())) {
            return a.f.b();
        }
        this.f48456g.d(aVar);
        this.f48456g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f48456g.c(a.a(this.f48455f, this.f48442a.f48447b) ? 1 : 2, 3L);
    }
}
