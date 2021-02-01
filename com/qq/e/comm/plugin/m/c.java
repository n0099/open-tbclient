package com.qq.e.comm.plugin.m;

import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.qq.e.ads.nativ.express2.VideoOption2;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c extends com.qq.e.comm.plugin.s.a {
    private JSONObject J;
    private JSONObject K;
    private String L;
    private int M;
    private int N;
    private VideoOption2 O;
    private int P;
    private boolean Q;

    public c(String str, String str2, String str3, com.qq.e.comm.plugin.ad.e eVar, JSONObject jSONObject, int i, int i2, VideoOption2 videoOption2) {
        super(str, str2, str3, eVar);
        g(jSONObject);
        this.M = i;
        this.N = i2;
        this.O = videoOption2;
        this.K = jSONObject.optJSONObject("tpl_info");
        this.J = com.qq.e.comm.plugin.z.c.a().a(this.K);
        this.L = jSONObject.optString("customized_invoke_url");
        this.P = jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION) * 1000;
        this.Q = com.qq.e.comm.plugin.z.c.b(this.J);
    }

    public JSONObject b() {
        return this.K;
    }

    public int c() {
        return this.M;
    }

    public int d() {
        return this.N;
    }

    public String e() {
        return this.L;
    }

    public VideoOption2 f() {
        return this.O;
    }

    public int g() {
        return this.P;
    }

    public boolean h() {
        return this.Q;
    }

    public JSONObject m_() {
        return this.J;
    }
}
