package d.a.m0;

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
    public static volatile g f63943i;

    /* renamed from: a  reason: collision with root package name */
    public Context f63944a;

    /* renamed from: b  reason: collision with root package name */
    public int f63945b;

    /* renamed from: c  reason: collision with root package name */
    public int f63946c;

    /* renamed from: d  reason: collision with root package name */
    public int f63947d;

    /* renamed from: e  reason: collision with root package name */
    public int f63948e = 614400;

    /* renamed from: f  reason: collision with root package name */
    public int f63949f = 153600;

    /* renamed from: g  reason: collision with root package name */
    public f f63950g = new f();

    /* renamed from: h  reason: collision with root package name */
    public e0 f63951h = new e0();

    public static g m() {
        if (f63943i == null) {
            synchronized (e.class) {
                if (f63943i == null) {
                    f63943i = new g();
                }
            }
        }
        return f63943i;
    }

    public void A(int i2) {
        if (i2 < this.f63946c) {
            return;
        }
        this.f63946c = i2;
        h0.e().putInt("ubc_data_expire_time", i2);
    }

    public void B(int i2) {
        if (i2 < this.f63947d) {
            return;
        }
        this.f63947d = i2;
        h0.e().putInt("ubc_database_limit", i2);
    }

    public void C(int i2) {
        if (i2 < 307200) {
            return;
        }
        this.f63948e = i2;
        h0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void D(int i2) {
        if (i2 < 30720) {
            return;
        }
        this.f63949f = i2;
        h0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void E(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.f63945b) {
            return;
        }
        this.f63945b = i3;
    }

    public void F(List<k> list) {
        for (k kVar : list) {
            String b2 = kVar.b();
            if (!TextUtils.isEmpty(b2)) {
                if ("0".equals(kVar.getSwitch())) {
                    this.f63950g.f63934a.add(b2);
                    this.f63950g.f63937d.remove(b2);
                } else {
                    this.f63950g.f63934a.remove(b2);
                    this.f63950g.f63937d.add(b2);
                }
                if ("1".equals(kVar.getIsReal())) {
                    this.f63950g.f63935b.add(b2);
                } else {
                    this.f63950g.f63935b.remove(b2);
                }
                if ("1".equals(kVar.getAbtest())) {
                    this.f63950g.f63936c.add(b2);
                } else {
                    this.f63950g.f63936c.remove(b2);
                }
                if ("1".equals(kVar.getNoCache())) {
                    this.f63950g.f63938e.add(b2);
                } else {
                    this.f63950g.f63938e.remove(b2);
                }
                if (kVar.f() >= 1 && kVar.f() <= 100) {
                    this.f63950g.f63939f.put(b2, String.valueOf(kVar.f()));
                } else {
                    this.f63950g.f63939f.remove(b2);
                }
                if (!TextUtils.isEmpty(kVar.a())) {
                    this.f63950g.f63940g.put(b2, kVar.a());
                } else {
                    this.f63950g.f63940g.remove(b2);
                }
                if (kVar.c() != 0 && kVar.d() != 0) {
                    m mVar = new m(b2, kVar.d(), kVar.c());
                    this.f63950g.f63941h.put(mVar.a(), mVar);
                }
                if (TextUtils.equals(kVar.getIdType(), "1")) {
                    this.f63950g.f63942i.add(b2);
                } else {
                    this.f63950g.f63942i.remove(b2);
                }
                if (TextUtils.equals(kVar.getReallog(), "1")) {
                    this.f63950g.j.add(b2);
                } else {
                    this.f63950g.j.remove(b2);
                }
                String gFlow = kVar.getGFlow();
                if (!TextUtils.isEmpty(gFlow) && !TextUtils.equals(gFlow, "0")) {
                    this.f63950g.k.put(b2, gFlow);
                } else {
                    this.f63950g.k.remove(b2);
                }
                String uploadType = kVar.getUploadType();
                if (!TextUtils.isEmpty(uploadType)) {
                    this.f63950g.l.put(b2, uploadType);
                } else {
                    this.f63950g.l.remove(b2);
                }
                int e2 = kVar.e();
                if (e2 != 2) {
                    this.f63950g.m.put(b2, Integer.valueOf(e2));
                } else {
                    this.f63950g.m.remove(b2);
                }
            }
        }
    }

    public boolean a(String str) {
        return this.f63950g.f63936c.contains(str);
    }

    public int b(String str) {
        Integer num;
        if (!this.f63950g.m.containsKey(str) || (num = this.f63950g.m.get(str)) == null) {
            return 2;
        }
        return num.intValue();
    }

    public boolean c(String str) {
        return this.f63950g.f63938e.contains(str);
    }

    public boolean d(String str) {
        return TextUtils.equals("0", s(str));
    }

    public boolean e(String str) {
        if (this.f63951h.isUBCDebug()) {
            return true;
        }
        return this.f63950g.f63935b.contains(str);
    }

    public boolean f(String str) {
        return this.f63950g.j.contains(str);
    }

    public boolean g(String str, int i2) {
        if (this.f63950g.f63934a.contains(str)) {
            return false;
        }
        return ((i2 & 16) == 0 && (i2 & 32) == 0) || this.f63950g.f63937d.contains(str);
    }

    public boolean h(String str) {
        if (!u() && this.f63951h.isUBCSample() && q(str) > 0) {
            if (new Random().nextInt(100) >= q(str)) {
                return true;
            }
        }
        return false;
    }

    public String i(String str) {
        return this.f63950g.f63940g.containsKey(str) ? this.f63950g.f63940g.get(str) : "";
    }

    public int j() {
        return this.f63946c;
    }

    public int k() {
        return this.f63947d;
    }

    public String l(String str) {
        return this.f63950g.k.containsKey(str) ? this.f63950g.k.get(str) : "";
    }

    public int n() {
        return this.f63948e;
    }

    public int o() {
        return this.f63949f;
    }

    public int p() {
        return this.f63945b;
    }

    public int q(String str) {
        if (TextUtils.isEmpty(str) || !this.f63950g.f63939f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f63950g.f63939f.get(str));
    }

    public String r(String str) {
        return (TextUtils.isEmpty(str) || !this.f63950g.f63942i.contains(str)) ? "0" : "1";
    }

    public String s(String str) {
        return this.f63950g.l.containsKey(str) ? this.f63950g.l.get(str) : "";
    }

    public void t(c cVar, Context context) {
        this.f63944a = context;
        this.f63945b = 360000;
        h0 e2 = h0.e();
        this.f63946c = e2.getInt("ubc_data_expire_time", 604800000);
        this.f63947d = e2.getInt("ubc_database_limit", 10000);
        cVar.n().q(this.f63950g);
        this.f63948e = e2.getInt("ubc_launch_upload_max_limit", 614400);
        this.f63949f = e2.getInt("ubc_single_log_max_limit", 153600);
    }

    public boolean u() {
        r uBCContext = UBC.getUBCContext();
        if (uBCContext != null) {
            return uBCContext.d();
        }
        return false;
    }

    public boolean v(String str) {
        HashMap<String, m> hashMap = this.f63950g.f63941h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63950g.f63941h.get(str).b();
    }

    public boolean w(String str) {
        HashMap<String, m> hashMap = this.f63950g.f63941h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f63950g.f63941h.get(str).c();
    }

    public boolean x(String str) {
        Context context = this.f63944a;
        return context == null || y(context) || !c(str);
    }

    public boolean y(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean z(String str) {
        return this.f63950g.f63935b.contains(str);
    }
}
