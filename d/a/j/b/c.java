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
    public a.C0548a f40119f;

    /* renamed from: g  reason: collision with root package name */
    public b f40120g;

    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(a.C0548a c0548a, d.a.j.g.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c0548a != null && !c0548a.f().equals(aVar.a())) {
                    c0548a.f().setExecutable(true, false);
                    c0548a = c0548a.i();
                }
                return true;
            }
            while (c0548a != null) {
                if (!b(c0548a.f())) {
                    return false;
                }
                c0548a = c0548a.i();
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
        public long f40122b;

        /* renamed from: c  reason: collision with root package name */
        public l.a f40123c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40124d;

        /* renamed from: a  reason: collision with root package name */
        public d.a.j.i.b f40121a = new d.a.j.i.b();

        /* renamed from: e  reason: collision with root package name */
        public boolean f40125e = true;

        public b() {
        }

        public long a() {
            return this.f40122b;
        }

        public void b(long j) {
            if (this.f40122b != j) {
                this.f40122b = j;
                this.f40124d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f40121a.a(j, j2)) {
                this.f40124d = true;
            }
        }

        public void d(l.a aVar) {
            if (aVar.equals(this.f40123c)) {
                return;
            }
            this.f40123c = aVar;
            this.f40124d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String c2 = c.this.f40119f.a(new File(packageInfo.applicationInfo.dataDir)).c("pub.dat", true);
            this.f40125e = false;
            return f(c2);
        }

        public final boolean f(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f40122b = jSONObject.getLong("pub_lst_ts");
                    this.f40123c = l.c(jSONObject.getString("pub_info"));
                    jSONObject.getInt("d_form_ver");
                    this.f40124d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public l.a g() {
            return this.f40123c;
        }

        public boolean h() {
            return f(c.this.f40119f.c("pub.dat", true));
        }

        public boolean i() {
            if (this.f40125e) {
                if (this.f40124d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.f40123c.m());
                        jSONObject.put("pub_lst_ts", this.f40122b);
                        jSONObject.put("d_form_ver", 1);
                        c.this.f40119f.e("pub.dat", jSONObject.toString(), true);
                        this.f40124d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return c.i(c.this.f40119f.g("pub.dat"), true);
        }
    }

    /* renamed from: d.a.j.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0546c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f40127d;

        /* renamed from: e  reason: collision with root package name */
        public long f40128e;

        /* renamed from: f  reason: collision with root package name */
        public long f40129f;

        /* renamed from: g  reason: collision with root package name */
        public long f40130g;

        /* renamed from: h  reason: collision with root package name */
        public l.a f40131h;

        public C0546c(c cVar, String str) {
            super(cVar.f40119f, str);
        }

        @Override // d.a.j.b.a.c
        public void a(JSONObject jSONObject) {
            this.f40127d = jSONObject.getString("pkg");
            this.f40129f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f40128e = jSONObject.getLong("last_fe_ts");
            this.f40131h = l.c(jSONObject.getString("info"));
            this.f40130g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.j.b.a.c
        public void d(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f40127d);
            jSONObject.put("last_fe_ts", this.f40128e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f40129f);
            jSONObject.put("info", this.f40131h.m());
            jSONObject.put("tar_pkg_lst_up_ts", this.f40130g);
            jSONObject.put("d_form_ver", 1);
        }

        public void f(b bVar) {
            h(bVar.g());
            j(bVar.a());
        }

        public boolean g(long j) {
            if (this.f40128e != j) {
                this.f40128e = j;
                b(true);
                return true;
            }
            return false;
        }

        public boolean h(l.a aVar) {
            if (aVar.equals(this.f40131h)) {
                return false;
            }
            this.f40131h = aVar;
            b(true);
            return true;
        }

        public boolean i(String str) {
            if (str.equals(this.f40127d)) {
                return false;
            }
            this.f40127d = str;
            b(true);
            return true;
        }

        public boolean j(long j) {
            if (this.f40129f != j) {
                this.f40129f = j;
                b(true);
                return true;
            }
            return false;
        }

        public String k() {
            return this.f40127d;
        }

        public boolean l(long j) {
            if (this.f40130g != j) {
                this.f40130g = j;
                b(true);
                return true;
            }
            return false;
        }

        public l.a m() {
            return this.f40131h;
        }

        public long n() {
            return this.f40130g;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f40120g = new b();
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
        Context context = this.f40106a.f40110a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f40120g.h();
            try {
                return h(eVar, aVar);
            } finally {
                this.f40120g.i();
                j();
                this.f40120g.i();
                this.f40120g.j();
            }
        }
        return a.f.a(-100);
    }

    @Override // d.a.j.b.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        l.a g2;
        C0546c c0546c = null;
        try {
            packageInfo = this.f40106a.f40110a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f40115a) {
            c0546c = new C0546c(this, str);
            c0546c.c();
            if (str.equals(c0546c.k()) && packageInfo.lastUpdateTime == c0546c.n()) {
                g2 = c0546c.m();
                return a.h.b(g2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f40115a && c0546c != null) {
                c0546c.f(bVar);
                c0546c.g(System.currentTimeMillis());
                c0546c.l(packageInfo.lastUpdateTime);
                c0546c.i(str);
                c0546c.e();
            }
            g2 = bVar.g();
            return a.h.b(g2);
        }
        return a.h.a(-2);
    }

    @Override // d.a.j.b.a
    public void e(a.d dVar) {
        this.f40119f = this.f40107b.b("isc");
    }

    public final a.f h(a.e eVar, l.a aVar) {
        this.f40120g.h();
        this.f40119f.d();
        if (aVar.equals(this.f40120g.g())) {
            return a.f.b();
        }
        this.f40120g.d(aVar);
        this.f40120g.b(System.currentTimeMillis());
        return a.f.b();
    }

    public final void j() {
        this.f40120g.c(a.a(this.f40119f, this.f40106a.f40111b) ? 1 : 2, 3L);
    }
}
