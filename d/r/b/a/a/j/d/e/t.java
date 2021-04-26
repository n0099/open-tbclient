package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67346a;

    /* renamed from: b  reason: collision with root package name */
    public long f67347b;

    /* renamed from: c  reason: collision with root package name */
    public int f67348c;

    /* renamed from: d  reason: collision with root package name */
    public int f67349d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67350e;

    /* renamed from: f  reason: collision with root package name */
    public int f67351f;

    /* renamed from: g  reason: collision with root package name */
    public int f67352g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67353h;

    public t(String str, long j, int i2, String str2, int i3, boolean z, int i4, int i5, boolean z2) {
        this.f67346a = str;
        this.f67347b = j;
        this.f67348c = i2;
        this.f67349d = i3;
        this.f67350e = z;
        this.f67351f = i4;
        this.f67352g = i5;
        this.f67353h = z2;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_AD_CLICK_LP);
            jSONObject.put(IAdRequestParam.SEQ, this.f67346a);
            jSONObject.put("uid", this.f67347b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67348c);
            jSONObject.put("goodsType", this.f67349d);
            jSONObject.put("hasUsed", this.f67350e);
            jSONObject.put("page", this.f67351f);
            jSONObject.put("pageSize", this.f67352g);
            jSONObject.put("includeExpire", this.f67353h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserCouponStoreRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
