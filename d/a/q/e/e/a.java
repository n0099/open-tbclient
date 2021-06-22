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
    public a.C1848a f67804f;

    /* renamed from: g  reason: collision with root package name */
    public b f67805g;

    /* renamed from: d.a.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1845a {
        public static boolean a(a.C1848a c1848a, d.a.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1848a != null && !c1848a.b().equals(aVar.b())) {
                    c1848a.b().setExecutable(true, false);
                    c1848a = c1848a.e();
                }
                return true;
            }
            while (c1848a != null) {
                if (!b(c1848a.b())) {
                    return false;
                }
                c1848a = c1848a.e();
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
        public long f67807b;

        /* renamed from: c  reason: collision with root package name */
        public String f67808c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67809d;

        /* renamed from: a  reason: collision with root package name */
        public e f67806a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f67810e = true;

        public b() {
        }

        public long a() {
            return this.f67807b;
        }

        public void b(long j) {
            if (this.f67807b != j) {
                this.f67807b = j;
                this.f67809d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f67806a.c(j, j2)) {
                this.f67809d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f67808c)) {
                return;
            }
            this.f67808c = str;
            this.f67809d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f67804f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f67810e = false;
            return g(g2);
        }

        public String f() {
            return this.f67808c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f67807b = jSONObject.getLong("pub_lst_ts");
                    this.f67808c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f67809d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f67804f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f67810e) {
                if (this.f67809d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f67808c);
                        jSONObject.put("pub_lst_ts", this.f67807b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f67804f.i("pub.dat", jSONObject.toString(), true);
                        this.f67809d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f67804f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f67812d;

        /* renamed from: e  reason: collision with root package name */
        public long f67813e;

        /* renamed from: f  reason: collision with root package name */
        public long f67814f;

        /* renamed from: g  reason: collision with root package name */
        public long f67815g;

        /* renamed from: h  reason: collision with root package name */
        public String f67816h;

        public c(a aVar, String str) {
            super(aVar.f67804f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f67812d = jSONObject.getString("pkg");
            this.f67814f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f67813e = jSONObject.getLong("last_fe_ts");
            this.f67816h = jSONObject.getString("id");
            this.f67815g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f67812d);
            jSONObject.put("last_fe_ts", this.f67813e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f67814f);
            jSONObject.put("id", this.f67816h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f67815g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f67812d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f67813e != j) {
                this.f67813e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f67812d)) {
                return false;
            }
            this.f67812d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f67816h;
        }

        public boolean k(long j) {
            if (this.f67814f != j) {
                this.f67814f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f67816h)) {
                return false;
            }
            this.f67816h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f67815g;
        }

        public boolean n(long j) {
            if (this.f67815g != j) {
                this.f67815g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f67805g = new b();
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
            packageInfo = this.f67765a.f67769a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f67775a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f67775a && cVar != null) {
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
        this.f67804f = this.f67766b.f("isc");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f67765a.f67769a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f67805g.h();
            try {
                return h(eVar);
            } finally {
                this.f67805g.i();
                i();
                this.f67805g.i();
                this.f67805g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f67805g.h();
        this.f67804f.a();
        String c2 = this.f67765a.f67771c.a("aid").c();
        if (c2.equals(this.f67805g.f())) {
            return a.f.d();
        }
        this.f67805g.d(c2);
        this.f67805g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f67805g.c(C1845a.a(this.f67804f, this.f67765a.f67770b) ? 1 : 2, 3L);
    }
}
