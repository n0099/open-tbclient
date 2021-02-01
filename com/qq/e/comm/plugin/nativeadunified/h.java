package com.qq.e.comm.plugin.nativeadunified;

import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class h extends com.qq.e.comm.plugin.s.a {
    private int J;
    private List<String> K;
    private int L;
    private double M;
    private String N;
    private int O;
    private long P;
    private String Q;
    private int R;
    private int S;
    private int T;

    public h(String str, String str2, String str3, com.qq.e.comm.plugin.ad.e eVar, JSONObject jSONObject) {
        super(str, str2, str3, eVar);
        this.K = new ArrayList();
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        g(jSONObject);
        this.J = jSONObject.optInt("pattern_type");
        JSONArray optJSONArray = jSONObject.optJSONArray("img_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.K.add(optJSONArray.optString(i));
            }
        }
        if (this.q != null) {
            this.L = this.q.g();
            this.M = this.q.e();
            this.N = this.q.d();
            this.O = this.q.h();
            this.P = this.q.c();
        }
        this.Q = jSONObject.optString("template_id");
        this.R = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
        this.S = jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT);
        this.T = jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION) * 1000;
    }

    public String a() {
        String b2 = l() != null ? l().b() : "";
        if (StringUtil.isEmpty(b2)) {
            GDTLogger.i("非营销组件广告");
        }
        return b2;
    }

    public int ak() {
        return this.S;
    }

    public String al() {
        return this.N;
    }

    public int c() {
        if (ah()) {
            return 2;
        }
        if (this.J == 27 && this.K.size() == 3) {
            return 3;
        }
        return this.J == 31 ? 4 : 1;
    }

    public List<String> d() {
        return this.K;
    }

    public int e() {
        return this.O;
    }

    public long f() {
        return this.P;
    }

    public int g() {
        return this.L;
    }

    public double h() {
        return this.M;
    }

    public void i(int i) {
        this.O = i;
    }

    public int j() {
        return this.T;
    }

    public int k() {
        return this.R;
    }

    @Override // com.qq.e.comm.plugin.s.a
    public String toString() {
        return "NativeUnifiedADDataImpl{super='" + super.toString() + "', mPatternType=" + this.J + ", mImgList=" + this.K + ", mVideoUrl='" + G() + "', mAppScore=" + this.L + ", mAppPrice=" + this.M + ", mPkgName='" + this.N + "', mAppStatus=" + this.O + ", mDownLoadCount=" + this.P + ", mTemplateId='" + this.Q + "', mAppInfo=" + this.q + ", mAdData=" + this.H + '}';
    }

    @Override // com.qq.e.comm.plugin.s.a
    public boolean w() {
        return com.qq.e.comm.plugin.util.d.b(this.H);
    }

    @Override // com.qq.e.comm.plugin.s.a
    public String x() {
        return this.Q;
    }
}
