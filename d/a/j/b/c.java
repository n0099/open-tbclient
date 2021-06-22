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
/* loaded from: classes2.dex */
public class c extends d.a.j.b.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C0607a f43903f;

    /* renamed from: g  reason: collision with root package name */
    public b f43904g;

    /* loaded from: classes2.dex */
    public static class a {
        public static boolean a(a.C0607a c0607a, d.a.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c0607a != null && !c0607a.f().equals(aVar.a())) {
                    c0607a.f().setExecutable(true, false);
                    c0607a = c0607a.i();
                }
                return true;
            }
            while (c0607a != null) {
                if (!b(c0607a.f())) {
                    return false;
                }
                c0607a = c0607a.i();
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

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public long f43906b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f43907c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43908d;

        /* renamed from: a  reason: collision with root package name */
        public d.a.j.i.b f43905a = new d.a.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f43909e = true;

        public b() {
        }

        public long a() {
            return this.f43906b;
        }

        public void b(long j) {
            if (this.f43906b != j) {
                this.f43906b = j;
                this.f43908d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f43905a.a(j, j2)) {
                this.f43908d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f43907c)) {
                return;
            }
            this.f43907c = aVar;
            this.f43908d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f43903f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f43909e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f43906b = jSONObject.getLong("pub_lst_ts");
                    this.f43907c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f43908d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f43907c;
        }

        public boolean h() {
            return f(c.this.f43903f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f43909e) {
                if (this.f43908d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f43907c.m());
                        jSONObject.put("pub_lst_ts", this.f43906b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f43903f.e("pub.dat", jSONObject.toString(), true);
                        this.f43908d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f43903f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.a.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0605c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f43911d;

        /* renamed from: e  reason: collision with root package name */
        public long f43912e;

        /* renamed from: f  reason: collision with root package name */
        public long f43913f;

        /* renamed from: g  reason: collision with root package name */
        public long f43914g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f43915h;

        public C0605c(c cVar, String str) {
            super(cVar.f43903f, str);
        }

        @Override // d.a.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f43911d = jSONObject.getString("pkg");
            this.f43913f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f43912e = jSONObject.getLong("last_fe_ts");
            this.f43915h = l.c(jSONObject.getString("info"));
            this.f43914g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f43911d);
            jSONObject.put("last_fe_ts", this.f43912e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f43913f);
            jSONObject.put("info", this.f43915h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f43914g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f43912e != j) {
                this.f43912e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f43915h)) {
                return false;
            }
            this.f43915h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f43911d)) {
                return false;
            }
            this.f43911d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f43913f != j) {
                this.f43913f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f43911d;
        }

        public boolean l(long j) {
            if (this.f43914g != j) {
                this.f43914g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f43915h;
        }

        public long n() {
            return this.f43914g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f43904g = new b();
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
        Context context = this.f43890a.f43894a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f43904g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f43904g.i();
                j();
                this.f43904g.i();
                this.f43904g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.a.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C0605c c0605c = null;
        try {
            packageInfo = this.f43890a.f43894a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f43899a) {
            c0605c = new C0605c(this, str);
            c0605c.c();
            if (str.equals(c0605c.k()) && packageInfo.lastUpdateTime == c0605c.n()) {
                g2 = c0605c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f43899a && c0605c != null) {
                c0605c.f(bVar);
                c0605c.g(System.currentTimeMillis());
                c0605c.l(packageInfo.lastUpdateTime);
                c0605c.i(str);
                c0605c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.a.j.b.a
    public void e(a.d dVar) {
        this.f43903f = this.f43891b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f43904g.h();
        this.f43903f.d();
        if (aVar.equals(this.f43904g.g())) {
            return a.f.b();
        }
        this.f43904g.d(aVar);
        this.f43904g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f43904g.c(a.a(this.f43903f, this.f43890a.f43895b) ? 1 : 2, 3L);
    }
}
