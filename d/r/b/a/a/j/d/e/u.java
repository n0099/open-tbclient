package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u {

    /* renamed from: b  reason: collision with root package name */
    public String f68041b;

    /* renamed from: c  reason: collision with root package name */
    public int f68042c;

    /* renamed from: d  reason: collision with root package name */
    public String f68043d;

    /* renamed from: e  reason: collision with root package name */
    public long f68044e;

    /* renamed from: a  reason: collision with root package name */
    public int f68040a = 2047;

    /* renamed from: f  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.m> f68045f = new ArrayList();

    public u(String str) {
        b(str);
    }

    public final List<d.r.b.a.a.i.c.m> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.m mVar = new d.r.b.a.a.i.c.m();
                optJSONObject.optInt("id");
                optJSONObject.optLong("uid");
                optJSONObject.optInt("appid");
                optJSONObject.optLong("acquireTime");
                optJSONObject.optLong("validStartTime");
                optJSONObject.optLong("validEndTime");
                optJSONObject.optLong("lockReleaseTime");
                optJSONObject.optInt("status");
                optJSONObject.optInt("couponId");
                optJSONObject.optInt("couponType");
                optJSONObject.optString("couponName");
                optJSONObject.optDouble("couponLimitAmount");
                optJSONObject.optDouble("couponAmount");
                optJSONObject.optInt("couponUseWay");
                optJSONObject.optString("couponUseWayInfo");
                optJSONObject.optInt("srcType");
                optJSONObject.optString("humanId");
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    public void b(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f68040a == optInt) {
                    jSONObject.optLong("uid");
                    this.f68041b = jSONObject.optString(IAdRequestParam.SEQ);
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.f68042c = jSONObject.optInt("result");
                    this.f68043d = jSONObject.optString("message");
                    this.f68044e = jSONObject.optLong("serverCurrentTime");
                    this.f68045f.addAll(a(jSONObject.optJSONArray("userCouponList")));
                    jSONObject.optBoolean("hasMore");
                    return;
                }
                throw new Exception(this.f68040a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetUserAccountHistoryResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetUserAccountHistoryResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetUserCouponStoreResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
