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
    public a.C1846a f67848f;

    /* renamed from: g  reason: collision with root package name */
    public b f67849g;

    /* renamed from: d.a.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1843a {
        public static boolean a(a.C1846a c1846a, d.a.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1846a != null && !c1846a.b().equals(aVar.b())) {
                    c1846a.b().setExecutable(true, false);
                    c1846a = c1846a.e();
                }
                return true;
            }
            while (c1846a != null) {
                if (!b(c1846a.b())) {
                    return false;
                }
                c1846a = c1846a.e();
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
        public long f67851b;

        /* renamed from: c  reason: collision with root package name */
        public String f67852c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67853d;

        /* renamed from: a  reason: collision with root package name */
        public e f67850a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f67854e = true;

        public b() {
        }

        public long a() {
            return this.f67851b;
        }

        public void b(long j) {
            if (this.f67851b != j) {
                this.f67851b = j;
                this.f67853d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f67850a.c(j, j2)) {
                this.f67853d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f67852c)) {
                return;
            }
            this.f67852c = str;
            this.f67853d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f67848f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f67854e = false;
            return g(g2);
        }

        public String f() {
            return this.f67852c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f67851b = jSONObject.getLong("pub_lst_ts");
                    this.f67852c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f67853d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f67848f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f67854e) {
                if (this.f67853d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f67852c);
                        jSONObject.put("pub_lst_ts", this.f67851b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f67848f.i("pub.dat", jSONObject.toString(), true);
                        this.f67853d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f67848f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f67856d;

        /* renamed from: e  reason: collision with root package name */
        public long f67857e;

        /* renamed from: f  reason: collision with root package name */
        public long f67858f;

        /* renamed from: g  reason: collision with root package name */
        public long f67859g;

        /* renamed from: h  reason: collision with root package name */
        public String f67860h;

        public c(a aVar, String str) {
            super(aVar.f67848f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f67856d = jSONObject.getString("pkg");
            this.f67858f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f67857e = jSONObject.getLong("last_fe_ts");
            this.f67860h = jSONObject.getString("id");
            this.f67859g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f67856d);
            jSONObject.put("last_fe_ts", this.f67857e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f67858f);
            jSONObject.put("id", this.f67860h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f67859g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f67856d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f67857e != j) {
                this.f67857e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f67856d)) {
                return false;
            }
            this.f67856d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f67860h;
        }

        public boolean k(long j) {
            if (this.f67858f != j) {
                this.f67858f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f67860h)) {
                return false;
            }
            this.f67860h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f67859g;
        }

        public boolean n(long j) {
            if (this.f67859g != j) {
                this.f67859g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f67849g = new b();
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
            packageInfo = this.f67809a.f67813a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f67819a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f67819a && cVar != null) {
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
        this.f67848f = this.f67810b.f("isc");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f67809a.f67813a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f67849g.h();
            try {
                return h(eVar);
            } finally {
                this.f67849g.i();
                i();
                this.f67849g.i();
                this.f67849g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f67849g.h();
        this.f67848f.a();
        String c2 = this.f67809a.f67815c.a("aid").c();
        if (c2.equals(this.f67849g.f())) {
            return a.f.d();
        }
        this.f67849g.d(c2);
        this.f67849g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f67849g.c(C1843a.a(this.f67848f, this.f67809a.f67814b) ? 1 : 2, 3L);
    }
}
