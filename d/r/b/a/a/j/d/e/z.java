package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67378a;

    /* renamed from: b  reason: collision with root package name */
    public int f67379b;

    /* renamed from: c  reason: collision with root package name */
    public int f67380c;

    /* renamed from: d  reason: collision with root package name */
    public int f67381d;

    /* renamed from: e  reason: collision with root package name */
    public int f67382e;

    /* renamed from: f  reason: collision with root package name */
    public String f67383f;

    /* renamed from: g  reason: collision with root package name */
    public final String f67384g;

    /* renamed from: h  reason: collision with root package name */
    public final String f67385h;

    /* renamed from: i  reason: collision with root package name */
    public String f67386i;

    public z(long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5) {
        this.f67379b = 0;
        this.f67381d = 10002;
        this.f67378a = j;
        this.f67379b = i2;
        this.f67380c = i3;
        this.f67381d = i4;
        this.f67382e = i5;
        this.f67383f = str;
        this.f67384g = str3;
        this.f67385h = str4;
        this.f67386i = str5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_NATIVE_CPU_IMPRESSION);
            jSONObject.put("uid", this.f67378a);
            jSONObject.put("sid", this.f67379b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67380c);
            jSONObject.put("usedChannel", this.f67381d);
            jSONObject.put("currencyType", this.f67382e);
            jSONObject.put(IAdRequestParam.SEQ, this.f67383f);
            jSONObject.put("purchaseData", this.f67384g);
            jSONObject.put("purchaseSign", this.f67385h);
            jSONObject.put("expand", this.f67386i);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("ReportPurchaseRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
