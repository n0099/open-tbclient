package d.a.l0;

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
    public static volatile g f63219i;

    /* renamed from: a  reason: collision with root package name */
    public Context f63220a;

    /* renamed from: b  reason: collision with root package name */
    public int f63221b;

    /* renamed from: c  reason: collision with root package name */
    public int f63222c;

    /* renamed from: d  reason: collision with root package name */
    public int f63223d;

    /* renamed from: e  reason: collision with root package name */
    public int f63224e = 614400;

    /* renamed from: f  reason: collision with root package name */
    public int f63225f = 153600;

    /* renamed from: g  reason: collision with root package name */
    public f f63226g = new f();

    /* renamed from: h  reason: collision with root package name */
    public e0 f63227h = new e0();

    public static g m() {
        if (f63219i == null) {
            synchronized (e.class) {
                if (f63219i == null) {
                    f63219i = new g();
                }
            }
        }
        return f63219i;
    }

    public void A(int i2) {
        if (i2 < this.f63222c) {
            return;
        }
        this.f63222c = i2;
        h0.e().putInt("ubc_data_expire_time", i2);
    }

    public void B(int i2) {
        if (i2 < this.f63223d) {
            return;
        }
        this.f63223d = i2;
        h0.e().putInt("ubc_database_limit", i2);
    }

    public void C(int i2) {
        if (i2 < 307200) {
            return;
        }
        this.f63224e = i2;
        h0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void D(int i2) {
        if (i2 < 30720) {
            return;
        }
        this.f63225f = i2;
        h0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void E(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.f63221b) {
            return;
        }
        this.f63221b = i3;
    }

    public void F(List<k> list) {
        for (k kVar : list) {
            String b2 = kVar.b();
            if (!TextUtils.isEmpty(b2)) {
                if ("0".equals(kVar.getSwitch())) {
                    this.f63226g.f63210a.add(b2);
                    this.f63226g.f63213d.remove(b2);
                } else {
                    this.f63226g.f63210a.remove(b2);
                    this.f63226g.f63213d.add(b2);
                }
                if ("1".equals(kVar.getIsReal())) {
                    this.f63226g.f63211b.add(b2);
                } else {
                    this.f63226g.f63211b.remove(b2);
                }
                if ("1".equals(kVar.getAbtest())) {
                    this.f63226g.f63212c.add(b2);
                } else {
                    this.f63226g.f63212c.remove(b2);
                }
                if ("1".equals(kVar.getNoCache())) {
                    this.f63226g.f63214e.add(b2);
                } else {
                    this.f63226g.f63214e.remove(b2);
                }
                if (kVar.f() >= 1 && kVar.f() <= 100) {
                    this.f63226g.f63215f.put(b2, String.valueOf(kVar.f()));
                } else {
                    this.f63226g.f63215f.remove(b2);
                }
                if (!TextUtils.isEmpty(kVar.a())) {
                    this.f63226g.f63216g.put(b2, kVar.a());
                } else {
                    this.f63226g.f63216g.remove(b2);
                }
                if (kVar.c() != 0 && kVar.d() != 0) {
                    m mVar = new m(b2, kVar.d(), kVar.c());
                    this.f63226g.f63217h.put(mVar.a(), mVar);
                }
                if (TextUtils.equals(kVar.getIdType(), "1")) {
                    this.f63226g.f63218i.add(b2);
                } else {
                    this.f63226g.f63218i.remove(b2);
                }
                if (TextUtils.equals(kVar.getReallog(), "1")) {
                    this.f63226g.j.add(b2);
                } else {
                    this.f63226g.j.remove(b2);
                }
                String gFlow = kVar.getGFlow();
                if (!TextUtils.isEmpty(gFlow) && !TextUtils.equals(gFlow, "0")) {
                    this.f63226g.k.put(b2, gFlow);
                } else {
                    this.f63226g.k.remove(b2);
                }
                String uploadType = kVar.getUploadType();
                if (!TextUtils.isEmpty(uploadType)) {
                    this.f63226g.l.put(b2, uploadType);
                } else {
                    this.f63226g.l.remove(b2);
                }
                int e2 = kVar.e();
                if (e2 != 2) {
                    this.f63226g.m.put(b2, Integer.valueOf(e2));
                } else {
                    this.f63226g.m.remove(b2);
                }
            }
        }
    }

    public boolean a(String str) {
        return this.f63226g.f63212c.contains(str);
    }

    public int b(String str) {
        Integer num;
        if (!this.f63226g.m.containsKey(str) || (num = this.f63226g.m.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }

    public boolean c(String str) {
        return this.f63226g.f63214e.contains(str);
    }

    public boolean d(String str) {
        return TextUtils.equals("0", s(str));
    }

    public boolean e(String str) {
        if (this.f63227h.isUBCDebug()) {
            return true;
        }
        return this.f63226g.f63211b.contains(str);
    }

    public boolean f(String str) {
        return this.f63226g.j.contains(str);
    }

    public boolean g(String str, int i2) {
        if (this.f63226g.f63210a.contains(str)) {
            return false;
        }
        return ((i2 & 16) == 0 && (i2 & 32) == 0) || this.f63226g.f63213d.contains(str);
    }

    public boolean h(String str) {
        if (!u() && this.f63227h.isUBCSample() && q(str) > 0) {
            if (new Random().nextInt(100) >= q(str)) {
                return true;
            }
        }
        return false;
    }

    public String i(String str) {
        return this.f63226g.f63216g.containsKey(str) ? this.f63226g.f63216g.get(str) : "";
    }

    public int j() {
        return this.f63222c;
    }

    public int k() {
        return this.f63223d;
    }

    public String l(String str) {
        return this.f63226g.k.containsKey(str) ? this.f63226g.k.get(str) : "";
    }

    public int n() {
        return this.f63224e;
    }

    public int o() {
        return this.f63225f;
    }

    public int p() {
        return this.f63221b;
    }

    public int q(String str) {
        if (TextUtils.isEmpty(str) || !this.f63226g.f63215f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f63226g.f63215f.get(str));
    }

    public String r(String str) {
        return (TextUtils.isEmpty(str) || !this.f63226g.f63218i.contains(str)) ? "0" : "1";
    }

    public String s(String str) {
        return this.f63226g.l.containsKey(str) ? this.f63226g.l.get(str) : "";
    }

    public void t(c cVar, Context context) {
        this.f63220a = context;
        this.f63221b = 360000;
        h0 e2 = h0.e();
        this.f63222c = e2.getInt("ubc_data_expire_time", 604800000);
        this.f63223d = e2.getInt("ubc_database_limit", 10000);
        cVar.n().q(this.f63226g);
        this.f63224e = e2.getInt("ubc_launch_upload_max_limit", 614400);
        this.f63225f = e2.getInt("ubc_single_log_max_limit", 153600);
    }

    public boolean u() {
        r uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.d();
        }
        return false;
    }

    public boolean v(String str) {
        HashMap<String, m> hashMap = this.f63226g.f63217h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63226g.f63217h.get(str).b();
    }

    public boolean w(String str) {
        HashMap<String, m> hashMap = this.f63226g.f63217h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63226g.f63217h.get(str).c();
    }

    public boolean x(String str) {
        Context context = this.f63220a;
        return context == null || y(context) || !c(str);
    }

    public boolean y(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean z(String str) {
        return this.f63226g.f63211b.contains(str);
    }
}
