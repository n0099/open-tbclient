package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67962a;

    /* renamed from: b  reason: collision with root package name */
    public int f67963b;

    /* renamed from: c  reason: collision with root package name */
    public int f67964c;

    /* renamed from: d  reason: collision with root package name */
    public int f67965d;

    /* renamed from: e  reason: collision with root package name */
    public String f67966e;

    /* renamed from: f  reason: collision with root package name */
    public String f67967f;

    public j(long j, int i2, int i3, int i4, String str, String str2, String str3) {
        this.f67964c = 10002;
        this.f67967f = "";
        this.f67962a = j;
        this.f67963b = i2;
        this.f67964c = i3;
        this.f67965d = i4;
        this.f67966e = str;
        this.f67967f = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1021);
            jSONObject.put("uid", this.f67962a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67963b);
            jSONObject.put("usedChannel", this.f67964c);
            jSONObject.put("currencyType", this.f67965d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67966e);
            jSONObject.put("expand", this.f67967f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
