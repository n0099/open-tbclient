package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public String f67988b;

    /* renamed from: c  reason: collision with root package name */
    public int f67989c;

    /* renamed from: d  reason: collision with root package name */
    public String f67990d;

    /* renamed from: e  reason: collision with root package name */
    public int f67991e;

    /* renamed from: a  reason: collision with root package name */
    public int f67987a = 2052;

    /* renamed from: f  reason: collision with root package name */
    public List<d.r.b.a.a.i.c.d> f67992f = new ArrayList();

    public g(String str) {
        b(str);
    }

    public final List<d.r.b.a.a.i.c.d> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                d.r.b.a.a.i.c.d dVar = new d.r.b.a.a.i.c.d();
                optJSONObject.optInt(IAdRequestParam.CELL_ID);
                optJSONObject.optBoolean("couponEnabled");
                optJSONObject.optDouble("srcAmount", 0.0d);
                optJSONObject.optDouble("discountAmount", 0.0d);
                optJSONObject.optString("discountProductId");
                optJSONObject.optString("srcCurrencySymbol");
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public void b(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.f67987a == optInt) {
                    jSONObject.optLong("uid");
                    this.f67988b = jSONObject.optString(IAdRequestParam.SEQ);
                    jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.f67989c = jSONObject.optInt("result");
                    this.f67990d = jSONObject.optString("message");
                    this.f67991e = jSONObject.optInt("userCouponId");
                    this.f67992f.addAll(a(jSONObject.optJSONArray("discountList")));
                    return;
                }
                throw new Exception(this.f67987a + " != " + optInt);
            } catch (JSONException e2) {
                d.r.b.a.a.f.d.d.d("GetChargeCouponDiscountResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                d.r.b.a.a.f.d.d.d("GetChargeCouponDiscountResponse", "parserResponse error.", e3);
                return;
            }
        }
        d.r.b.a.a.f.d.d.e("GetChargeCouponDiscountResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
