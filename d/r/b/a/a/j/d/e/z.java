package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f68107a;

    /* renamed from: b  reason: collision with root package name */
    public int f68108b;

    /* renamed from: c  reason: collision with root package name */
    public int f68109c;

    /* renamed from: d  reason: collision with root package name */
    public int f68110d;

    /* renamed from: e  reason: collision with root package name */
    public int f68111e;

    /* renamed from: f  reason: collision with root package name */
    public String f68112f;

    /* renamed from: g  reason: collision with root package name */
    public final String f68113g;

    /* renamed from: h  reason: collision with root package name */
    public final String f68114h;

    /* renamed from: i  reason: collision with root package name */
    public String f68115i;

    public z(long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5) {
        this.f68108b = 0;
        this.f68110d = 10002;
        this.f68107a = j;
        this.f68108b = i2;
        this.f68109c = i3;
        this.f68110d = i4;
        this.f68111e = i5;
        this.f68112f = str;
        this.f68113g = str3;
        this.f68114h = str4;
        this.f68115i = str5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_NATIVE_CPU_IMPRESSION);
            jSONObject.put("uid", this.f68107a);
            jSONObject.put("sid", this.f68108b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68109c);
            jSONObject.put("usedChannel", this.f68110d);
            jSONObject.put("currencyType", this.f68111e);
            jSONObject.put(IAdRequestParam.SEQ, this.f68112f);
            jSONObject.put("purchaseData", this.f68113g);
            jSONObject.put("purchaseSign", this.f68114h);
            jSONObject.put("expand", this.f68115i);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("ReportPurchaseRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
