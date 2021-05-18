package d.a.q.e.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import d.a.q.e.a;
import d.a.q.g.c.a.e;
import d.a.q.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.q.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1785a f64254f;

    /* renamed from: g  reason: collision with root package name */
    public b f64255g;

    /* renamed from: d.a.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1782a {
        public static boolean a(a.C1785a c1785a, d.a.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1785a != null && !c1785a.b().equals(aVar.b())) {
                    c1785a.b().setExecutable(true, false);
                    c1785a = c1785a.e();
                }
                return true;
            }
            while (c1785a != null) {
                if (!b(c1785a.b())) {
                    return false;
                }
                c1785a = c1785a.e();
            }
            return b(aVar.b());
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

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public long f64257b;

        /* renamed from: c  reason: collision with root package name */
        public String f64258c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64259d;

        /* renamed from: a  reason: collision with root package name */
        public e f64256a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f64260e = true;

        public b() {
        }

        public long a() {
            return this.f64257b;
        }

        public void b(long j) {
            if (this.f64257b != j) {
                this.f64257b = j;
                this.f64259d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f64256a.c(j, j2)) {
                this.f64259d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f64258c)) {
                return;
            }
            this.f64258c = str;
            this.f64259d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f64254f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f64260e = false;
            return g(g2);
        }

        public String f() {
            return this.f64258c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64257b = jSONObject.getLong("pub_lst_ts");
                    this.f64258c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64259d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f64254f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f64260e) {
                if (this.f64259d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64258c);
                        jSONObject.put("pub_lst_ts", this.f64257b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64254f.i("pub.dat", jSONObject.toString(), true);
                        this.f64259d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f64254f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f64262d;

        /* renamed from: e  reason: collision with root package name */
        public long f64263e;

        /* renamed from: f  reason: collision with root package name */
        public long f64264f;

        /* renamed from: g  reason: collision with root package name */
        public long f64265g;

        /* renamed from: h  reason: collision with root package name */
        public String f64266h;

        public c(a aVar, String str) {
            super(aVar.f64254f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64262d = jSONObject.getString("pkg");
            this.f64264f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64263e = jSONObject.getLong("last_fe_ts");
            this.f64266h = jSONObject.getString("id");
            this.f64265g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64262d);
            jSONObject.put("last_fe_ts", this.f64263e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64264f);
            jSONObject.put("id", this.f64266h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64265g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64262d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f64263e != j) {
                this.f64263e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64262d)) {
                return false;
            }
            this.f64262d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64266h;
        }

        public boolean k(long j) {
            if (this.f64264f != j) {
                this.f64264f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64266h)) {
                return false;
            }
            this.f64266h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64265g;
        }

        public boolean n(long j) {
            if (this.f64265g != j) {
                this.f64265g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f64255g = new b();
    }

    public static boolean k(File file, boolean z) {
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

    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        String f2;
        c cVar = null;
        try {
            packageInfo = this.f64215a.f64219a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f64225a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f64225a && cVar != null) {
                cVar.g(bVar);
                cVar.h(System.currentTimeMillis());
                cVar.n(packageInfo.lastUpdateTime);
                cVar.i(str);
                cVar.b();
            }
            f2 = bVar.f();
            return a.h.e(f2);
        }
        return a.h.a(-2);
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f64254f = this.f64216b.f("isc");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f64215a.f64219a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f64255g.h();
            try {
                return h(eVar);
            } finally {
                this.f64255g.i();
                i();
                this.f64255g.i();
                this.f64255g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f64255g.h();
        this.f64254f.a();
        String c2 = this.f64215a.f64221c.a("aid").c();
        if (c2.equals(this.f64255g.f())) {
            return a.f.d();
        }
        this.f64255g.d(c2);
        this.f64255g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f64255g.c(C1782a.a(this.f64254f, this.f64215a.f64220b) ? 1 : 2, 3L);
    }
}
