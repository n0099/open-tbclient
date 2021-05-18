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
    public String f67936a;

    /* renamed from: b  reason: collision with root package name */
    public long f67937b;

    /* renamed from: c  reason: collision with root package name */
    public int f67938c;

    /* renamed from: d  reason: collision with root package name */
    public int f67939d;

    /* renamed from: e  reason: collision with root package name */
    public int f67940e;

    /* renamed from: f  reason: collision with root package name */
    public int f67941f;

    /* renamed from: g  reason: collision with root package name */
    public String f67942g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f67943h;

    public f(String str, String str2, long j, int i2, int i3, int i4, int i5, String str3, List<Integer> list) {
        this.f67936a = str;
        this.f67937b = j;
        this.f67938c = i2;
        this.f67939d = i3;
        this.f67940e = i4;
        this.f67941f = i5;
        this.f67942g = str3;
        this.f67943h = list;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.f67943h;
        if (list != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        try {
            jSONObject.put("cmd", 1052);
            jSONObject.put("uid", this.f67937b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67938c);
            jSONObject.put("currencyType", this.f67939d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67936a);
            jSONObject.put("usedChannel", this.f67940e);
            jSONObject.put("userCouponId", this.f67941f);
            jSONObject.put("payChannel", this.f67942g);
            jSONObject.put("chargeConfigIds", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCouponDiscountRequest", "GetChargeCouponDiscountRequest error.", e2);
            return "";
        }
    }
}
