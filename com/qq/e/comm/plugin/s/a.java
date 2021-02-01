package com.qq.e.comm.plugin.s;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.k;
import com.qq.e.comm.plugin.ad.s;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    protected boolean A;
    protected String B;
    protected int C = -1;
    protected int D = -1;
    protected int E;
    protected i F;
    protected com.qq.e.comm.plugin.ad.e G;
    protected JSONObject H;
    protected c I;
    private String J;
    private int K;
    private String L;
    private int M;
    private int N;
    private List<g> O;
    private List<g> P;
    private List<String> Q;
    private List<String> R;
    private boolean S;
    private k T;
    private String U;
    private String V;
    private int W;
    private String X;
    private s Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    protected String f12445a;
    private String aa;
    private e ab;

    /* renamed from: b  reason: collision with root package name */
    protected String f12446b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;
    protected String i;
    protected int j;
    protected String k;
    protected String l;
    protected String m;
    protected boolean n;
    protected boolean o;
    protected String p;
    protected j q;
    protected String r;
    protected int s;
    protected String t;
    protected float u;
    protected float v;
    protected float w;
    protected float x;
    protected String y;
    protected String z;

    public a() {
    }

    public a(String str, String str2, String str3, com.qq.e.comm.plugin.ad.e eVar) {
        this.y = str;
        this.B = str2;
        this.z = str3;
        this.G = eVar;
    }

    private void a() {
        this.ab = new e(this.H.optJSONObject("posCfg"));
    }

    public static int d(JSONObject jSONObject) {
        return jSONObject.optInt("ecpm", -1);
    }

    private void d(boolean z) {
        this.Z = z;
    }

    public static int e(JSONObject jSONObject) {
        int i = -1;
        String optString = jSONObject.optString("mp");
        if (!TextUtils.isEmpty(optString)) {
            try {
                i = Integer.valueOf(new String(aq.b(Base64.decode(optString, 0)), com.qq.e.comm.plugin.f.a.f11992a)).intValue();
            } catch (aq.b e) {
                e.printStackTrace();
            }
        }
        GDTLogger.d("ad response mp origin value: " + optString + " decryption value: " + i);
        return i;
    }

    public static boolean f(JSONObject jSONObject) {
        return i(jSONObject.optInt("buyingtype", 1));
    }

    public static s h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new s(jSONObject.optString("wxappid"), jSONObject.optJSONObject("wechat_ad_trace_data"), jSONObject.optString("wechat_app_username"), jSONObject.optString("wechat_app_path"), jSONObject.optString("wechat_app_token"));
    }

    private static boolean i(int i) {
        return i != 1;
    }

    public String A() {
        return this.l;
    }

    public String B() {
        return this.B;
    }

    public com.qq.e.comm.plugin.ad.e C() {
        return this.G;
    }

    public String D() {
        return this.z;
    }

    public JSONObject E() {
        return this.H;
    }

    public int F() {
        return this.K;
    }

    public String G() {
        return this.L;
    }

    public String H() {
        return this.m;
    }

    public int I() {
        return this.C;
    }

    public String J() {
        return this.J;
    }

    public int K() {
        return this.D;
    }

    public boolean L() {
        return i(this.E);
    }

    public String M() {
        return this.h;
    }

    public String N() {
        return this.f;
    }

    public int O() {
        if (this.F != null) {
            return this.F.a();
        }
        return -1;
    }

    public int P() {
        return this.M;
    }

    public int Q() {
        return this.N;
    }

    public List<g> R() {
        return this.O;
    }

    public List<g> S() {
        return this.P;
    }

    public List<String> T() {
        return this.Q;
    }

    public List<String> U() {
        return this.R;
    }

    public void V() {
        if (this.O == null || this.O.size() <= 0) {
            return;
        }
        for (g gVar : this.O) {
            if (gVar != null) {
                af.a(gVar.a());
            }
        }
    }

    public void W() {
        if (this.P == null || this.P.size() <= 0) {
            return;
        }
        for (g gVar : this.P) {
            if (gVar != null) {
                aa.a(gVar.a());
            }
        }
    }

    public void X() {
        if (this.Q == null || this.Q.size() <= 0) {
            return;
        }
        for (String str : this.Q) {
            af.a(str);
        }
    }

    public void Y() {
        if (this.R == null || this.R.size() <= 0) {
            return;
        }
        for (String str : this.R) {
            aa.a(str);
        }
    }

    public e Z() {
        return this.ab;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(com.qq.e.comm.plugin.ad.e eVar) {
        this.G = eVar;
    }

    public void a(j jVar) {
        this.q = jVar;
    }

    public void a(k kVar) {
        this.T = kVar;
    }

    public void a(s sVar) {
        this.Y = sVar;
    }

    public void a(i iVar) {
        this.F = iVar;
    }

    public void a(List<g> list) {
        this.O = list;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public int a_() {
        return this.j;
    }

    public boolean aa() {
        return this.S;
    }

    public k ab() {
        return this.T;
    }

    public String ac() {
        return this.U;
    }

    public String ad() {
        return this.V;
    }

    public int ae() {
        return this.W;
    }

    public String af() {
        return this.X;
    }

    public s ag() {
        return this.Y;
    }

    public boolean ah() {
        return Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(G());
    }

    public boolean ai() {
        return this.Z;
    }

    public String aj() {
        return this.aa;
    }

    public void b(int i) {
        this.K = i;
    }

    public void b(String str) {
        this.f12445a = str;
    }

    public void b(List<g> list) {
        this.P = list;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.I = new c(jSONObject);
        }
    }

    public void b(boolean z) {
        this.o = z;
    }

    public void c(int i) {
        this.C = i;
    }

    public void c(String str) {
        this.f12446b = str;
    }

    public void c(List<String> list) {
        this.Q = list;
    }

    public void c(JSONObject jSONObject) {
        this.H = jSONObject;
    }

    public void c(boolean z) {
        this.S = z;
    }

    public void d(int i) {
        this.D = i;
    }

    public void d(String str) {
        this.c = str;
    }

    public void d(List<String> list) {
        this.R = list;
    }

    public void e(int i) {
        this.E = i;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(int i) {
        this.M = i;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(int i) {
        this.N = i;
    }

    public void g(String str) {
        this.f = str;
    }

    public void g(JSONObject jSONObject) {
        int i = -1;
        if (jSONObject == null) {
            return;
        }
        c(jSONObject);
        b(jSONObject.optString(Config.CELL_LOCATION));
        c(jSONObject.optString(DocumentOpenUtil.TXT));
        d(jSONObject.optString("desc"));
        e(jSONObject.optString("img"));
        f(jSONObject.optString("img2"));
        g(jSONObject.optString("apurl"));
        h(jSONObject.optString("v_apurl"));
        i(jSONObject.optString("rl"));
        j(jSONObject.optString("customizedpingurl"));
        a(jSONObject.optInt("producttype"));
        p(jSONObject.optString("traceid"));
        n(jSONObject.optString("landing_page_report_url"));
        b(jSONObject.optJSONObject("component"));
        String optString = jSONObject.optString(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO);
        c(jSONObject.optInt("ecpm", -1));
        String optString2 = jSONObject.optString("mp");
        if (!TextUtils.isEmpty(optString2)) {
            try {
                i = Integer.valueOf(new String(aq.b(Base64.decode(optString2, 0)), com.qq.e.comm.plugin.f.a.f11992a)).intValue();
            } catch (aq.b e) {
                e.printStackTrace();
            }
        }
        GDTLogger.d("ad response mp origin value: " + optString2 + " decryption value: " + i);
        d(i);
        q(jSONObject.optString("ecpm_level"));
        e(jSONObject.optInt("buyingtype", 1));
        if (!TextUtils.isEmpty(optString)) {
            k(optString.replace("__ACT_TYPE__", "2001"));
        }
        a(com.qq.e.comm.plugin.util.d.a(jSONObject));
        if (v()) {
            a(com.qq.e.comm.plugin.util.d.d(jSONObject));
        }
        b(com.qq.e.comm.plugin.util.d.b(jSONObject));
        l(jSONObject.optString("template_id"));
        m(jSONObject.optString("video_tracking_url"));
        a(i.a(jSONObject));
        b(jSONObject.optInt(FuFaceItem.JK_SUB_TYPE));
        o(jSONObject.optString("video"));
        f(jSONObject.optInt("video_width"));
        g(jSONObject.optInt("video_height"));
        a(g.a(jSONObject.optJSONArray("report_url")));
        b(g.a(jSONObject.optJSONArray("report_url_sdk")));
        c(d.a(jSONObject.optJSONArray("click_mo_url")));
        d(d.a(jSONObject.optJSONArray("click_mo_url_sdk")));
        a(q.a(jSONObject));
        r(jSONObject.optString("video_widget_url"));
        s(jSONObject.optString("button_txt"));
        h(jSONObject.optInt("mini_program_type"));
        t(jSONObject.optString("customized_invoke_url"));
        a(h(jSONObject));
        d(jSONObject.optInt("app_store") == 1);
        u(jSONObject.optString("productid"));
        a();
    }

    public void h(int i) {
        this.W = i;
    }

    public void h(String str) {
        this.g = str;
    }

    public String i() {
        return this.c;
    }

    public void i(String str) {
        this.h = str;
    }

    public void j(String str) {
        this.i = str;
    }

    public void k(String str) {
        this.k = str;
    }

    public c l() {
        return this.I;
    }

    public void l(String str) {
        this.p = str;
    }

    public String m() {
        return this.f12445a;
    }

    public void m(String str) {
        this.r = str;
    }

    public String n() {
        return this.f12446b;
    }

    public void n(String str) {
        this.l = str;
    }

    public String o() {
        return this.d;
    }

    public void o(String str) {
        this.L = str;
    }

    public String p() {
        return this.e;
    }

    public void p(String str) {
        this.m = str;
    }

    public String q() {
        return this.f;
    }

    public void q(String str) {
        this.J = str;
    }

    public String r() {
        return this.g;
    }

    public void r(String str) {
        this.U = str;
    }

    public String s() {
        return this.h;
    }

    public void s(String str) {
        this.V = str;
    }

    public String t() {
        return this.i;
    }

    public void t(String str) {
        this.X = str;
    }

    public String toString() {
        return "BaseAdInfo{cl='" + this.f12445a + "', txt='" + this.f12446b + "', desc='" + this.c + "', img='" + this.d + "', apurl='" + this.f + "', customizedpingurl='" + this.i + "', negative_feedback_url='" + this.k + "', isAppAd=" + this.n + ", appInfo=" + (this.q != null ? this.q.toString() : "") + ", duration=" + this.s + ", background_url='" + this.t + "', leftPadding=" + this.u + ", topPadding=" + this.v + ", widthRatio=" + this.w + ", heightRatio=" + this.x + ", hideDescVertical=" + this.A + ", appId=" + this.y + ", posId=" + this.B + ", adThreadId=" + this.z + ", adJson=" + this.H + ", adType=" + this.G + ", sspExt=" + (this.F != null ? this.F.toString() : "") + '}';
    }

    public String u() {
        return this.k;
    }

    public void u(String str) {
        this.aa = str;
    }

    public boolean v() {
        return this.n;
    }

    public boolean w() {
        return this.o;
    }

    public String x() {
        return this.p;
    }

    public String y() {
        return this.r;
    }

    public j z() {
        return this.q;
    }
}
