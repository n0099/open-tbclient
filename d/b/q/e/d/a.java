package d.b.q.e.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import d.b.q.e.a;
import d.b.q.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.e.a {

    /* renamed from: f  reason: collision with root package name */
    public a.C1752a f64318f;

    /* renamed from: g  reason: collision with root package name */
    public C1747a f64319g;

    /* renamed from: d.b.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1747a {

        /* renamed from: a  reason: collision with root package name */
        public long f64320a;

        /* renamed from: b  reason: collision with root package name */
        public String f64321b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64322c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64323d = true;

        public C1747a() {
        }

        public long a() {
            return this.f64320a;
        }

        public void b(long j) {
            if (this.f64320a != j) {
                this.f64320a = j;
                this.f64322c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f64321b)) {
                return;
            }
            this.f64321b = str;
            this.f64322c = true;
        }

        public String d() {
            return this.f64321b;
        }

        public boolean e(String str) {
            Context context;
            this.f64323d = false;
            try {
                context = a.this.f64302a.f64306a.createPackageContext(str, 0);
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
                return g(d.b.q.g.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
            } catch (Throwable unused) {
                return false;
            }
        }

        public boolean f() {
            return g(a.this.f64318f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64320a = jSONObject.getLong("pub_lst_ts");
                    this.f64321b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64322c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f64323d) {
                if (this.f64322c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64321b);
                        jSONObject.put("pub_lst_ts", this.f64320a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64318f.i("pub.dat", jSONObject.toString(), true);
                        this.f64322c = false;
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
                File externalCacheDir = a.this.f64302a.f64306a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f64321b);
                jSONObject.put("pub_lst_ts", this.f64320a);
                jSONObject.put("d_form_ver", 1);
                d.b.q.g.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f64325d;

        /* renamed from: e  reason: collision with root package name */
        public long f64326e;

        /* renamed from: f  reason: collision with root package name */
        public long f64327f;

        /* renamed from: g  reason: collision with root package name */
        public long f64328g;

        /* renamed from: h  reason: collision with root package name */
        public String f64329h;

        public b(a aVar, String str) {
            super(aVar.f64318f, str);
        }

        @Override // d.b.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64325d = jSONObject.getString("pkg");
            this.f64327f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64326e = jSONObject.getLong("last_fe_ts");
            this.f64329h = jSONObject.getString("id");
            this.f64328g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64325d);
            jSONObject.put("last_fe_ts", this.f64326e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64327f);
            jSONObject.put("id", this.f64329h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64328g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64325d;
        }

        public void g(C1747a c1747a) {
            l(c1747a.d());
            k(c1747a.a());
        }

        public boolean h(long j) {
            if (this.f64326e != j) {
                this.f64326e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64325d)) {
                return false;
            }
            this.f64325d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64329h;
        }

        public boolean k(long j) {
            if (this.f64327f != j) {
                this.f64327f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64329h)) {
                return false;
            }
            this.f64329h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64328g;
        }

        public boolean n(long j) {
            if (this.f64328g != j) {
                this.f64328g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f64319g = new C1747a();
    }

    @Override // d.b.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f64302a.f64306a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f64312a) {
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
            C1747a c1747a = new C1747a();
            if (c1747a.e(str)) {
                if (gVar.f64312a && bVar != null) {
                    bVar.g(c1747a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1747a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.b.q.e.a
    public void e(a.d dVar) {
        this.f64318f = this.f64303b.f("esc-es");
    }

    @Override // d.b.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f64319g.f();
        try {
            return i(eVar);
        } finally {
            this.f64319g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f64302a.f64308c.a("aid").c();
        if (c2.equals(this.f64319g.d())) {
            return a.f.d();
        }
        this.f64319g.c(c2);
        this.f64319g.b(System.currentTimeMillis());
        this.f64319g.h();
        return this.f64319g.i() ? a.f.d() : a.f.a();
    }
}
