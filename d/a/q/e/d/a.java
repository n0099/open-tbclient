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
    public a.C1848a f67781f;

    /* renamed from: g  reason: collision with root package name */
    public C1843a f67782g;

    /* renamed from: d.a.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1843a {

        /* renamed from: a  reason: collision with root package name */
        public long f67783a;

        /* renamed from: b  reason: collision with root package name */
        public String f67784b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67785c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67786d = true;

        public C1843a() {
        }

        public long a() {
            return this.f67783a;
        }

        public void b(long j) {
            if (this.f67783a != j) {
                this.f67783a = j;
                this.f67785c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f67784b)) {
                return;
            }
            this.f67784b = str;
            this.f67785c = true;
        }

        public String d() {
            return this.f67784b;
        }

        public boolean e(String str) {
            Context context;
            this.f67786d = false;
            try {
                context = a.this.f67765a.f67769a.createPackageContext(str, 0);
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
            return g(a.this.f67781f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f67783a = jSONObject.getLong("pub_lst_ts");
                    this.f67784b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f67785c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f67786d) {
                if (this.f67785c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f67784b);
                        jSONObject.put("pub_lst_ts", this.f67783a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f67781f.i("pub.dat", jSONObject.toString(), true);
                        this.f67785c = false;
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
                File externalCacheDir = a.this.f67765a.f67769a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f67784b);
                jSONObject.put("pub_lst_ts", this.f67783a);
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
        public String f67788d;

        /* renamed from: e  reason: collision with root package name */
        public long f67789e;

        /* renamed from: f  reason: collision with root package name */
        public long f67790f;

        /* renamed from: g  reason: collision with root package name */
        public long f67791g;

        /* renamed from: h  reason: collision with root package name */
        public String f67792h;

        public b(a aVar, String str) {
            super(aVar.f67781f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f67788d = jSONObject.getString("pkg");
            this.f67790f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f67789e = jSONObject.getLong("last_fe_ts");
            this.f67792h = jSONObject.getString("id");
            this.f67791g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f67788d);
            jSONObject.put("last_fe_ts", this.f67789e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f67790f);
            jSONObject.put("id", this.f67792h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f67791g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f67788d;
        }

        public void g(C1843a c1843a) {
            l(c1843a.d());
            k(c1843a.a());
        }

        public boolean h(long j) {
            if (this.f67789e != j) {
                this.f67789e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f67788d)) {
                return false;
            }
            this.f67788d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f67792h;
        }

        public boolean k(long j) {
            if (this.f67790f != j) {
                this.f67790f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f67792h)) {
                return false;
            }
            this.f67792h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f67791g;
        }

        public boolean n(long j) {
            if (this.f67791g != j) {
                this.f67791g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f67782g = new C1843a();
    }

    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f67765a.f67769a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f67775a) {
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
            C1843a c1843a = new C1843a();
            if (c1843a.e(str)) {
                if (gVar.f67775a && bVar != null) {
                    bVar.g(c1843a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1843a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f67781f = this.f67766b.f("esc-es");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f67782g.f();
        try {
            return i(eVar);
        } finally {
            this.f67782g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f67765a.f67771c.a("aid").c();
        if (c2.equals(this.f67782g.d())) {
            return a.f.d();
        }
        this.f67782g.c(c2);
        this.f67782g.b(System.currentTimeMillis());
        this.f67782g.h();
        return this.f67782g.i() ? a.f.d() : a.f.a();
    }
}
