package com.qq.e.comm.plugin.v;

import com.qq.e.ads.nativ.express2.VideoOption2;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e extends com.qq.e.comm.plugin.m.c implements com.qq.e.comm.plugin.n.i {
    private String J;
    private String K;
    private boolean L;

    public e(String str, String str2, String str3, com.qq.e.comm.plugin.ad.e eVar, JSONObject jSONObject, int i, int i2, VideoOption2 videoOption2) {
        super(str, str2, str3, eVar, jSONObject, i, i2, videoOption2);
        this.J = jSONObject.optString("endcard");
        this.L = jSONObject.optInt("endcard_preload", 1) == 1;
        this.K = jSONObject.optString("landing_page");
    }

    @Override // com.qq.e.comm.plugin.n.i
    public String a() {
        return this.K;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public void a(String str) {
        this.J = str;
    }

    public String j() {
        return this.J;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public boolean k_() {
        return this.L;
    }

    @Override // com.qq.e.comm.plugin.n.i
    public JSONObject l_() {
        return this.H;
    }
}
