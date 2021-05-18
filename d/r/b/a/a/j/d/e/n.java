package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67993a;

    /* renamed from: b  reason: collision with root package name */
    public long f67994b;

    /* renamed from: c  reason: collision with root package name */
    public int f67995c;

    /* renamed from: d  reason: collision with root package name */
    public int f67996d;

    /* renamed from: e  reason: collision with root package name */
    public int f67997e;

    /* renamed from: f  reason: collision with root package name */
    public int f67998f;

    public n(String str, long j, int i2, int i3, int i4, int i5, String str2) {
        this.f67993a = str;
        this.f67994b = j;
        this.f67995c = i2;
        this.f67996d = i3;
        this.f67997e = i4;
        this.f67998f = i5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.EXPTYPE_LITEINC_CP);
            jSONObject.put(IAdRequestParam.SEQ, this.f67993a);
            jSONObject.put("uid", this.f67994b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67995c);
            jSONObject.put("usedChannel", this.f67996d);
            jSONObject.put("currencyType", this.f67997e);
            jSONObject.put("activityId", this.f67998f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetHasChargeInActivityRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
