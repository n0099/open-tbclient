package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f68005a;

    /* renamed from: b  reason: collision with root package name */
    public int f68006b;

    /* renamed from: c  reason: collision with root package name */
    public int f68007c;

    /* renamed from: d  reason: collision with root package name */
    public int f68008d;

    /* renamed from: e  reason: collision with root package name */
    public String f68009e;

    /* renamed from: f  reason: collision with root package name */
    public String f68010f;

    public j(long j, int i2, int i3, int i4, String str, String str2, String str3) {
        this.f68007c = 10002;
        this.f68010f = "";
        this.f68005a = j;
        this.f68006b = i2;
        this.f68007c = i3;
        this.f68008d = i4;
        this.f68009e = str;
        this.f68010f = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1021);
            jSONObject.put("uid", this.f68005a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68006b);
            jSONObject.put("usedChannel", this.f68007c);
            jSONObject.put("currencyType", this.f68008d);
            jSONObject.put(IAdRequestParam.SEQ, this.f68009e);
            jSONObject.put("expand", this.f68010f);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeCurrencyConfigRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
