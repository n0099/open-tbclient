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
    public String f67979a;

    /* renamed from: b  reason: collision with root package name */
    public long f67980b;

    /* renamed from: c  reason: collision with root package name */
    public int f67981c;

    /* renamed from: d  reason: collision with root package name */
    public int f67982d;

    /* renamed from: e  reason: collision with root package name */
    public int f67983e;

    /* renamed from: f  reason: collision with root package name */
    public int f67984f;

    /* renamed from: g  reason: collision with root package name */
    public String f67985g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f67986h;

    public f(String str, String str2, long j, int i2, int i3, int i4, int i5, String str3, List<Integer> list) {
        this.f67979a = str;
        this.f67980b = j;
        this.f67981c = i2;
        this.f67982d = i3;
        this.f67983e = i4;
        this.f67984f = i5;
        this.f67985g = str3;
        this.f67986h = list;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<Integer> list = this.f67986h;
        if (list != null) {
            for (Integer num : list) {
                jSONArray.put(num);
            }
        }
        try {
            jSONObject.put("cmd", 1052);
            jSONObject.put("uid", this.f67980b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67981c);
            jSONObject.put("currencyType", this.f67982d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67979a);
            jSONObject.put("usedChannel", this.f67983e);
            jSONObject.put("userCouponId", this.f67984f);
            jSONObject.put("payChannel", this.f67985g);
            jSONObject.put("chargeConfigIds", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCouponDiscountRequest", "GetChargeCouponDiscountRequest error.", e2);
            return "";
        }
    }
}
