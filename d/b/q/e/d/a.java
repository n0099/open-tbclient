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
    public a.C1753a f64319f;

    /* renamed from: g  reason: collision with root package name */
    public C1748a f64320g;

    /* renamed from: d.b.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1748a {

        /* renamed from: a  reason: collision with root package name */
        public long f64321a;

        /* renamed from: b  reason: collision with root package name */
        public String f64322b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64323c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64324d = true;

        public C1748a() {
        }

        public long a() {
            return this.f64321a;
        }

        public void b(long j) {
            if (this.f64321a != j) {
                this.f64321a = j;
                this.f64323c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f64322b)) {
                return;
            }
            this.f64322b = str;
            this.f64323c = true;
        }

        public String d() {
            return this.f64322b;
        }

        public boolean e(String str) {
            Context context;
            this.f64324d = false;
            try {
                context = a.this.f64303a.f64307a.createPackageContext(str, 0);
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
            return g(a.this.f64319f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64321a = jSONObject.getLong("pub_lst_ts");
                    this.f64322b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64323c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f64324d) {
                if (this.f64323c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64322b);
                        jSONObject.put("pub_lst_ts", this.f64321a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64319f.i("pub.dat", jSONObject.toString(), true);
                        this.f64323c = false;
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
                File externalCacheDir = a.this.f64303a.f64307a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f64322b);
                jSONObject.put("pub_lst_ts", this.f64321a);
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
        public String f64326d;

        /* renamed from: e  reason: collision with root package name */
        public long f64327e;

        /* renamed from: f  reason: collision with root package name */
        public long f64328f;

        /* renamed from: g  reason: collision with root package name */
        public long f64329g;

        /* renamed from: h  reason: collision with root package name */
        public String f64330h;

        public b(a aVar, String str) {
            super(aVar.f64319f, str);
        }

        @Override // d.b.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64326d = jSONObject.getString("pkg");
            this.f64328f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64327e = jSONObject.getLong("last_fe_ts");
            this.f64330h = jSONObject.getString("id");
            this.f64329g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64326d);
            jSONObject.put("last_fe_ts", this.f64327e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64328f);
            jSONObject.put("id", this.f64330h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64329g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64326d;
        }

        public void g(C1748a c1748a) {
            l(c1748a.d());
            k(c1748a.a());
        }

        public boolean h(long j) {
            if (this.f64327e != j) {
                this.f64327e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64326d)) {
                return false;
            }
            this.f64326d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64330h;
        }

        public boolean k(long j) {
            if (this.f64328f != j) {
                this.f64328f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64330h)) {
                return false;
            }
            this.f64330h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64329g;
        }

        public boolean n(long j) {
            if (this.f64329g != j) {
                this.f64329g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f64320g = new C1748a();
    }

    @Override // d.b.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f64303a.f64307a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f64313a) {
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
            C1748a c1748a = new C1748a();
            if (c1748a.e(str)) {
                if (gVar.f64313a && bVar != null) {
                    bVar.g(c1748a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1748a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.b.q.e.a
    public void e(a.d dVar) {
        this.f64319f = this.f64304b.f("esc-es");
    }

    @Override // d.b.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f64320g.f();
        try {
            return i(eVar);
        } finally {
            this.f64320g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f64303a.f64309c.a("aid").c();
        if (c2.equals(this.f64320g.d())) {
            return a.f.d();
        }
        this.f64320g.c(c2);
        this.f64320g.b(System.currentTimeMillis());
        this.f64320g.h();
        return this.f64320g.i() ? a.f.d() : a.f.a();
    }
}
