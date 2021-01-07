package com.qq.e.comm.plugin.rewardvideo;

import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends com.qq.e.comm.plugin.s.a implements com.qq.e.comm.plugin.n.i {
    private JSONObject J;
    private int K;
    private int L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private boolean R;
    private String S;
    private String T;
    private String U;
    private e V;

    public d(String str, String str2, String str3, String str4) {
        super(str2, str3, str4, com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD);
        this.R = true;
        try {
            this.J = new JSONObject(str);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(this.J);
    }

    @Override // com.qq.e.comm.plugin.n.i
    public String a() {
        return this.U;
    }

    public void a(e eVar) {
        this.V = eVar;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public void a(String str) {
        this.N = str;
    }

    void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            g(jSONObject);
            this.K = jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
            this.L = jSONObject.optInt("card_show_time");
            this.M = jSONObject.optString("video");
            this.N = jSONObject.optString("endcard");
            this.O = jSONObject.optString("endcard_info");
            this.P = jSONObject.optString("edid");
            this.Q = jSONObject.optString("video_tracking_url");
            this.R = jSONObject.optInt("endcard_preload", 1) == 1;
            this.U = jSONObject.optString("landing_page");
            this.T = jSONObject.optString("landing_page_report_url");
            this.S = jSONObject.optString("customized_invoke_url");
        }
    }

    public String ak() {
        return this.N;
    }

    public String al() {
        return this.f;
    }

    public String am() {
        return this.Q;
    }

    public String an() {
        return this.T;
    }

    public e ao() {
        return this.V;
    }

    public void d(boolean z) {
        this.R = z;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public String e() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.J != null && com.qq.e.comm.plugin.util.m.b(this.M) && this.K >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.J != null && com.qq.e.comm.plugin.util.m.b(this.U);
    }

    public int h() {
        return this.K;
    }

    @Override // com.qq.e.comm.plugin.s.a
    public String i() {
        return this.c;
    }

    public String j() {
        return this.f12743a;
    }

    public String k() {
        return this.M;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public boolean k_() {
        return this.R;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public JSONObject l_() {
        return this.J;
    }
}
