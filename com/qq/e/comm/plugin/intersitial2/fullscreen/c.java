package com.qq.e.comm.plugin.intersitial2.fullscreen;

import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.qq.e.comm.plugin.n.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c extends com.qq.e.comm.plugin.s.a implements i {
    private JSONObject J;
    private int K;
    private String L;
    private String M;
    private String N;
    private boolean O;
    private String P;
    private String Q;

    public c(String str, String str2, String str3, String str4) {
        super(str2, str3, str4, com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN);
        this.O = true;
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
        return this.P;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public void a(String str) {
        this.M = str;
    }

    void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            g(jSONObject);
            this.K = jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
            this.L = jSONObject.optString("video");
            this.M = jSONObject.optString("endcard");
            this.N = jSONObject.optString("video_tracking_url");
            this.O = jSONObject.optInt("endcard_preload", 1) == 1;
            this.P = jSONObject.optString("landing_page");
            this.Q = jSONObject.optString("customized_invoke_url");
        }
    }

    @Override // com.qq.e.comm.plugin.n.i
    public String e() {
        return this.Q;
    }

    public String f() {
        return this.f12445a;
    }

    public String g() {
        return this.L;
    }

    public String h() {
        return this.M;
    }

    @Override // com.qq.e.comm.plugin.s.a
    public String i() {
        return this.c;
    }

    public String j() {
        return this.N;
    }

    public boolean k() {
        return this.O;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public boolean k_() {
        return this.O;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public JSONObject l_() {
        return this.J;
    }
}
