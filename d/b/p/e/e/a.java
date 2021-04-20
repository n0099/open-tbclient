package d.b.p.e.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import d.b.p.e.a;
import d.b.p.g.c.a.e;
import d.b.p.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.p.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1765a f65036f;

    /* renamed from: g  reason: collision with root package name */
    public b f65037g;

    /* renamed from: d.b.p.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1762a {
        public static boolean a(a.C1765a c1765a, d.b.p.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1765a != null && !c1765a.b().equals(aVar.b())) {
                    c1765a.b().setExecutable(true, false);
                    c1765a = c1765a.e();
                }
                return true;
            }
            while (c1765a != null) {
                if (!b(c1765a.b())) {
                    return false;
                }
                c1765a = c1765a.e();
            }
            return b(aVar.b());
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
        public long f65039b;

        /* renamed from: c  reason: collision with root package name */
        public String f65040c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65041d;

        /* renamed from: a  reason: collision with root package name */
        public e f65038a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f65042e = true;

        public b() {
        }

        public long a() {
            return this.f65039b;
        }

        public void b(long j) {
            if (this.f65039b != j) {
                this.f65039b = j;
                this.f65041d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f65038a.c(j, j2)) {
                this.f65041d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f65040c)) {
                return;
            }
            this.f65040c = str;
            this.f65041d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f65036f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f65042e = false;
            return g(g2);
        }

        public String f() {
            return this.f65040c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f65039b = jSONObject.getLong("pub_lst_ts");
                    this.f65040c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f65041d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f65036f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f65042e) {
                if (this.f65041d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f65040c);
                        jSONObject.put("pub_lst_ts", this.f65039b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f65036f.i("pub.dat", jSONObject.toString(), true);
                        this.f65041d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f65036f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f65044d;

        /* renamed from: e  reason: collision with root package name */
        public long f65045e;

        /* renamed from: f  reason: collision with root package name */
        public long f65046f;

        /* renamed from: g  reason: collision with root package name */
        public long f65047g;

        /* renamed from: h  reason: collision with root package name */
        public String f65048h;

        public c(a aVar, String str) {
            super(aVar.f65036f, str);
        }

        @Override // d.b.p.e.a.c
        public void c(JSONObject jSONObject) {
            this.f65044d = jSONObject.getString("pkg");
            this.f65046f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f65045e = jSONObject.getLong("last_fe_ts");
            this.f65048h = jSONObject.getString("id");
            this.f65047g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.p.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f65044d);
            jSONObject.put("last_fe_ts", this.f65045e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f65046f);
            jSONObject.put("id", this.f65048h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f65047g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f65044d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f65045e != j) {
                this.f65045e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f65044d)) {
                return false;
            }
            this.f65044d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f65048h;
        }

        public boolean k(long j) {
            if (this.f65046f != j) {
                this.f65046f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f65048h)) {
                return false;
            }
            this.f65048h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f65047g;
        }

        public boolean n(long j) {
            if (this.f65047g != j) {
                this.f65047g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f65037g = new b();
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

    @Override // d.b.p.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        String f2;
        c cVar = null;
        try {
            packageInfo = this.f64997a.f65001a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f65007a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f65007a && cVar != null) {
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

    @Override // d.b.p.e.a
    public void e(a.d dVar) {
        this.f65036f = this.f64998b.f("isc");
    }

    @Override // d.b.p.e.a
    public a.f f(a.e eVar) {
        Context context = this.f64997a.f65001a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f65037g.h();
            try {
                return h(eVar);
            } finally {
                this.f65037g.i();
                i();
                this.f65037g.i();
                this.f65037g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f65037g.h();
        this.f65036f.a();
        String c2 = this.f64997a.f65003c.a("aid").c();
        if (c2.equals(this.f65037g.f())) {
            return a.f.d();
        }
        this.f65037g.d(c2);
        this.f65037g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f65037g.c(C1762a.a(this.f65036f, this.f64997a.f65002b) ? 1 : 2, 3L);
    }
}
