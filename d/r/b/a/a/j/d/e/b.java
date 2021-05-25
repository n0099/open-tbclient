package d.r.b.a.a.j.d.e;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f67959a = 2022;

    /* renamed from: b  reason: collision with root package name */
    public String f67960b;

    /* renamed from: c  reason: collision with root package name */
    public int f67961c;

    /* renamed from: d  reason: collision with root package name */
    public String f67962d;

    /* renamed from: e  reason: collision with root package name */
    public String f67963e;

    /* renamed from: f  reason: collision with root package name */
    public String f67964f;

    /* renamed from: g  reason: collision with root package name */
    public String f67965g;

    /* renamed from: h  reason: collision with root package name */
    public String f67966h;

    /* renamed from: i  reason: collision with root package name */
    public String f67967i;
    public d.r.b.a.a.i.c.i j;

    public b(String str) {
        a(str);
    }

    public void a(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67959a == optInt) {
                    jSONObject.optInt("appid");
                    jSONObject.optLong("uid");
                    this.f67960b = jSONObject.optString(IAdRequestParam.SEQ);
                    jSONObject.optInt("usedChannel");
                    this.f67961c = jSONObject.optInt("result");
                    this.f67962d = jSONObject.optString("orderId");
                    this.f67963e = jSONObject.optString("payUrl");
                    jSONObject.optString("traceId");
                    this.f67964f = jSONObject.optString("expand");
                    this.f67965g = jSONObject.optString("payChannel");
                    this.f67966h = jSONObject.optString("payMethod");
                    this.f67967i = jSONObject.optString("closeRiskEnhance");
                    String optString = jSONObject.optString("pollingMode");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        d.r.b.a.a.i.c.i iVar = new d.r.b.a.a.i.c.i();
                        this.j = iVar;
                        iVar.f67829a = jSONObject2.optInt("times");
                        this.j.f67830b = jSONObject2.optInt("interval");
                    }
                    d.r.b.a.a.f.d.d.g("ChargeCurrencyResponse", "jsonObject", jSONObject);
                    return;
                }
                throw new Exception(this.f67959a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("ChargeCurrencyResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("ChargeCurrencyResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("ChargeCurrencyResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
