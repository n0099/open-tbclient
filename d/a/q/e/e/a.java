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
    public a.C1788a f64130f;

    /* renamed from: g  reason: collision with root package name */
    public b f64131g;

    /* renamed from: d.a.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1785a {
        public static boolean a(a.C1788a c1788a, d.a.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1788a != null && !c1788a.b().equals(aVar.b())) {
                    c1788a.b().setExecutable(true, false);
                    c1788a = c1788a.e();
                }
                return true;
            }
            while (c1788a != null) {
                if (!b(c1788a.b())) {
                    return false;
                }
                c1788a = c1788a.e();
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
        public long f64133b;

        /* renamed from: c  reason: collision with root package name */
        public String f64134c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64135d;

        /* renamed from: a  reason: collision with root package name */
        public e f64132a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f64136e = true;

        public b() {
        }

        public long a() {
            return this.f64133b;
        }

        public void b(long j) {
            if (this.f64133b != j) {
                this.f64133b = j;
                this.f64135d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f64132a.c(j, j2)) {
                this.f64135d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f64134c)) {
                return;
            }
            this.f64134c = str;
            this.f64135d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f64130f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f64136e = false;
            return g(g2);
        }

        public String f() {
            return this.f64134c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64133b = jSONObject.getLong("pub_lst_ts");
                    this.f64134c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64135d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f64130f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f64136e) {
                if (this.f64135d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64134c);
                        jSONObject.put("pub_lst_ts", this.f64133b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64130f.i("pub.dat", jSONObject.toString(), true);
                        this.f64135d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f64130f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f64138d;

        /* renamed from: e  reason: collision with root package name */
        public long f64139e;

        /* renamed from: f  reason: collision with root package name */
        public long f64140f;

        /* renamed from: g  reason: collision with root package name */
        public long f64141g;

        /* renamed from: h  reason: collision with root package name */
        public String f64142h;

        public c(a aVar, String str) {
            super(aVar.f64130f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64138d = jSONObject.getString("pkg");
            this.f64140f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64139e = jSONObject.getLong("last_fe_ts");
            this.f64142h = jSONObject.getString("id");
            this.f64141g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64138d);
            jSONObject.put("last_fe_ts", this.f64139e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64140f);
            jSONObject.put("id", this.f64142h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64141g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64138d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f64139e != j) {
                this.f64139e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64138d)) {
                return false;
            }
            this.f64138d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64142h;
        }

        public boolean k(long j) {
            if (this.f64140f != j) {
                this.f64140f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64142h)) {
                return false;
            }
            this.f64142h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64141g;
        }

        public boolean n(long j) {
            if (this.f64141g != j) {
                this.f64141g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f64131g = new b();
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
            packageInfo = this.f64091a.f64095a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f64101a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f64101a && cVar != null) {
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
        this.f64130f = this.f64092b.f("isc");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f64091a.f64095a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f64131g.h();
            try {
                return h(eVar);
            } finally {
                this.f64131g.i();
                i();
                this.f64131g.i();
                this.f64131g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f64131g.h();
        this.f64130f.a();
        String c2 = this.f64091a.f64097c.a("aid").c();
        if (c2.equals(this.f64131g.f())) {
            return a.f.d();
        }
        this.f64131g.d(c2);
        this.f64131g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f64131g.c(C1785a.a(this.f64130f, this.f64091a.f64096b) ? 1 : 2, 3L);
    }
}
