package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payapi.request.ExchangeCurrencyReqParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public final ExchangeCurrencyReqParams f67240a;

    public d(ExchangeCurrencyReqParams exchangeCurrencyReqParams) {
        this.f67240a = exchangeCurrencyReqParams;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", 1025);
        jSONObject.put("uid", this.f67240a.getUid());
        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67240a.getAppId());
        jSONObject.put("usedChannel", this.f67240a.getUsedChannel());
        jSONObject.put(IAdRequestParam.SEQ, this.f67240a.getSeq());
        jSONObject.put("srcCurrencyType", this.f67240a.getSrcCurrencyType());
        jSONObject.put("destCurrencyType", this.f67240a.getDestCurrencyType());
        jSONObject.put("amount", this.f67240a.getAmount());
        jSONObject.put("configId", this.f67240a.getConfigId());
        jSONObject.put("expand", this.f67240a.getExpand());
        jSONObject.put("ip", this.f67240a.getIpAddress());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jMsg.toString()");
        return jSONObject2;
    }
}
