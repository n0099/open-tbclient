package d.a.p0;

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
    public static volatile g f63956i;

    /* renamed from: a  reason: collision with root package name */
    public Context f63957a;

    /* renamed from: b  reason: collision with root package name */
    public int f63958b;

    /* renamed from: c  reason: collision with root package name */
    public int f63959c;

    /* renamed from: d  reason: collision with root package name */
    public int f63960d;

    /* renamed from: e  reason: collision with root package name */
    public int f63961e = 614400;

    /* renamed from: f  reason: collision with root package name */
    public int f63962f = 153600;

    /* renamed from: g  reason: collision with root package name */
    public f f63963g = new f();

    /* renamed from: h  reason: collision with root package name */
    public e0 f63964h = new e0();

    public static g m() {
        if (f63956i == null) {
            synchronized (e.class) {
                if (f63956i == null) {
                    f63956i = new g();
                }
            }
        }
        return f63956i;
    }

    public void A(int i2) {
        if (i2 < this.f63959c) {
            return;
        }
        this.f63959c = i2;
        h0.e().putInt("ubc_data_expire_time", i2);
    }

    public void B(int i2) {
        if (i2 < this.f63960d) {
            return;
        }
        this.f63960d = i2;
        h0.e().putInt("ubc_database_limit", i2);
    }

    public void C(int i2) {
        if (i2 < 307200) {
            return;
        }
        this.f63961e = i2;
        h0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void D(int i2) {
        if (i2 < 30720) {
            return;
        }
        this.f63962f = i2;
        h0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void E(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.f63958b) {
            return;
        }
        this.f63958b = i3;
    }

    public void F(List<k> list) {
        for (k kVar : list) {
            String b2 = kVar.b();
            if (!TextUtils.isEmpty(b2)) {
                if ("0".equals(kVar.getSwitch())) {
                    this.f63963g.f63947a.add(b2);
                    this.f63963g.f63950d.remove(b2);
                } else {
                    this.f63963g.f63947a.remove(b2);
                    this.f63963g.f63950d.add(b2);
                }
                if ("1".equals(kVar.getIsReal())) {
                    this.f63963g.f63948b.add(b2);
                } else {
                    this.f63963g.f63948b.remove(b2);
                }
                if ("1".equals(kVar.getAbtest())) {
                    this.f63963g.f63949c.add(b2);
                } else {
                    this.f63963g.f63949c.remove(b2);
                }
                if ("1".equals(kVar.getNoCache())) {
                    this.f63963g.f63951e.add(b2);
                } else {
                    this.f63963g.f63951e.remove(b2);
                }
                if (kVar.f() >= 1 && kVar.f() <= 100) {
                    this.f63963g.f63952f.put(b2, String.valueOf(kVar.f()));
                } else {
                    this.f63963g.f63952f.remove(b2);
                }
                if (!TextUtils.isEmpty(kVar.a())) {
                    this.f63963g.f63953g.put(b2, kVar.a());
                } else {
                    this.f63963g.f63953g.remove(b2);
                }
                if (kVar.c() != 0 && kVar.d() != 0) {
                    m mVar = new m(b2, kVar.d(), kVar.c());
                    this.f63963g.f63954h.put(mVar.a(), mVar);
                }
                if (TextUtils.equals(kVar.getIdType(), "1")) {
                    this.f63963g.f63955i.add(b2);
                } else {
                    this.f63963g.f63955i.remove(b2);
                }
                if (TextUtils.equals(kVar.getReallog(), "1")) {
                    this.f63963g.j.add(b2);
                } else {
                    this.f63963g.j.remove(b2);
                }
                String gFlow = kVar.getGFlow();
                if (!TextUtils.isEmpty(gFlow) && !TextUtils.equals(gFlow, "0")) {
                    this.f63963g.k.put(b2, gFlow);
                } else {
                    this.f63963g.k.remove(b2);
                }
                String uploadType = kVar.getUploadType();
                if (!TextUtils.isEmpty(uploadType)) {
                    this.f63963g.l.put(b2, uploadType);
                } else {
                    this.f63963g.l.remove(b2);
                }
                int e2 = kVar.e();
                if (e2 != 2) {
                    this.f63963g.m.put(b2, Integer.valueOf(e2));
                } else {
                    this.f63963g.m.remove(b2);
                }
            }
        }
    }

    public boolean a(String str) {
        return this.f63963g.f63949c.contains(str);
    }

    public int b(String str) {
        Integer num;
        if (!this.f63963g.m.containsKey(str) || (num = this.f63963g.m.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }

    public boolean c(String str) {
        return this.f63963g.f63951e.contains(str);
    }

    public boolean d(String str) {
        return TextUtils.equals("0", s(str));
    }

    public boolean e(String str) {
        if (this.f63964h.isUBCDebug()) {
            return true;
        }
        return this.f63963g.f63948b.contains(str);
    }

    public boolean f(String str) {
        return this.f63963g.j.contains(str);
    }

    public boolean g(String str, int i2) {
        if (this.f63963g.f63947a.contains(str)) {
            return false;
        }
        return ((i2 & 16) == 0 && (i2 & 32) == 0) || this.f63963g.f63950d.contains(str);
    }

    public boolean h(String str) {
        if (!u() && this.f63964h.isUBCSample() && q(str) > 0) {
            if (new Random().nextInt(100) >= q(str)) {
                return true;
            }
        }
        return false;
    }

    public String i(String str) {
        return this.f63963g.f63953g.containsKey(str) ? this.f63963g.f63953g.get(str) : "";
    }

    public int j() {
        return this.f63959c;
    }

    public int k() {
        return this.f63960d;
    }

    public String l(String str) {
        return this.f63963g.k.containsKey(str) ? this.f63963g.k.get(str) : "";
    }

    public int n() {
        return this.f63961e;
    }

    public int o() {
        return this.f63962f;
    }

    public int p() {
        return this.f63958b;
    }

    public int q(String str) {
        if (TextUtils.isEmpty(str) || !this.f63963g.f63952f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f63963g.f63952f.get(str));
    }

    public String r(String str) {
        return (TextUtils.isEmpty(str) || !this.f63963g.f63955i.contains(str)) ? "0" : "1";
    }

    public String s(String str) {
        return this.f63963g.l.containsKey(str) ? this.f63963g.l.get(str) : "";
    }

    public void t(c cVar, Context context) {
        this.f63957a = context;
        this.f63958b = 360000;
        h0 e2 = h0.e();
        this.f63959c = e2.getInt("ubc_data_expire_time", 604800000);
        this.f63960d = e2.getInt("ubc_database_limit", 10000);
        cVar.n().q(this.f63963g);
        this.f63961e = e2.getInt("ubc_launch_upload_max_limit", 614400);
        this.f63962f = e2.getInt("ubc_single_log_max_limit", 153600);
    }

    public boolean u() {
        r uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.d();
        }
        return false;
    }

    public boolean v(String str) {
        HashMap<String, m> hashMap = this.f63963g.f63954h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63963g.f63954h.get(str).b();
    }

    public boolean w(String str) {
        HashMap<String, m> hashMap = this.f63963g.f63954h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63963g.f63954h.get(str).c();
    }

    public boolean x(String str) {
        Context context = this.f63957a;
        return context == null || y(context) || !c(str);
    }

    public boolean y(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean z(String str) {
        return this.f63963g.f63948b.contains(str);
    }
}
