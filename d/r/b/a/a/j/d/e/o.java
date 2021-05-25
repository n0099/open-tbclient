package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f68042a = 2026;

    /* renamed from: b  reason: collision with root package name */
    public String f68043b;

    /* renamed from: c  reason: collision with root package name */
    public int f68044c;

    /* renamed from: d  reason: collision with root package name */
    public String f68045d;

    /* renamed from: e  reason: collision with root package name */
    public int f68046e;

    /* renamed from: f  reason: collision with root package name */
    public String f68047f;

    /* renamed from: g  reason: collision with root package name */
    public String f68048g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68049h;

    /* renamed from: i  reason: collision with root package name */
    public String f68050i;
    public int j;

    public o(String str) {
        a(str);
    }

    public void a(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f68042a == optInt) {
                    jSONObject.optLong("uid");
                    this.f68043b = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f68044c = jSONObject.optInt("result");
                    this.f68045d = jSONObject.optString("message");
                    this.f68046e = jSONObject.optInt("activityId");
                    this.f68047f = jSONObject.optString("startTime");
                    this.f68048g = jSONObject.optString("endTime");
                    this.f68049h = jSONObject.optBoolean("hasCharge");
                    this.f68050i = jSONObject.optString("tip");
                    this.j = jSONObject.optInt("chargeCount");
                    return;
                }
                throw new Exception(this.f68042a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetHasChargeInActivityResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetHasChargeInActivityResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetHasChargeInActivityResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
