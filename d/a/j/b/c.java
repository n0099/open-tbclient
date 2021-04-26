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
    public a.C1093a f50234f;

    /* renamed from: g  reason: collision with root package name */
    public b f50235g;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(a.C1093a c1093a, d.a.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1093a != null && !c1093a.f().equals(aVar.a())) {
                    c1093a.f().setExecutable(true, false);
                    c1093a = c1093a.i();
                }
                return true;
            }
            while (c1093a != null) {
                if (!b(c1093a.f())) {
                    return false;
                }
                c1093a = c1093a.i();
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
        public long f50237b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f50238c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f50239d;

        /* renamed from: a  reason: collision with root package name */
        public d.a.j.i.b f50236a = new d.a.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f50240e = true;

        public b() {
        }

        public long a() {
            return this.f50237b;
        }

        public void b(long j) {
            if (this.f50237b != j) {
                this.f50237b = j;
                this.f50239d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f50236a.a(j, j2)) {
                this.f50239d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f50238c)) {
                return;
            }
            this.f50238c = aVar;
            this.f50239d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f50234f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f50240e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f50237b = jSONObject.getLong("pub_lst_ts");
                    this.f50238c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f50239d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f50238c;
        }

        public boolean h() {
            return f(c.this.f50234f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f50240e) {
                if (this.f50239d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f50238c.m());
                        jSONObject.put("pub_lst_ts", this.f50237b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f50234f.e("pub.dat", jSONObject.toString(), true);
                        this.f50239d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f50234f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.a.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1091c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f50242d;

        /* renamed from: e  reason: collision with root package name */
        public long f50243e;

        /* renamed from: f  reason: collision with root package name */
        public long f50244f;

        /* renamed from: g  reason: collision with root package name */
        public long f50245g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f50246h;

        public C1091c(c cVar, String str) {
            super(cVar.f50234f, str);
        }

        @Override // d.a.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f50242d = jSONObject.getString("pkg");
            this.f50244f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f50243e = jSONObject.getLong("last_fe_ts");
            this.f50246h = l.c(jSONObject.getString("info"));
            this.f50245g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f50242d);
            jSONObject.put("last_fe_ts", this.f50243e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f50244f);
            jSONObject.put("info", this.f50246h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f50245g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f50243e != j) {
                this.f50243e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f50246h)) {
                return false;
            }
            this.f50246h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f50242d)) {
                return false;
            }
            this.f50242d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f50244f != j) {
                this.f50244f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f50242d;
        }

        public boolean l(long j) {
            if (this.f50245g != j) {
                this.f50245g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f50246h;
        }

        public long n() {
            return this.f50245g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f50235g = new b();
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
        Context context = this.f50221a.f50225a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f50235g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f50235g.i();
                j();
                this.f50235g.i();
                this.f50235g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.a.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C1091c c1091c = null;
        try {
            packageInfo = this.f50221a.f50225a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f50230a) {
            c1091c = new C1091c(this, str);
            c1091c.c();
            if (str.equals(c1091c.k()) && packageInfo.lastUpdateTime == c1091c.n()) {
                g2 = c1091c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f50230a && c1091c != null) {
                c1091c.f(bVar);
                c1091c.g(System.currentTimeMillis());
                c1091c.l(packageInfo.lastUpdateTime);
                c1091c.i(str);
                c1091c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.a.j.b.a
    public void e(a.d dVar) {
        this.f50234f = this.f50222b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f50235g.h();
        this.f50234f.d();
        if (aVar.equals(this.f50235g.g())) {
            return a.f.b();
        }
        this.f50235g.d(aVar);
        this.f50235g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f50235g.c(a.a(this.f50234f, this.f50221a.f50226b) ? 1 : 2, 3L);
    }
}
