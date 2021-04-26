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
    public a.C1722a f63617f;

    /* renamed from: g  reason: collision with root package name */
    public b f63618g;

    /* renamed from: d.a.q.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1719a {
        public static boolean a(a.C1722a c1722a, d.a.q.g.d.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c1722a != null && !c1722a.b().equals(aVar.b())) {
                    c1722a.b().setExecutable(true, false);
                    c1722a = c1722a.e();
                }
                return true;
            }
            while (c1722a != null) {
                if (!b(c1722a.b())) {
                    return false;
                }
                c1722a = c1722a.e();
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
        public long f63620b;

        /* renamed from: c  reason: collision with root package name */
        public String f63621c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63622d;

        /* renamed from: a  reason: collision with root package name */
        public e f63619a = new e();

        /* renamed from: e  reason: collision with root package name */
        public boolean f63623e = true;

        public b() {
        }

        public long a() {
            return this.f63620b;
        }

        public void b(long j) {
            if (this.f63620b != j) {
                this.f63620b = j;
                this.f63622d = true;
            }
        }

        public void c(long j, long j2) {
            if (this.f63619a.c(j, j2)) {
                this.f63622d = true;
            }
        }

        public void d(String str) {
            if (str.equals(this.f63621c)) {
                return;
            }
            this.f63621c = str;
            this.f63622d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            String g2 = a.this.f63617f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
            this.f63623e = false;
            return g(g2);
        }

        public String f() {
            return this.f63621c;
        }

        public final boolean g(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f63620b = jSONObject.getLong("pub_lst_ts");
                    this.f63621c = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f63622d = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean h() {
            return g(a.this.f63617f.g("pub.dat", true));
        }

        public boolean i() {
            if (this.f63623e) {
                if (this.f63622d) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f63621c);
                        jSONObject.put("pub_lst_ts", this.f63620b);
                        jSONObject.put("d_form_ver", 1);
                        a.this.f63617f.i("pub.dat", jSONObject.toString(), true);
                        this.f63622d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean j() {
            return a.k(a.this.f63617f.d("pub.dat"), true);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.c {

        /* renamed from: d  reason: collision with root package name */
        public String f63625d;

        /* renamed from: e  reason: collision with root package name */
        public long f63626e;

        /* renamed from: f  reason: collision with root package name */
        public long f63627f;

        /* renamed from: g  reason: collision with root package name */
        public long f63628g;

        /* renamed from: h  reason: collision with root package name */
        public String f63629h;

        public c(a aVar, String str) {
            super(aVar.f63617f, str);
        }

        @Override // d.a.q.e.a.c
        public void c(JSONObject jSONObject) {
            this.f63625d = jSONObject.getString("pkg");
            this.f63627f = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f63626e = jSONObject.getLong("last_fe_ts");
            this.f63629h = jSONObject.getString("id");
            this.f63628g = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        @Override // d.a.q.e.a.c
        public void e(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f63625d);
            jSONObject.put("last_fe_ts", this.f63626e);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f63627f);
            jSONObject.put("id", this.f63629h);
            jSONObject.put("tar_pkg_lst_up_ts", this.f63628g);
            jSONObject.put("d_form_ver", 1);
        }

        public String f() {
            return this.f63625d;
        }

        public void g(b bVar) {
            l(bVar.f());
            k(bVar.a());
        }

        public boolean h(long j) {
            if (this.f63626e != j) {
                this.f63626e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean i(String str) {
            if (str.equals(this.f63625d)) {
                return false;
            }
            this.f63625d = str;
            a(true);
            return true;
        }

        public String j() {
            return this.f63629h;
        }

        public boolean k(long j) {
            if (this.f63627f != j) {
                this.f63627f = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean l(String str) {
            if (str.equals(this.f63629h)) {
                return false;
            }
            this.f63629h = str;
            a(true);
            return true;
        }

        public long m() {
            return this.f63628g;
        }

        public boolean n(long j) {
            if (this.f63628g != j) {
                this.f63628g = j;
                a(true);
                return true;
            }
            return false;
        }
    }

    public a() {
        super("isc", 8000000L);
        this.f63618g = new b();
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
            packageInfo = this.f63578a.f63582a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.h.a(-2);
        }
        if (gVar.f63588a) {
            cVar = new c(this, str);
            cVar.d();
            if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                f2 = cVar.j();
                return a.h.e(f2);
            }
        }
        b bVar = new b();
        if (bVar.e(packageInfo)) {
            if (gVar.f63588a && cVar != null) {
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
        this.f63617f = this.f63579b.f("isc");
    }

    @Override // d.a.q.e.a
    public a.f f(a.e eVar) {
        Context context = this.f63578a.f63582a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.f63618g.h();
            try {
                return h(eVar);
            } finally {
                this.f63618g.i();
                i();
                this.f63618g.i();
                this.f63618g.j();
            }
        }
        return a.f.b(-100);
    }

    public final a.f h(a.e eVar) {
        this.f63618g.h();
        this.f63617f.a();
        String c2 = this.f63578a.f63584c.a("aid").c();
        if (c2.equals(this.f63618g.f())) {
            return a.f.d();
        }
        this.f63618g.d(c2);
        this.f63618g.b(System.currentTimeMillis());
        return a.f.d();
    }

    public final void i() {
        this.f63618g.c(C1719a.a(this.f63617f, this.f63578a.f63583b) ? 1 : 2, 3L);
    }
}
