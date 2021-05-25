package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f68036a;

    /* renamed from: b  reason: collision with root package name */
    public long f68037b;

    /* renamed from: c  reason: collision with root package name */
    public int f68038c;

    /* renamed from: d  reason: collision with root package name */
    public int f68039d;

    /* renamed from: e  reason: collision with root package name */
    public int f68040e;

    /* renamed from: f  reason: collision with root package name */
    public int f68041f;

    public n(String str, long j, int i2, int i3, int i4, int i5, String str2) {
        this.f68036a = str;
        this.f68037b = j;
        this.f68038c = i2;
        this.f68039d = i3;
        this.f68040e = i4;
        this.f68041f = i5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.EXPTYPE_LITEINC_CP);
            jSONObject.put(IAdRequestParam.SEQ, this.f68036a);
            jSONObject.put("uid", this.f68037b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68038c);
            jSONObject.put("usedChannel", this.f68039d);
            jSONObject.put("currencyType", this.f68040e);
            jSONObject.put("activityId", this.f68041f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetHasChargeInActivityRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
