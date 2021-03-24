package d.b.k0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class g {
    public static volatile g i;

    /* renamed from: a  reason: collision with root package name */
    public Context f63934a;

    /* renamed from: b  reason: collision with root package name */
    public int f63935b;

    /* renamed from: c  reason: collision with root package name */
    public int f63936c;

    /* renamed from: d  reason: collision with root package name */
    public int f63937d;

    /* renamed from: e  reason: collision with root package name */
    public int f63938e = 614400;

    /* renamed from: f  reason: collision with root package name */
    public int f63939f = 153600;

    /* renamed from: g  reason: collision with root package name */
    public f f63940g = new f();

    /* renamed from: h  reason: collision with root package name */
    public d0 f63941h = new d0();

    public static g m() {
        if (i == null) {
            synchronized (e.class) {
                if (i == null) {
                    i = new g();
                }
            }
        }
        return i;
    }

    public void A(int i2) {
        if (i2 < this.f63936c) {
            return;
        }
        this.f63936c = i2;
        g0.e().putInt("ubc_data_expire_time", i2);
    }

    public void B(int i2) {
        if (i2 < this.f63937d) {
            return;
        }
        this.f63937d = i2;
        g0.e().putInt("ubc_database_limit", i2);
    }

    public void C(int i2) {
        if (i2 < 307200) {
            return;
        }
        this.f63938e = i2;
        g0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void D(int i2) {
        if (i2 < 30720) {
            return;
        }
        this.f63939f = i2;
        g0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void E(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.f63935b) {
            return;
        }
        this.f63935b = i3;
    }

    public void F(List<k> list) {
        for (k kVar : list) {
            String d2 = kVar.d();
            if (!TextUtils.isEmpty(d2)) {
                if ("0".equals(kVar.n())) {
                    this.f63940g.f63926a.add(d2);
                    this.f63940g.f63929d.remove(d2);
                } else {
                    this.f63940g.f63926a.remove(d2);
                    this.f63940g.f63929d.add(d2);
                }
                if ("1".equals(kVar.g())) {
                    this.f63940g.f63927b.add(d2);
                } else {
                    this.f63940g.f63927b.remove(d2);
                }
                if ("1".equals(kVar.a())) {
                    this.f63940g.f63928c.add(d2);
                } else {
                    this.f63940g.f63928c.remove(d2);
                }
                if ("1".equals(kVar.k())) {
                    this.f63940g.f63930e.add(d2);
                } else {
                    this.f63940g.f63930e.remove(d2);
                }
                if (kVar.l() >= 1 && kVar.l() <= 100) {
                    this.f63940g.f63931f.put(d2, String.valueOf(kVar.l()));
                } else {
                    this.f63940g.f63931f.remove(d2);
                }
                if (!TextUtils.isEmpty(kVar.b())) {
                    this.f63940g.f63932g.put(d2, kVar.b());
                } else {
                    this.f63940g.f63932g.remove(d2);
                }
                if (kVar.h() != 0 && kVar.i() != 0) {
                    m mVar = new m(d2, kVar.i(), kVar.h());
                    this.f63940g.f63933h.put(mVar.a(), mVar);
                }
                if (TextUtils.equals(kVar.e(), "1")) {
                    this.f63940g.i.add(d2);
                } else {
                    this.f63940g.i.remove(d2);
                }
                if (TextUtils.equals(kVar.m(), "1")) {
                    this.f63940g.j.add(d2);
                } else {
                    this.f63940g.j.remove(d2);
                }
                String c2 = kVar.c();
                if (!TextUtils.isEmpty(c2) && !TextUtils.equals(c2, "0")) {
                    this.f63940g.k.put(d2, c2);
                } else {
                    this.f63940g.k.remove(d2);
                }
                String q = kVar.q();
                if (!TextUtils.isEmpty(q)) {
                    this.f63940g.l.put(d2, q);
                } else {
                    this.f63940g.l.remove(d2);
                }
                int j = kVar.j();
                if (j != 2) {
                    this.f63940g.m.put(d2, Integer.valueOf(j));
                } else {
                    this.f63940g.m.remove(d2);
                }
            }
        }
    }

    public boolean a(String str) {
        return this.f63940g.f63928c.contains(str);
    }

    public int b(String str) {
        Integer num;
        if (!this.f63940g.m.containsKey(str) || (num = this.f63940g.m.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }

    public boolean c(String str) {
        return this.f63940g.f63930e.contains(str);
    }

    public boolean d(String str) {
        return TextUtils.equals("0", s(str));
    }

    public boolean e(String str) {
        if (this.f63941h.isUBCDebug()) {
            return true;
        }
        return this.f63940g.f63927b.contains(str);
    }

    public boolean f(String str) {
        return this.f63940g.j.contains(str);
    }

    public boolean g(String str, int i2) {
        if (this.f63940g.f63926a.contains(str)) {
            return false;
        }
        return ((i2 & 16) == 0 && (i2 & 32) == 0) || this.f63940g.f63929d.contains(str);
    }

    public boolean h(String str) {
        if (!u() && this.f63941h.isUBCSample() && q(str) > 0) {
            if (new Random().nextInt(100) >= q(str)) {
                return true;
            }
        }
        return false;
    }

    public String i(String str) {
        return this.f63940g.f63932g.containsKey(str) ? this.f63940g.f63932g.get(str) : "";
    }

    public int j() {
        return this.f63936c;
    }

    public int k() {
        return this.f63937d;
    }

    public String l(String str) {
        return this.f63940g.k.containsKey(str) ? this.f63940g.k.get(str) : "";
    }

    public int n() {
        return this.f63938e;
    }

    public int o() {
        return this.f63939f;
    }

    public int p() {
        return this.f63935b;
    }

    public int q(String str) {
        if (TextUtils.isEmpty(str) || !this.f63940g.f63931f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f63940g.f63931f.get(str));
    }

    public String r(String str) {
        return (TextUtils.isEmpty(str) || !this.f63940g.i.contains(str)) ? "0" : "1";
    }

    public String s(String str) {
        return this.f63940g.l.containsKey(str) ? this.f63940g.l.get(str) : "";
    }

    public void t(c cVar, Context context) {
        this.f63934a = context;
        this.f63935b = 360000;
        g0 e2 = g0.e();
        this.f63936c = e2.getInt("ubc_data_expire_time", 604800000);
        this.f63937d = e2.getInt("ubc_database_limit", 10000);
        cVar.n().q(this.f63940g);
        this.f63938e = e2.getInt("ubc_launch_upload_max_limit", 614400);
        this.f63939f = e2.getInt("ubc_single_log_max_limit", 153600);
    }

    public boolean u() {
        q uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.c();
        }
        return false;
    }

    public boolean v(String str) {
        HashMap<String, m> hashMap = this.f63940g.f63933h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63940g.f63933h.get(str).b();
    }

    public boolean w(String str) {
        HashMap<String, m> hashMap = this.f63940g.f63933h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63940g.f63933h.get(str).c();
    }

    public boolean x(String str) {
        Context context = this.f63934a;
        return context == null || y(context) || !c(str);
    }

    public boolean y(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean z(String str) {
        return this.f63940g.f63927b.contains(str);
    }
}
