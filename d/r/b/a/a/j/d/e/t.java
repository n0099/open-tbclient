package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f68032a;

    /* renamed from: b  reason: collision with root package name */
    public long f68033b;

    /* renamed from: c  reason: collision with root package name */
    public int f68034c;

    /* renamed from: d  reason: collision with root package name */
    public int f68035d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68036e;

    /* renamed from: f  reason: collision with root package name */
    public int f68037f;

    /* renamed from: g  reason: collision with root package name */
    public int f68038g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68039h;

    public t(String str, long j, int i2, String str2, int i3, boolean z, int i4, int i5, boolean z2) {
        this.f68032a = str;
        this.f68033b = j;
        this.f68034c = i2;
        this.f68035d = i3;
        this.f68036e = z;
        this.f68037f = i4;
        this.f68038g = i5;
        this.f68039h = z2;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_AD_CLICK_LP);
            jSONObject.put(IAdRequestParam.SEQ, this.f68032a);
            jSONObject.put("uid", this.f68033b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68034c);
            jSONObject.put("goodsType", this.f68035d);
            jSONObject.put("hasUsed", this.f68036e);
            jSONObject.put("page", this.f68037f);
            jSONObject.put("pageSize", this.f68038g);
            jSONObject.put("includeExpire", this.f68039h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserCouponStoreRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
