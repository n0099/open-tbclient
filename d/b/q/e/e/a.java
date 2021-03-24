package d.b.q.e.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import d.b.q.e.a;
import d.b.q.g.c.a.e;
import d.b.q.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1752a f64341f;

    /* renamed from: g  reason: collision with root package name */
    public b f64342g;

    /* renamed from: d.b.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1749a {
        public static boolean a(a.C1752a c1752a, d.b.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1752a != null && !c1752a.b().equals(aVar.b())) {
                    c1752a.b().setExecutable(true, false);
                    c1752a = c1752a.e();
                }
                return true;
            }
            while (c1752a != null) {
                if (!b(c1752a.b())) {
                    return false;
                }
                c1752a = c1752a.e();
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
        public long f64344b;

        /* renamed from: c  reason: collision with root package name */
        public String f64345c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64346d;

        /* renamed from: a  reason: collision with root package name */
        public e f64343a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f64347e = true;

        public b() {
        }

        public long a() {
            return this.f64344b;
        }

        public void b(long j) {
            if (this.f64344b != j) {
                this.f64344b = j;
                this.f64346d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f64343a.c(j, j2)) {
                this.f64346d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f64345c)) {
                return;
            }
            this.f64345c = str;
            this.f64346d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f64341f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f64347e = false;
            return g(g2);
        }

        public String f() {
            return this.f64345c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64344b = jSONObject.getLong("pub_lst_ts");
                    this.f64345c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64346d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f64341f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f64347e) {
                if (this.f64346d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64345c);
                        jSONObject.put("pub_lst_ts", this.f64344b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64341f.i("pub.dat", jSONObject.toString(), true);
                        this.f64346d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f64341f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f64349d;

        /* renamed from: e  reason: collision with root package name */
        public long f64350e;

        /* renamed from: f  reason: collision with root package name */
        public long f64351f;

        /* renamed from: g  reason: collision with root package name */
        public long f64352g;

        /* renamed from: h  reason: collision with root package name */
        public String f64353h;

        public c(a aVar, String str) {
            super(aVar.f64341f, str);
        }

        @Override // d.b.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64349d = jSONObject.getString("pkg");
            this.f64351f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64350e = jSONObject.getLong("last_fe_ts");
            this.f64353h = jSONObject.getString("id");
            this.f64352g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64349d);
            jSONObject.put("last_fe_ts", this.f64350e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64351f);
            jSONObject.put("id", this.f64353h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64352g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64349d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f64350e != j) {
                this.f64350e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64349d)) {
                return false;
            }
            this.f64349d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64353h;
        }

        public boolean k(long j) {
            if (this.f64351f != j) {
                this.f64351f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64353h)) {
                return false;
            }
            this.f64353h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64352g;
        }

        public boolean n(long j) {
            if (this.f64352g != j) {
                this.f64352g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f64342g = new b();
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

    @Override // d.b.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        String f2;
        c cVar = null;
        try {
            packageInfo = this.f64302a.f64306a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f64312a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f64312a && cVar != null) {
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

    @Override // d.b.q.e.a
    public void e(a.d dVar) {
        this.f64341f = this.f64303b.f("isc");
    }

    @Override // d.b.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f64302a.f64306a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f64342g.h();
            try {
                return h(eVar);
            } finally {
                this.f64342g.i();
                i();
                this.f64342g.i();
                this.f64342g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f64342g.h();
        this.f64341f.a();
        String c2 = this.f64302a.f64308c.a("aid").c();
        if (c2.equals(this.f64342g.f())) {
            return a.f.d();
        }
        this.f64342g.d(c2);
        this.f64342g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f64342g.c(C1749a.a(this.f64341f, this.f64302a.f64307b) ? 1 : 2, 3L);
    }
}
