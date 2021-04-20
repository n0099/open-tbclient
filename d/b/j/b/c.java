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
    public a.C1740a f64357f;

    /* renamed from: g  reason: collision with root package name */
    public b f64358g;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(a.C1740a c1740a, d.b.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1740a != null && !c1740a.f().equals(aVar.a())) {
                    c1740a.f().setExecutable(true, false);
                    c1740a = c1740a.i();
                }
                return true;
            }
            while (c1740a != null) {
                if (!b(c1740a.f())) {
                    return false;
                }
                c1740a = c1740a.i();
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
        public long f64360b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f64361c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64362d;

        /* renamed from: a  reason: collision with root package name */
        public d.b.j.i.b f64359a = new d.b.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f64363e = true;

        public b() {
        }

        public long a() {
            return this.f64360b;
        }

        public void b(long j) {
            if (this.f64360b != j) {
                this.f64360b = j;
                this.f64362d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f64359a.a(j, j2)) {
                this.f64362d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f64361c)) {
                return;
            }
            this.f64361c = aVar;
            this.f64362d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f64357f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f64363e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64360b = jSONObject.getLong("pub_lst_ts");
                    this.f64361c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f64362d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f64361c;
        }

        public boolean h() {
            return f(c.this.f64357f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f64363e) {
                if (this.f64362d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f64361c.m());
                        jSONObject.put("pub_lst_ts", this.f64360b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f64357f.e("pub.dat", jSONObject.toString(), true);
                        this.f64362d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f64357f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.b.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1738c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f64365d;

        /* renamed from: e  reason: collision with root package name */
        public long f64366e;

        /* renamed from: f  reason: collision with root package name */
        public long f64367f;

        /* renamed from: g  reason: collision with root package name */
        public long f64368g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f64369h;

        public C1738c(c cVar, String str) {
            super(cVar.f64357f, str);
        }

        @Override // d.b.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f64365d = jSONObject.getString("pkg");
            this.f64367f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64366e = jSONObject.getLong("last_fe_ts");
            this.f64369h = l.c(jSONObject.getString("info"));
            this.f64368g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64365d);
            jSONObject.put("last_fe_ts", this.f64366e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64367f);
            jSONObject.put("info", this.f64369h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f64368g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f64366e != j) {
                this.f64366e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f64369h)) {
                return false;
            }
            this.f64369h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f64365d)) {
                return false;
            }
            this.f64365d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f64367f != j) {
                this.f64367f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f64365d;
        }

        public boolean l(long j) {
            if (this.f64368g != j) {
                this.f64368g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f64369h;
        }

        public long n() {
            return this.f64368g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f64358g = new b();
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
        Context context = this.f64344a.f64348a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f64358g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f64358g.i();
                j();
                this.f64358g.i();
                this.f64358g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.b.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C1738c c1738c = null;
        try {
            packageInfo = this.f64344a.f64348a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f64353a) {
            c1738c = new C1738c(this, str);
            c1738c.c();
            if (str.equals(c1738c.k()) && packageInfo.lastUpdateTime == c1738c.n()) {
                g2 = c1738c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f64353a && c1738c != null) {
                c1738c.f(bVar);
                c1738c.g(System.currentTimeMillis());
                c1738c.l(packageInfo.lastUpdateTime);
                c1738c.i(str);
                c1738c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.b.j.b.a
    public void e(a.d dVar) {
        this.f64357f = this.f64345b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f64358g.h();
        this.f64357f.d();
        if (aVar.equals(this.f64358g.g())) {
            return a.f.b();
        }
        this.f64358g.d(aVar);
        this.f64358g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f64358g.c(a.a(this.f64357f, this.f64344a.f64349b) ? 1 : 2, 3L);
    }
}
