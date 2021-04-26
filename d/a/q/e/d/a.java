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
    public a.C1722a f63594f;

    /* renamed from: g  reason: collision with root package name */
    public C1717a f63595g;

    /* renamed from: d.a.q.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1717a {

        /* renamed from: a  reason: collision with root package name */
        public long f63596a;

        /* renamed from: b  reason: collision with root package name */
        public String f63597b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63598c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63599d = true;

        public C1717a() {
        }

        public long a() {
            return this.f63596a;
        }

        public void b(long j) {
            if (this.f63596a != j) {
                this.f63596a = j;
                this.f63598c = true;
            }
        }

        public void c(String str) {
            if (str.equals(this.f63597b)) {
                return;
            }
            this.f63597b = str;
            this.f63598c = true;
        }

        public String d() {
            return this.f63597b;
        }

        public boolean e(String str) {
            Context context;
            this.f63599d = false;
            try {
                context = a.this.f63578a.f63582a.createPackageContext(str, 0);
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
            return g(a.this.f63594f.g("pub.dat", true));
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f63596a = jSONObject.getLong("pub_lst_ts");
                    this.f63597b = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f63598c = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            if (this.f63599d) {
                if (this.f63598c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f63597b);
                        jSONObject.put("pub_lst_ts", this.f63596a);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f63594f.i("pub.dat", jSONObject.toString(), true);
                        this.f63598c = false;
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
                File externalCacheDir = a.this.f63578a.f63582a.getExternalCacheDir();
                File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.f63597b);
                jSONObject.put("pub_lst_ts", this.f63596a);
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
        public String f63601d;

        /* renamed from: e  reason: collision with root package name */
        public long f63602e;

        /* renamed from: f  reason: collision with root package name */
        public long f63603f;

        /* renamed from: g  reason: collision with root package name */
        public long f63604g;

        /* renamed from: h  reason: collision with root package name */
        public String f63605h;

        public b(a aVar, String str) {
            super(aVar.f63594f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f63601d = jSONObject.getString("pkg");
            this.f63603f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f63602e = jSONObject.getLong("last_fe_ts");
            this.f63605h = jSONObject.getString("id");
            this.f63604g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f63601d);
            jSONObject.put("last_fe_ts", this.f63602e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f63603f);
            jSONObject.put("id", this.f63605h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f63604g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f63601d;
        }

        public void g(C1717a c1717a) {
            l(c1717a.d());
            k(c1717a.a());
        }

        public boolean h(long j) {
            if (this.f63602e != j) {
                this.f63602e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f63601d)) {
                return false;
            }
            this.f63601d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f63605h;
        }

        public boolean k(long j) {
            if (this.f63603f != j) {
                this.f63603f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f63605h)) {
                return false;
            }
            this.f63605h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f63604g;
        }

        public boolean n(long j) {
            if (this.f63604g != j) {
                this.f63604g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.f63595g = new C1717a();
    }

    @Override // d.a.q.e.a
    public a.h b(String str, a.g gVar) {
        PackageInfo packageInfo;
        Context context = this.f63578a.f63582a;
        b bVar = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-1);
        }
        if (gVar.f63588a) {
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
            C1717a c1717a = new C1717a();
            if (c1717a.e(str)) {
                if (gVar.f63588a && bVar != null) {
                    bVar.g(c1717a);
                    bVar.h(System.currentTimeMillis());
                    bVar.n(packageInfo.lastUpdateTime);
                    bVar.i(str);
                    bVar.b();
                }
                return a.h.e(c1717a.d());
            }
            return a.h.a(-2);
        }
        return a.h.a(-100);
    }

    @Override // d.a.q.e.a
    public void e(a.d dVar) {
        this.f63594f = this.f63579b.f("esc-es");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a();
        }
        this.f63595g.f();
        try {
            return i(eVar);
        } finally {
            this.f63595g.h();
        }
    }

    public final a.f i(a.e eVar) {
        String c2 = this.f63578a.f63584c.a("aid").c();
        if (c2.equals(this.f63595g.d())) {
            return a.f.d();
        }
        this.f63595g.c(c2);
        this.f63595g.b(System.currentTimeMillis());
        this.f63595g.h();
        return this.f63595g.i() ? a.f.d() : a.f.a();
    }
}
