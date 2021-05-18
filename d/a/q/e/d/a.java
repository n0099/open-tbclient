package d.a.q.e.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import d.a.q.e.a;
import d.a.q.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.q.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1785a f64231f;

    /* renamed from: g  reason: collision with root package name */
    public C1780a f64232g;

    /* renamed from: d.a.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1780a {

        /* renamed from: a  reason: collision with root package name */
        public long f64233a;

        /* renamed from: b  reason: collision with root package name */
        public String f64234b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64235c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64236d = true;

        public C1780a() {
        }

        public long a() {
            return this.f64233a;
        }

        public void b(long j) {
            if (this.f64233a != j) {
                this.f64233a = j;
                this.f64235c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f64234b)) {
                return;
            }
            this.f64234b = str;
            this.f64235c = true;
        }

        public String d() {
            return this.f64234b;
        }

        public boolean e(String str) {
            Context context;
            this.f64236d = false;
            try {
                context = a.this.f64215a.f64219a.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                context = null;
            }
            if (context == null) {
                return false;
            }
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return false;
                }
                return g(d.a.q.g.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
            } catch (Throwable unused) {
                return false;
            }
        }

        public boolean f() {
            return g(a.this.f64231f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64233a = jSONObject.getLong("pub_lst_ts");
                    this.f64234b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64235c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f64236d) {
                if (this.f64235c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64234b);
                        jSONObject.put("pub_lst_ts", this.f64233a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64231f.i("pub.dat", jSONObject.toString(), true);
                        this.f64235c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean i() {
            try {
                File externalCacheDir = a.this.f64215a.f64219a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f64234b);
                jSONObject.put("pub_lst_ts", this.f64233a);
                jSONObject.put("d_form_ver", 1);
                d.a.q.g.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f64238d;

        /* renamed from: e  reason: collision with root package name */
        public long f64239e;

        /* renamed from: f  reason: collision with root package name */
        public long f64240f;

        /* renamed from: g  reason: collision with root package name */
        public long f64241g;

        /* renamed from: h  reason: collision with root package name */
        public String f64242h;

        public b(a aVar, String str) {
            super(aVar.f64231f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64238d = jSONObject.getString("pkg");
            this.f64240f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64239e = jSONObject.getLong("last_fe_ts");
            this.f64242h = jSONObject.getString("id");
            this.f64241g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64238d);
            jSONObject.put("last_fe_ts", this.f64239e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64240f);
            jSONObject.put("id", this.f64242h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64241g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64238d;
        }

        public void g(C1780a c1780a) {
            l(c1780a.d());
            k(c1780a.a());
        }

        public boolean h(long j) {
            if (this.f64239e != j) {
                this.f64239e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64238d)) {
                return false;
            }
            this.f64238d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64242h;
        }

        public boolean k(long j) {
            if (this.f64240f != j) {
                this.f64240f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64242h)) {
                return false;
            }
            this.f64242h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64241g;
        }

        public boolean n(long j) {
            if (this.f64241g != j) {
                this.f64241g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f64232g = new C1780a();
    }

    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f64215a.f64219a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f64225a) {
            bVar = new b(this, str);
            bVar.d();
            if (str.equals(bVar.f()) && packageInfo.lastUpdateTime == bVar.m()) {
                String j = bVar.j();
                if (!TextUtils.isEmpty(j)) {
                    return a.h.e(j);
                }
            }
        }
        if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            C1780a c1780a = new C1780a();
            if (c1780a.e(str)) {
                if (gVar.f64225a && bVar != null) {
                    bVar.g(c1780a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1780a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f64231f = this.f64216b.f("esc-es");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f64232g.f();
        try {
            return i(eVar);
        } finally {
            this.f64232g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f64215a.f64221c.a("aid").c();
        if (c2.equals(this.f64232g.d())) {
            return a.f.d();
        }
        this.f64232g.c(c2);
        this.f64232g.b(System.currentTimeMillis());
        this.f64232g.h();
        return this.f64232g.i() ? a.f.d() : a.f.a();
    }
}
