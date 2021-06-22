package com.cmic.sso.sdk.b.b;

import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends a {
    public String x = "";
    public String y = "";

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return this.f30672b + this.f30673c + this.f30674d + this.f30675e + this.f30676f + this.f30677g + this.f30678h + this.f30679i + this.j + this.m + this.n + str + this.o + this.q + this.r + this.s + this.t + this.u + this.v + this.x + this.y + this.w;
    }

    @Override // com.cmic.sso.sdk.b.b.a
    public void a_(String str) {
        this.v = v(str);
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f30671a);
            jSONObject.put(BaseStatisContent.SDKVER, this.f30672b);
            jSONObject.put("appid", this.f30673c);
            jSONObject.put(BaseStatisContent.IMSI, this.f30674d);
            jSONObject.put("operatortype", this.f30675e);
            jSONObject.put("networktype", this.f30676f);
            jSONObject.put("mobilebrand", this.f30677g);
            jSONObject.put("mobilemodel", this.f30678h);
            jSONObject.put("mobilesystem", this.f30679i);
            jSONObject.put("clienttype", this.j);
            jSONObject.put("interfacever", this.k);
            jSONObject.put("expandparams", this.l);
            jSONObject.put("msgid", this.m);
            jSONObject.put("timestamp", this.n);
            jSONObject.put("subimsi", this.o);
            jSONObject.put("sign", this.p);
            jSONObject.put("apppackage", this.q);
            jSONObject.put("appsign", this.r);
            jSONObject.put("ipv4_list", this.s);
            jSONObject.put("ipv6_list", this.t);
            jSONObject.put("sdkType", this.u);
            jSONObject.put("tempPDR", this.v);
            jSONObject.put("scrip", this.x);
            jSONObject.put("userCapaid", this.y);
            jSONObject.put("funcType", this.w);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return this.f30671a + "&" + this.f30672b + "&" + this.f30673c + "&" + this.f30674d + "&" + this.f30675e + "&" + this.f30676f + "&" + this.f30677g + "&" + this.f30678h + "&" + this.f30679i + "&" + this.j + "&" + this.k + "&" + this.l + "&" + this.m + "&" + this.n + "&" + this.o + "&" + this.p + "&" + this.q + "&" + this.r + "&&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.x + "&" + this.y + "&" + this.w;
    }

    public void x(String str) {
        this.x = v(str);
    }

    public void y(String str) {
        this.y = v(str);
    }
}
