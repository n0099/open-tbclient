package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public int f67298a = 2061;

    /* renamed from: b  reason: collision with root package name */
    public String f67299b;

    /* renamed from: c  reason: collision with root package name */
    public int f67300c;

    /* renamed from: d  reason: collision with root package name */
    public String f67301d;

    /* renamed from: e  reason: collision with root package name */
    public String f67302e;

    /* renamed from: f  reason: collision with root package name */
    public int f67303f;

    /* renamed from: g  reason: collision with root package name */
    public int f67304g;

    /* renamed from: h  reason: collision with root package name */
    public int f67305h;

    /* renamed from: i  reason: collision with root package name */
    public long f67306i;
    public long j;
    public boolean k;

    public m(String str) {
        b(str);
    }

    public GetChargeOrderStatusResult a() {
        return new GetChargeOrderStatusResult(this.f67302e, this.f67303f, this.f67304g, this.f67305h, this.f67306i, this.j, this.k);
    }

    public void b(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67298a == optInt) {
                    jSONObject.optLong("uid");
                    this.f67299b = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f67300c = jSONObject.optInt("result");
                    this.f67301d = jSONObject.optString("message");
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    jSONObject.optInt("usedChannel");
                    this.f67302e = jSONObject.optString("expand");
                    this.f67303f = jSONObject.optInt("status");
                    this.f67304g = jSONObject.optInt("hasGotSalePromotion");
                    this.j = jSONObject.optLong("currencyAmount");
                    this.f67305h = jSONObject.optInt("currencyType");
                    this.f67306i = jSONObject.optLong("amount");
                    this.k = jSONObject.optBoolean("finish", false);
                    return;
                }
                throw new Exception(this.f67298a + " != " + optInt);
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
