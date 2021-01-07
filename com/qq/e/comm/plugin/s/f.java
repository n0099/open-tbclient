package com.qq.e.comm.plugin.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends a {
    private int J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private String Q;
    private int R;
    private boolean S;
    private int T;
    private String U;
    private List<h> V;
    private String W;
    private String X;
    private String Y;
    private int Z;
    private f aa;
    private String ab;
    private Boolean ac;
    private long ad;
    private int ae;
    private int af;
    private boolean ag;

    public f(String str, String str2, String str3, com.qq.e.comm.plugin.ad.e eVar) {
        super(str, str2, str3, eVar);
        this.ad = -1L;
        this.ae = -1;
        this.af = -1;
    }

    @Override // com.qq.e.comm.plugin.s.a
    public boolean L() {
        return this.ag;
    }

    @Override // com.qq.e.comm.plugin.s.a
    public int O() {
        return this.af;
    }

    public int a() {
        return this.J;
    }

    public void a(long j) {
        this.ad = j;
    }

    public void a(f fVar) {
        this.aa = fVar;
    }

    public void a(String str) {
        this.Q = str;
    }

    public void a(JSONObject jSONObject) {
        boolean z = true;
        this.ac = Boolean.valueOf((jSONObject == null || jSONObject.optInt(com.baidu.fsg.face.base.b.c.l) != 1) ? false : false);
    }

    public String ak() {
        return this.X;
    }

    public String al() {
        return this.Y;
    }

    public f am() {
        return this.aa;
    }

    public String an() {
        return this.ab;
    }

    public long ao() {
        return this.ad;
    }

    public Boolean ap() {
        return this.ac;
    }

    public int aq() {
        return this.ae;
    }

    public void b(f fVar) {
        if (fVar != null) {
            try {
                if (!TextUtils.isEmpty(fVar.q())) {
                    this.f = fVar.q();
                    this.H.put("apurl", this.f);
                }
                if (TextUtils.isEmpty(fVar.s())) {
                    return;
                }
                this.h = fVar.s();
                this.H.put("rl", this.h);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean c() {
        return this.K;
    }

    public void d(boolean z) {
        this.K = z;
    }

    public boolean d() {
        return this.O;
    }

    public void e(List<h> list) {
        this.V = list;
    }

    public void e(boolean z) {
        this.O = z;
    }

    public boolean e() {
        return this.P;
    }

    public String f() {
        return this.Q;
    }

    public void f(boolean z) {
        this.P = z;
    }

    public int g() {
        return this.R;
    }

    @Override // com.qq.e.comm.plugin.s.a
    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ad = SystemClock.elapsedRealtime();
        super.g(jSONObject);
        i(jSONObject.optInt(IXAdRequestInfo.CELL_ID));
        d(jSONObject.optInt("is_contract") == 1);
        j(jSONObject.optInt("pv_fcs"));
        k(jSONObject.optInt("pv_limit"));
        l(jSONObject.optInt("price_mode"));
        e(jSONObject.optInt("need_empty_report") == 1);
        f(jSONObject.optInt("is_empty") == 1);
        a(jSONObject.optString("uoid"));
        m(jSONObject.optInt("rot_index", -1));
        g(jSONObject.optInt("offlinestop") == 1);
        n(jSONObject.optInt("timelife"));
        v(jSONObject.optString("ad_icon"));
        e(h.a(jSONObject.optJSONArray("slot")));
        w(jSONObject.optString("video_md5"));
        a(jSONObject.optJSONObject("open_mini_program"));
        y(jSONObject.optString("joint_loc"));
        x(jSONObject.optString("joint_uoid"));
        o(jSONObject.optInt("oneshot_report_type"));
        p(jSONObject.optInt("banner_start_time", -1));
        this.af = i.b(jSONObject);
        this.ag = a.f(jSONObject);
    }

    public void g(boolean z) {
        this.S = z;
    }

    public int h() {
        return this.T;
    }

    public void i(int i) {
        this.J = i;
    }

    public List<h> j() {
        return this.V;
    }

    public void j(int i) {
        this.L = i;
    }

    public String k() {
        return this.W;
    }

    public void k(int i) {
        this.M = i;
    }

    public void l(int i) {
        this.N = i;
    }

    public void m(int i) {
        this.R = i;
    }

    public void n(int i) {
        this.T = i;
    }

    public void o(int i) {
        this.Z = i;
    }

    public void p(int i) {
        this.ae = i;
    }

    public void q(int i) {
        String str;
        String str2 = null;
        List<h> j = j();
        if (j != null && j.size() > 0) {
            Iterator<h> it = j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = str2;
                    break;
                }
                str2 = it.next().a(Integer.valueOf(i));
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                    break;
                }
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f)) {
            this.f = this.f.replace("__SERVER_DATA__", str);
        }
        List<g> R = R();
        if (R != null && R.size() > 0) {
            for (g gVar : R) {
                if (gVar != null) {
                    String a2 = gVar.a();
                    if (!TextUtils.isEmpty(a2)) {
                        gVar.a(a2.replace("__SERVER_DATA__", str));
                    }
                }
            }
        }
        List<g> S = S();
        if (S != null && S.size() > 0) {
            for (g gVar2 : S) {
                if (gVar2 != null) {
                    String a3 = gVar2.a();
                    if (!TextUtils.isEmpty(a3)) {
                        gVar2.a(a3.replace("__SERVER_DATA__", str));
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.h)) {
            this.h = this.h.replace("__SERVER_DATA__", str);
        }
        List<String> T = T();
        if (T != null && T.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str3 : T) {
                arrayList.add(str3.replace("__SERVER_DATA__", str));
            }
        }
        List<String> U = U();
        if (U == null || U.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str4 : U) {
            arrayList2.add(str4.replace("__SERVER_DATA__", str));
        }
    }

    public void v(String str) {
        this.U = str;
    }

    public void w(String str) {
        this.W = str;
    }

    public void x(String str) {
        this.X = str;
    }

    public void y(String str) {
        this.Y = str;
    }

    public void z(String str) {
        this.ab = str;
    }
}
