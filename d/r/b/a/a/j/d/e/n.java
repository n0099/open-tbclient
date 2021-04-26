package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67307a;

    /* renamed from: b  reason: collision with root package name */
    public long f67308b;

    /* renamed from: c  reason: collision with root package name */
    public int f67309c;

    /* renamed from: d  reason: collision with root package name */
    public int f67310d;

    /* renamed from: e  reason: collision with root package name */
    public int f67311e;

    /* renamed from: f  reason: collision with root package name */
    public int f67312f;

    public n(String str, long j, int i2, int i3, int i4, int i5, String str2) {
        this.f67307a = str;
        this.f67308b = j;
        this.f67309c = i2;
        this.f67310d = i3;
        this.f67311e = i4;
        this.f67312f = i5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.EXPTYPE_LITEINC_CP);
            jSONObject.put(IAdRequestParam.SEQ, this.f67307a);
            jSONObject.put("uid", this.f67308b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67309c);
            jSONObject.put("usedChannel", this.f67310d);
            jSONObject.put("currencyType", this.f67311e);
            jSONObject.put("activityId", this.f67312f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetHasChargeInActivityRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
