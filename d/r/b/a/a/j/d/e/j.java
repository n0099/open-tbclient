package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67276a;

    /* renamed from: b  reason: collision with root package name */
    public int f67277b;

    /* renamed from: c  reason: collision with root package name */
    public int f67278c;

    /* renamed from: d  reason: collision with root package name */
    public int f67279d;

    /* renamed from: e  reason: collision with root package name */
    public String f67280e;

    /* renamed from: f  reason: collision with root package name */
    public String f67281f;

    public j(long j, int i2, int i3, int i4, String str, String str2, String str3) {
        this.f67278c = 10002;
        this.f67281f = "";
        this.f67276a = j;
        this.f67277b = i2;
        this.f67278c = i3;
        this.f67279d = i4;
        this.f67280e = str;
        this.f67281f = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1021);
            jSONObject.put("uid", this.f67276a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67277b);
            jSONObject.put("usedChannel", this.f67278c);
            jSONObject.put("currencyType", this.f67279d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67280e);
            jSONObject.put("expand", this.f67281f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
