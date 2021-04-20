package d.b.p.e.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import d.b.p.e.a;
import d.b.p.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.p.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1765a f65013f;

    /* renamed from: g  reason: collision with root package name */
    public C1760a f65014g;

    /* renamed from: d.b.p.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1760a {

        /* renamed from: a  reason: collision with root package name */
        public long f65015a;

        /* renamed from: b  reason: collision with root package name */
        public String f65016b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65017c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65018d = true;

        public C1760a() {
        }

        public long a() {
            return this.f65015a;
        }

        public void b(long j) {
            if (this.f65015a != j) {
                this.f65015a = j;
                this.f65017c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f65016b)) {
                return;
            }
            this.f65016b = str;
            this.f65017c = true;
        }

        public String d() {
            return this.f65016b;
        }

        public boolean e(String str) {
            Context context;
            this.f65018d = false;
            try {
                context = a.this.f64997a.f65001a.createPackageContext(str, 0);
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
                return g(d.b.p.g.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
            } catch (Throwable unused) {
                return false;
            }
        }

        public boolean f() {
            return g(a.this.f65013f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f65015a = jSONObject.getLong("pub_lst_ts");
                    this.f65016b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f65017c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f65018d) {
                if (this.f65017c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f65016b);
                        jSONObject.put("pub_lst_ts", this.f65015a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f65013f.i("pub.dat", jSONObject.toString(), true);
                        this.f65017c = false;
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
                File externalCacheDir = a.this.f64997a.f65001a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f65016b);
                jSONObject.put("pub_lst_ts", this.f65015a);
                jSONObject.put("d_form_ver", 1);
                d.b.p.g.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f65020d;

        /* renamed from: e  reason: collision with root package name */
        public long f65021e;

        /* renamed from: f  reason: collision with root package name */
        public long f65022f;

        /* renamed from: g  reason: collision with root package name */
        public long f65023g;

        /* renamed from: h  reason: collision with root package name */
        public String f65024h;

        public b(a aVar, String str) {
            super(aVar.f65013f, str);
        }

        @Override // d.b.p.e.a.c
        public void c(JSONObject jSONObject) {
            this.f65020d = jSONObject.getString("pkg");
            this.f65022f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f65021e = jSONObject.getLong("last_fe_ts");
            this.f65024h = jSONObject.getString("id");
            this.f65023g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.p.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f65020d);
            jSONObject.put("last_fe_ts", this.f65021e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f65022f);
            jSONObject.put("id", this.f65024h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f65023g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f65020d;
        }

        public void g(C1760a c1760a) {
            l(c1760a.d());
            k(c1760a.a());
        }

        public boolean h(long j) {
            if (this.f65021e != j) {
                this.f65021e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f65020d)) {
                return false;
            }
            this.f65020d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f65024h;
        }

        public boolean k(long j) {
            if (this.f65022f != j) {
                this.f65022f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f65024h)) {
                return false;
            }
            this.f65024h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f65023g;
        }

        public boolean n(long j) {
            if (this.f65023g != j) {
                this.f65023g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f65014g = new C1760a();
    }

    @Override // d.b.p.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f64997a.f65001a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f65007a) {
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
            C1760a c1760a = new C1760a();
            if (c1760a.e(str)) {
                if (gVar.f65007a && bVar != null) {
                    bVar.g(c1760a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1760a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.b.p.e.a
    public void e(a.d dVar) {
        this.f65013f = this.f64998b.f("esc-es");
    }

    @Override // d.b.p.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f65014g.f();
        try {
            return i(eVar);
        } finally {
            this.f65014g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f64997a.f65003c.a("aid").c();
        if (c2.equals(this.f65014g.d())) {
            return a.f.d();
        }
        this.f65014g.c(c2);
        this.f65014g.b(System.currentTimeMillis());
        this.f65014g.h();
        return this.f65014g.i() ? a.f.d() : a.f.a();
    }
}
