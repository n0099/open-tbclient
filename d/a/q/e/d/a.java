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
    public a.C1788a f64107f;

    /* renamed from: g  reason: collision with root package name */
    public C1783a f64108g;

    /* renamed from: d.a.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1783a {

        /* renamed from: a  reason: collision with root package name */
        public long f64109a;

        /* renamed from: b  reason: collision with root package name */
        public String f64110b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64111c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64112d = true;

        public C1783a() {
        }

        public long a() {
            return this.f64109a;
        }

        public void b(long j) {
            if (this.f64109a != j) {
                this.f64109a = j;
                this.f64111c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f64110b)) {
                return;
            }
            this.f64110b = str;
            this.f64111c = true;
        }

        public String d() {
            return this.f64110b;
        }

        public boolean e(String str) {
            Context context;
            this.f64112d = false;
            try {
                context = a.this.f64091a.f64095a.createPackageContext(str, 0);
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
            return g(a.this.f64107f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f64109a = jSONObject.getLong("pub_lst_ts");
                    this.f64110b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f64111c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f64112d) {
                if (this.f64111c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f64110b);
                        jSONObject.put("pub_lst_ts", this.f64109a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f64107f.i("pub.dat", jSONObject.toString(), true);
                        this.f64111c = false;
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
                File externalCacheDir = a.this.f64091a.f64095a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f64110b);
                jSONObject.put("pub_lst_ts", this.f64109a);
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
        public String f64114d;

        /* renamed from: e  reason: collision with root package name */
        public long f64115e;

        /* renamed from: f  reason: collision with root package name */
        public long f64116f;

        /* renamed from: g  reason: collision with root package name */
        public long f64117g;

        /* renamed from: h  reason: collision with root package name */
        public String f64118h;

        public b(a aVar, String str) {
            super(aVar.f64107f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f64114d = jSONObject.getString("pkg");
            this.f64116f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f64115e = jSONObject.getLong("last_fe_ts");
            this.f64118h = jSONObject.getString("id");
            this.f64117g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f64114d);
            jSONObject.put("last_fe_ts", this.f64115e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f64116f);
            jSONObject.put("id", this.f64118h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f64117g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f64114d;
        }

        public void g(C1783a c1783a) {
            l(c1783a.d());
            k(c1783a.a());
        }

        public boolean h(long j) {
            if (this.f64115e != j) {
                this.f64115e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f64114d)) {
                return false;
            }
            this.f64114d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f64118h;
        }

        public boolean k(long j) {
            if (this.f64116f != j) {
                this.f64116f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f64118h)) {
                return false;
            }
            this.f64118h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f64117g;
        }

        public boolean n(long j) {
            if (this.f64117g != j) {
                this.f64117g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f64108g = new C1783a();
    }

    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f64091a.f64095a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f64101a) {
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
            C1783a c1783a = new C1783a();
            if (c1783a.e(str)) {
                if (gVar.f64101a && bVar != null) {
                    bVar.g(c1783a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1783a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f64107f = this.f64092b.f("esc-es");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f64108g.f();
        try {
            return i(eVar);
        } finally {
            this.f64108g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f64091a.f64097c.a("aid").c();
        if (c2.equals(this.f64108g.d())) {
            return a.f.d();
        }
        this.f64108g.c(c2);
        this.f64108g.b(System.currentTimeMillis());
        this.f64108g.h();
        return this.f64108g.i() ? a.f.d() : a.f.a();
    }
}
