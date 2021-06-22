package d.a.q0;

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

    /* renamed from: i  reason: collision with root package name */
    public static volatile g f68088i;

    /* renamed from: a  reason: collision with root package name */
    public Context f68089a;

    /* renamed from: b  reason: collision with root package name */
    public int f68090b;

    /* renamed from: c  reason: collision with root package name */
    public int f68091c;

    /* renamed from: d  reason: collision with root package name */
    public int f68092d;

    /* renamed from: e  reason: collision with root package name */
    public int f68093e = 614400;

    /* renamed from: f  reason: collision with root package name */
    public int f68094f = 153600;

    /* renamed from: g  reason: collision with root package name */
    public f f68095g = new f();

    /* renamed from: h  reason: collision with root package name */
    public e0 f68096h = new e0();

    public static g m() {
        if (f68088i == null) {
            synchronized (e.class) {
                if (f68088i == null) {
                    f68088i = new g();
                }
            }
        }
        return f68088i;
    }

    public void A(int i2) {
        if (i2 < this.f68091c) {
            return;
        }
        this.f68091c = i2;
        h0.e().putInt("ubc_data_expire_time", i2);
    }

    public void B(int i2) {
        if (i2 < this.f68092d) {
            return;
        }
        this.f68092d = i2;
        h0.e().putInt("ubc_database_limit", i2);
    }

    public void C(int i2) {
        if (i2 < 307200) {
            return;
        }
        this.f68093e = i2;
        h0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void D(int i2) {
        if (i2 < 30720) {
            return;
        }
        this.f68094f = i2;
        h0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void E(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.f68090b) {
            return;
        }
        this.f68090b = i3;
    }

    public void F(List<k> list) {
        for (k kVar : list) {
            String b2 = kVar.b();
            if (!TextUtils.isEmpty(b2)) {
                if ("0".equals(kVar.getSwitch())) {
                    this.f68095g.f68079a.add(b2);
                    this.f68095g.f68082d.remove(b2);
                } else {
                    this.f68095g.f68079a.remove(b2);
                    this.f68095g.f68082d.add(b2);
                }
                if ("1".equals(kVar.getIsReal())) {
                    this.f68095g.f68080b.add(b2);
                } else {
                    this.f68095g.f68080b.remove(b2);
                }
                if ("1".equals(kVar.getAbtest())) {
                    this.f68095g.f68081c.add(b2);
                } else {
                    this.f68095g.f68081c.remove(b2);
                }
                if ("1".equals(kVar.getNoCache())) {
                    this.f68095g.f68083e.add(b2);
                } else {
                    this.f68095g.f68083e.remove(b2);
                }
                if (kVar.f() >= 1 && kVar.f() <= 100) {
                    this.f68095g.f68084f.put(b2, String.valueOf(kVar.f()));
                } else {
                    this.f68095g.f68084f.remove(b2);
                }
                if (!TextUtils.isEmpty(kVar.a())) {
                    this.f68095g.f68085g.put(b2, kVar.a());
                } else {
                    this.f68095g.f68085g.remove(b2);
                }
                if (kVar.c() != 0 && kVar.d() != 0) {
                    m mVar = new m(b2, kVar.d(), kVar.c());
                    this.f68095g.f68086h.put(mVar.a(), mVar);
                }
                if (TextUtils.equals(kVar.getIdType(), "1")) {
                    this.f68095g.f68087i.add(b2);
                } else {
                    this.f68095g.f68087i.remove(b2);
                }
                if (TextUtils.equals(kVar.getReallog(), "1")) {
                    this.f68095g.j.add(b2);
                } else {
                    this.f68095g.j.remove(b2);
                }
                String gFlow = kVar.getGFlow();
                if (!TextUtils.isEmpty(gFlow) && !TextUtils.equals(gFlow, "0")) {
                    this.f68095g.k.put(b2, gFlow);
                } else {
                    this.f68095g.k.remove(b2);
                }
                String uploadType = kVar.getUploadType();
                if (!TextUtils.isEmpty(uploadType)) {
                    this.f68095g.l.put(b2, uploadType);
                } else {
                    this.f68095g.l.remove(b2);
                }
                int e2 = kVar.e();
                if (e2 != 2) {
                    this.f68095g.m.put(b2, Integer.valueOf(e2));
                } else {
                    this.f68095g.m.remove(b2);
                }
            }
        }
    }

    public boolean a(String str) {
        return this.f68095g.f68081c.contains(str);
    }

    public int b(String str) {
        Integer num;
        if (!this.f68095g.m.containsKey(str) || (num = this.f68095g.m.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }

    public boolean c(String str) {
        return this.f68095g.f68083e.contains(str);
    }

    public boolean d(String str) {
        return TextUtils.equals("0", s(str));
    }

    public boolean e(String str) {
        if (this.f68096h.isUBCDebug()) {
            return true;
        }
        return this.f68095g.f68080b.contains(str);
    }

    public boolean f(String str) {
        return this.f68095g.j.contains(str);
    }

    public boolean g(String str, int i2) {
        if (this.f68095g.f68079a.contains(str)) {
            return false;
        }
        return ((i2 & 16) == 0 && (i2 & 32) == 0) || this.f68095g.f68082d.contains(str);
    }

    public boolean h(String str) {
        if (!u() && this.f68096h.isUBCSample() && q(str) > 0) {
            if (new Random().nextInt(100) >= q(str)) {
                return true;
            }
        }
        return false;
    }

    public String i(String str) {
        return this.f68095g.f68085g.containsKey(str) ? this.f68095g.f68085g.get(str) : "";
    }

    public int j() {
        return this.f68091c;
    }

    public int k() {
        return this.f68092d;
    }

    public String l(String str) {
        return this.f68095g.k.containsKey(str) ? this.f68095g.k.get(str) : "";
    }

    public int n() {
        return this.f68093e;
    }

    public int o() {
        return this.f68094f;
    }

    public int p() {
        return this.f68090b;
    }

    public int q(String str) {
        if (TextUtils.isEmpty(str) || !this.f68095g.f68084f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f68095g.f68084f.get(str));
    }

    public String r(String str) {
        return (TextUtils.isEmpty(str) || !this.f68095g.f68087i.contains(str)) ? "0" : "1";
    }

    public String s(String str) {
        return this.f68095g.l.containsKey(str) ? this.f68095g.l.get(str) : "";
    }

    public void t(c cVar, Context context) {
        this.f68089a = context;
        this.f68090b = 360000;
        h0 e2 = h0.e();
        this.f68091c = e2.getInt("ubc_data_expire_time", 604800000);
        this.f68092d = e2.getInt("ubc_database_limit", 10000);
        cVar.n().q(this.f68095g);
        this.f68093e = e2.getInt("ubc_launch_upload_max_limit", 614400);
        this.f68094f = e2.getInt("ubc_single_log_max_limit", 153600);
    }

    public boolean u() {
        r uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.d();
        }
        return false;
    }

    public boolean v(String str) {
        HashMap<String, m> hashMap = this.f68095g.f68086h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f68095g.f68086h.get(str).b();
    }

    public boolean w(String str) {
        HashMap<String, m> hashMap = this.f68095g.f68086h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f68095g.f68086h.get(str).c();
    }

    public boolean x(String str) {
        Context context = this.f68089a;
        return context == null || y(context) || !c(str);
    }

    public boolean y(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean z(String str) {
        return this.f68095g.f68080b.contains(str);
    }
}
