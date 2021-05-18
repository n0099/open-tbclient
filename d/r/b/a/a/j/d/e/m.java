package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public int f67984a = 2061;

    /* renamed from: b  reason: collision with root package name */
    public String f67985b;

    /* renamed from: c  reason: collision with root package name */
    public int f67986c;

    /* renamed from: d  reason: collision with root package name */
    public String f67987d;

    /* renamed from: e  reason: collision with root package name */
    public String f67988e;

    /* renamed from: f  reason: collision with root package name */
    public int f67989f;

    /* renamed from: g  reason: collision with root package name */
    public int f67990g;

    /* renamed from: h  reason: collision with root package name */
    public int f67991h;

    /* renamed from: i  reason: collision with root package name */
    public long f67992i;
    public long j;
    public boolean k;

    public m(String str) {
        b(str);
    }

    public GetChargeOrderStatusResult a() {
        return new GetChargeOrderStatusResult(this.f67988e, this.f67989f, this.f67990g, this.f67991h, this.f67992i, this.j, this.k);
    }

    public void b(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67984a == optInt) {
                    jSONObject.optLong("uid");
                    this.f67985b = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f67986c = jSONObject.optInt("result");
                    this.f67987d = jSONObject.optString("message");
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    jSONObject.optInt("usedChannel");
                    this.f67988e = jSONObject.optString("expand");
                    this.f67989f = jSONObject.optInt("status");
                    this.f67990g = jSONObject.optInt("hasGotSalePromotion");
                    this.j = jSONObject.optLong("currencyAmount");
                    this.f67991h = jSONObject.optInt("currencyType");
                    this.f67992i = jSONObject.optLong("amount");
                    this.k = jSONObject.optBoolean("finish", false);
                    return;
                }
                throw new Exception(this.f67984a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetChargeOrderStatusResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetChargeOrderStatusResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetChargeOrderStatusResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
