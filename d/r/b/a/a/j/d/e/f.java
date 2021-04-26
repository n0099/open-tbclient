package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67250a;

    /* renamed from: b  reason: collision with root package name */
    public long f67251b;

    /* renamed from: c  reason: collision with root package name */
    public int f67252c;

    /* renamed from: d  reason: collision with root package name */
    public int f67253d;

    /* renamed from: e  reason: collision with root package name */
    public int f67254e;

    /* renamed from: f  reason: collision with root package name */
    public int f67255f;

    /* renamed from: g  reason: collision with root package name */
    public String f67256g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f67257h;

    public f(String str, String str2, long j, int i2, int i3, int i4, int i5, String str3, List<Integer> list) {
        this.f67250a = str;
        this.f67251b = j;
        this.f67252c = i2;
        this.f67253d = i3;
        this.f67254e = i4;
        this.f67255f = i5;
        this.f67256g = str3;
        this.f67257h = list;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.f67257h;
        if (list != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        try {
            jSONObject.put("cmd", 1052);
            jSONObject.put("uid", this.f67251b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67252c);
            jSONObject.put("currencyType", this.f67253d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67250a);
            jSONObject.put("usedChannel", this.f67254e);
            jSONObject.put("userCouponId", this.f67255f);
            jSONObject.put("payChannel", this.f67256g);
            jSONObject.put("chargeConfigIds", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCouponDiscountRequest", "GetChargeCouponDiscountRequest error.", e2);
            return "";
        }
    }
}
