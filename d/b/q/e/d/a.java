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
    public a.C1784a f65277f;

    /* renamed from: g  reason: collision with root package name */
    public C1779a f65278g;

    /* renamed from: d.b.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1779a {

        /* renamed from: a  reason: collision with root package name */
        public long f65279a;

        /* renamed from: b  reason: collision with root package name */
        public String f65280b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65281c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65282d = true;

        public C1779a() {
        }

        public long a() {
            return this.f65279a;
        }

        public void b(long j) {
            if (this.f65279a != j) {
                this.f65279a = j;
                this.f65281c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f65280b)) {
                return;
            }
            this.f65280b = str;
            this.f65281c = true;
        }

        public String d() {
            return this.f65280b;
        }

        public boolean e(String str) {
            Context context;
            this.f65282d = false;
            try {
                context = a.this.f65261a.f65265a.createPackageContext(str, 0);
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
            return g(a.this.f65277f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f65279a = jSONObject.getLong("pub_lst_ts");
                    this.f65280b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f65281c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f65282d) {
                if (this.f65281c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f65280b);
                        jSONObject.put("pub_lst_ts", this.f65279a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f65277f.i("pub.dat", jSONObject.toString(), true);
                        this.f65281c = false;
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
                File externalCacheDir = a.this.f65261a.f65265a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f65280b);
                jSONObject.put("pub_lst_ts", this.f65279a);
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
        public String f65284d;

        /* renamed from: e  reason: collision with root package name */
        public long f65285e;

        /* renamed from: f  reason: collision with root package name */
        public long f65286f;

        /* renamed from: g  reason: collision with root package name */
        public long f65287g;

        /* renamed from: h  reason: collision with root package name */
        public String f65288h;

        public b(a aVar, String str) {
            super(aVar.f65277f, str);
        }

        @Override // d.b.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f65284d = jSONObject.getString("pkg");
            this.f65286f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f65285e = jSONObject.getLong("last_fe_ts");
            this.f65288h = jSONObject.getString("id");
            this.f65287g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.b.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f65284d);
            jSONObject.put("last_fe_ts", this.f65285e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f65286f);
            jSONObject.put("id", this.f65288h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f65287g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f65284d;
        }

        public void g(C1779a c1779a) {
            l(c1779a.d());
            k(c1779a.a());
        }

        public boolean h(long j) {
            if (this.f65285e != j) {
                this.f65285e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f65284d)) {
                return false;
            }
            this.f65284d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f65288h;
        }

        public boolean k(long j) {
            if (this.f65286f != j) {
                this.f65286f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f65288h)) {
                return false;
            }
            this.f65288h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f65287g;
        }

        public boolean n(long j) {
            if (this.f65287g != j) {
                this.f65287g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f65278g = new C1779a();
    }

    @Override // d.b.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f65261a.f65265a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f65271a) {
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
            C1779a c1779a = new C1779a();
            if (c1779a.e(str)) {
                if (gVar.f65271a && bVar != null) {
                    bVar.g(c1779a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1779a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.b.q.e.a
    public void e(a.d dVar) {
        this.f65277f = this.f65262b.f("esc-es");
    }

    @Override // d.b.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f65278g.f();
        try {
            return i(eVar);
        } finally {
            this.f65278g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f65261a.f65267c.a("aid").c();
        if (c2.equals(this.f65278g.d())) {
            return a.f.d();
        }
        this.f65278g.c(c2);
        this.f65278g.b(System.currentTimeMillis());
        this.f65278g.h();
        return this.f65278g.i() ? a.f.d() : a.f.a();
    }
}
