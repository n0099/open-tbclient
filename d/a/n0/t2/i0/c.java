package d.a.n0.t2.i0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f64835a;

    /* renamed from: b  reason: collision with root package name */
    public String f64836b;

    /* renamed from: f  reason: collision with root package name */
    public String f64840f;

    /* renamed from: h  reason: collision with root package name */
    public String f64842h;

    /* renamed from: i  reason: collision with root package name */
    public int f64843i;
    public String j;
    public int k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public DownloadStaticsData q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;

    /* renamed from: c  reason: collision with root package name */
    public int f64837c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f64838d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f64839e = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f64841g = System.currentTimeMillis() / 1000;

    public void a(String str, String str2) {
        if (this.f64835a == null) {
            this.f64835a = new JSONObject();
        }
        try {
            this.f64835a.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f64838d != -1) {
                jSONObject.put("da_locate", this.f64838d);
            }
            if (this.f64837c != -1) {
                jSONObject.put("da_type", this.f64837c);
            }
            jSONObject.put("extra_param", this.f64836b);
            jSONObject.put("origin_time", this.f64841g);
            if (this.f64839e != -1) {
                jSONObject.put("da_page_num", this.f64839e);
            }
            jSONObject.put("da_price", this.f64842h);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            jSONObject.put("ext1", this.f64843i);
            jSONObject.put("ext3", this.k);
            jSONObject.put("ext2", this.j);
            jSONObject.put("da_ext1", this.l);
            jSONObject.put("da_ext2", this.m);
            jSONObject.put("da_ext3", this.n);
            jSONObject.put("da_ext4", this.o);
            jSONObject.put("da_ext5", this.p);
            jSONObject.put("da_menu1", this.s);
            jSONObject.put("da_menu2", this.t);
            jSONObject.put("da_menu3", this.u);
            jSONObject.put("da_page", this.v);
            jSONObject.put("place_id", this.f64840f);
            jSONObject.put("lego_extra", this.r);
            if (this.q != null) {
                jSONObject.put("da_range", this.q.getDa_range());
                jSONObject.put("da_range_nt", this.q.getDa_range_nt());
                jSONObject.put("da_page", this.q.getDa_page());
                jSONObject.put("da_menu3", this.q.getFid());
                jSONObject.put("apk_name", this.q.getApk_name());
            }
            jSONObject.put("da_area", this.w);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = this.f64835a;
        if (jSONObject2 != null) {
            try {
                jSONObject.put("ext", jSONObject2);
            } catch (Exception unused2) {
            }
        }
        return jSONObject;
    }

    public void c(String str) {
        this.w = str;
    }

    public void d(int i2) {
        this.f64838d = i2;
    }

    public void e(String str) {
        this.s = str;
    }

    public void f(String str) {
        this.t = str;
    }

    public void g(String str) {
        this.u = str;
    }

    public void h(String str) {
        this.v = str;
    }

    public void i(int i2) {
        this.f64837c = i2;
    }

    public void j(int i2) {
        this.l = String.valueOf(i2);
    }

    public void k(String str) {
        this.l = str;
    }

    public void l(int i2) {
        this.m = String.valueOf(i2);
    }

    public void m(int i2) {
        this.n = String.valueOf(i2);
    }

    public void n(int i2) {
        this.o = String.valueOf(i2);
    }

    public void o(String str) {
        this.o = str;
    }

    public void p(int i2) {
        this.p = String.valueOf(i2);
    }

    public void q(String str) {
        this.p = str;
    }

    public void r(DownloadStaticsData downloadStaticsData) {
        this.q = downloadStaticsData;
        if (downloadStaticsData != null) {
            this.f64838d = d.a.c.e.m.b.d(downloadStaticsData.getAdPosition(), 0);
            this.f64836b = downloadStaticsData.getExtensionInfo();
        }
    }

    public void s(String str) {
    }

    public void t(String str) {
        this.f64836b = str;
    }

    public void u(String str) {
        this.r = str;
    }

    public void v(int i2) {
        this.f64839e = i2;
    }

    public void w(String str) {
        this.f64840f = str;
    }
}
