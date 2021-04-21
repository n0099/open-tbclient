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
    public a.C1784a f65300f;

    /* renamed from: g  reason: collision with root package name */
    public b f65301g;

    /* renamed from: d.b.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1781a {
        public static boolean a(a.C1784a c1784a, d.b.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1784a != null && !c1784a.b().equals(aVar.b())) {
                    c1784a.b().setExecutable(true, false);
                    c1784a = c1784a.e();
                }
                return true;
            }
            while (c1784a != null) {
                if (!b(c1784a.b())) {
                    return false;
                }
                c1784a = c1784a.e();
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
        public long f65303b;

        /* renamed from: c  reason: collision with root package name */
        public String f65304c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65305d;

        /* renamed from: a  reason: collision with root package name */
        public e f65302a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f65306e = true;

        public b() {
        }

        public long a() {
            return this.f65303b;
        }

        public void b(long j) {
            if (this.f65303b != j) {
                this.f65303b = j;
                this.f65305d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f65302a.c(j, j2)) {
                this.f65305d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f65304c)) {
                return;
            }
            this.f65304c = str;
            this.f65305d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f65300f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f65306e = false;
            return g(g2);
        }

        public String f() {
            return this.f65304c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f65303b = jSONObject.getLong("pub_lst_ts");
                    this.f65304c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f65305d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f65300f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f65306e) {
                if (this.f65305d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f65304c);
                        jSONObject.put("pub_lst_ts", this.f65303b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f65300f.i("pub.dat", jSONObject.toString(), true);
                        this.f65305d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f65300f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f65308d;

        /* renamed from: e  reason: collision with root package name */
        public long f65309e;

        /* renamed from: f  reason: collision with root package name */
        public long f65310f;

        /* renamed from: g  reason: collision with root package name */
        public long f65311g;

        /* renamed from: h  reason: collision with root package name */
        public String f65312h;

        public c(a aVar, String str) {
            super(aVar.f65300f, str);
        }

        @Override // d.b.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f65308d = jSONObject.getString("pkg");
            this.f65310f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f65309e = jSONObject.getLong("last_fe_ts");
            this.f65312h = jSONObject.getString("id");
            this.f65311g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f65308d);
            jSONObject.put("last_fe_ts", this.f65309e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f65310f);
            jSONObject.put("id", this.f65312h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f65311g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f65308d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f65309e != j) {
                this.f65309e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f65308d)) {
                return false;
            }
            this.f65308d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f65312h;
        }

        public boolean k(long j) {
            if (this.f65310f != j) {
                this.f65310f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f65312h)) {
                return false;
            }
            this.f65312h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f65311g;
        }

        public boolean n(long j) {
            if (this.f65311g != j) {
                this.f65311g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f65301g = new b();
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
            packageInfo = this.f65261a.f65265a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f65271a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f65271a && cVar != null) {
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
        this.f65300f = this.f65262b.f("isc");
    }

    @Override // d.b.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f65261a.f65265a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f65301g.h();
            try {
                return h(eVar);
            } finally {
                this.f65301g.i();
                i();
                this.f65301g.i();
                this.f65301g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f65301g.h();
        this.f65300f.a();
        String c2 = this.f65261a.f65267c.a("aid").c();
        if (c2.equals(this.f65301g.f())) {
            return a.f.d();
        }
        this.f65301g.d(c2);
        this.f65301g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f65301g.c(C1781a.a(this.f65300f, this.f65261a.f65266b) ? 1 : 2, 3L);
    }
}
