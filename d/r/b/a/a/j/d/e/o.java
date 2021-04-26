package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f67313a = 2026;

    /* renamed from: b  reason: collision with root package name */
    public String f67314b;

    /* renamed from: c  reason: collision with root package name */
    public int f67315c;

    /* renamed from: d  reason: collision with root package name */
    public String f67316d;

    /* renamed from: e  reason: collision with root package name */
    public int f67317e;

    /* renamed from: f  reason: collision with root package name */
    public String f67318f;

    /* renamed from: g  reason: collision with root package name */
    public String f67319g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67320h;

    /* renamed from: i  reason: collision with root package name */
    public String f67321i;
    public int j;

    public o(String str) {
        a(str);
    }

    public void a(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67313a == optInt) {
                    jSONObject.optLong("uid");
                    this.f67314b = jSONObject.optString(IAdRequestParam.SEQ);
                    this.f67315c = jSONObject.optInt("result");
                    this.f67316d = jSONObject.optString("message");
                    this.f67317e = jSONObject.optInt("activityId");
                    this.f67318f = jSONObject.optString("startTime");
                    this.f67319g = jSONObject.optString("endTime");
                    this.f67320h = jSONObject.optBoolean("hasCharge");
                    this.f67321i = jSONObject.optString("tip");
                    this.j = jSONObject.optInt("chargeCount");
                    return;
                }
                throw new Exception(this.f67313a + " != " + optInt);
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
