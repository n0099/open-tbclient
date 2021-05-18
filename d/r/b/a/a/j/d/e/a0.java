package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public int f67909a = 2045;

    /* renamed from: b  reason: collision with root package name */
    public String f67910b;

    /* renamed from: c  reason: collision with root package name */
    public int f67911c;

    /* renamed from: d  reason: collision with root package name */
    public String f67912d;

    /* renamed from: e  reason: collision with root package name */
    public String f67913e;

    /* renamed from: f  reason: collision with root package name */
    public String f67914f;

    /* renamed from: g  reason: collision with root package name */
    public String f67915g;

    public a0(String str) {
        a(str);
    }

    public void a(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67909a == optInt) {
                    jSONObject.optLong("uid");
                    this.f67910b = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f67911c = jSONObject.optInt("result");
                    this.f67912d = jSONObject.optString("message");
                    this.f67913e = jSONObject.optString("purchaseData");
                    this.f67914f = jSONObject.optString("purchaseSign");
                    this.f67915g = jSONObject.optString("orderId");
                    return;
                }
                throw new Exception(this.f67909a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("ReportPurchaseResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("ReportPurchaseResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("ReportPurchaseResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
