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
    public a.C0604a f43800f;

    /* renamed from: g  reason: collision with root package name */
    public b f43801g;

    /* loaded from: classes2.dex */
    public static class a {
        public static boolean a(a.C0604a c0604a, d.a.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c0604a != null && !c0604a.f().equals(aVar.a())) {
                    c0604a.f().setExecutable(true, false);
                    c0604a = c0604a.i();
                }
                return true;
            }
            while (c0604a != null) {
                if (!b(c0604a.f())) {
                    return false;
                }
                c0604a = c0604a.i();
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
        public long f43803b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f43804c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43805d;

        /* renamed from: a  reason: collision with root package name */
        public d.a.j.i.b f43802a = new d.a.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f43806e = true;

        public b() {
        }

        public long a() {
            return this.f43803b;
        }

        public void b(long j) {
            if (this.f43803b != j) {
                this.f43803b = j;
                this.f43805d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f43802a.a(j, j2)) {
                this.f43805d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f43804c)) {
                return;
            }
            this.f43804c = aVar;
            this.f43805d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f43800f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f43806e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f43803b = jSONObject.getLong("pub_lst_ts");
                    this.f43804c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f43805d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f43804c;
        }

        public boolean h() {
            return f(c.this.f43800f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f43806e) {
                if (this.f43805d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f43804c.m());
                        jSONObject.put("pub_lst_ts", this.f43803b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f43800f.e("pub.dat", jSONObject.toString(), true);
                        this.f43805d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f43800f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.a.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0602c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f43808d;

        /* renamed from: e  reason: collision with root package name */
        public long f43809e;

        /* renamed from: f  reason: collision with root package name */
        public long f43810f;

        /* renamed from: g  reason: collision with root package name */
        public long f43811g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f43812h;

        public C0602c(c cVar, String str) {
            super(cVar.f43800f, str);
        }

        @Override // d.a.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f43808d = jSONObject.getString("pkg");
            this.f43810f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f43809e = jSONObject.getLong("last_fe_ts");
            this.f43812h = l.c(jSONObject.getString("info"));
            this.f43811g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f43808d);
            jSONObject.put("last_fe_ts", this.f43809e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f43810f);
            jSONObject.put("info", this.f43812h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f43811g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f43809e != j) {
                this.f43809e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f43812h)) {
                return false;
            }
            this.f43812h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f43808d)) {
                return false;
            }
            this.f43808d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f43810f != j) {
                this.f43810f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f43808d;
        }

        public boolean l(long j) {
            if (this.f43811g != j) {
                this.f43811g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f43812h;
        }

        public long n() {
            return this.f43811g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f43801g = new b();
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
        Context context = this.f43787a.f43791a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f43801g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f43801g.i();
                j();
                this.f43801g.i();
                this.f43801g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.a.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C0602c c0602c = null;
        try {
            packageInfo = this.f43787a.f43791a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f43796a) {
            c0602c = new C0602c(this, str);
            c0602c.c();
            if (str.equals(c0602c.k()) && packageInfo.lastUpdateTime == c0602c.n()) {
                g2 = c0602c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f43796a && c0602c != null) {
                c0602c.f(bVar);
                c0602c.g(System.currentTimeMillis());
                c0602c.l(packageInfo.lastUpdateTime);
                c0602c.i(str);
                c0602c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.a.j.b.a
    public void e(a.d dVar) {
        this.f43800f = this.f43788b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f43801g.h();
        this.f43800f.d();
        if (aVar.equals(this.f43801g.g())) {
            return a.f.b();
        }
        this.f43801g.d(aVar);
        this.f43801g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f43801g.c(a.a(this.f43800f, this.f43787a.f43792b) ? 1 : 2, 3L);
    }
}
