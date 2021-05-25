package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public int f68027a = 2061;

    /* renamed from: b  reason: collision with root package name */
    public String f68028b;

    /* renamed from: c  reason: collision with root package name */
    public int f68029c;

    /* renamed from: d  reason: collision with root package name */
    public String f68030d;

    /* renamed from: e  reason: collision with root package name */
    public String f68031e;

    /* renamed from: f  reason: collision with root package name */
    public int f68032f;

    /* renamed from: g  reason: collision with root package name */
    public int f68033g;

    /* renamed from: h  reason: collision with root package name */
    public int f68034h;

    /* renamed from: i  reason: collision with root package name */
    public long f68035i;
    public long j;
    public boolean k;

    public m(String str) {
        b(str);
    }

    public GetChargeOrderStatusResult a() {
        return new GetChargeOrderStatusResult(this.f68031e, this.f68032f, this.f68033g, this.f68034h, this.f68035i, this.j, this.k);
    }

    public void b(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f68027a == optInt) {
                    jSONObject.optLong("uid");
                    this.f68028b = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f68029c = jSONObject.optInt("result");
                    this.f68030d = jSONObject.optString("message");
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    jSONObject.optInt("usedChannel");
                    this.f68031e = jSONObject.optString("expand");
                    this.f68032f = jSONObject.optInt("status");
                    this.f68033g = jSONObject.optInt("hasGotSalePromotion");
                    this.j = jSONObject.optLong("currencyAmount");
                    this.f68034h = jSONObject.optInt("currencyType");
                    this.f68035i = jSONObject.optLong("amount");
                    this.k = jSONObject.optBoolean("finish", false);
                    return;
                }
                throw new Exception(this.f68027a + " != " + optInt);
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
