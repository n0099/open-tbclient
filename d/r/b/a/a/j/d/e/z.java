package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f68064a;

    /* renamed from: b  reason: collision with root package name */
    public int f68065b;

    /* renamed from: c  reason: collision with root package name */
    public int f68066c;

    /* renamed from: d  reason: collision with root package name */
    public int f68067d;

    /* renamed from: e  reason: collision with root package name */
    public int f68068e;

    /* renamed from: f  reason: collision with root package name */
    public String f68069f;

    /* renamed from: g  reason: collision with root package name */
    public final String f68070g;

    /* renamed from: h  reason: collision with root package name */
    public final String f68071h;

    /* renamed from: i  reason: collision with root package name */
    public String f68072i;

    public z(long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5) {
        this.f68065b = 0;
        this.f68067d = 10002;
        this.f68064a = j;
        this.f68065b = i2;
        this.f68066c = i3;
        this.f68067d = i4;
        this.f68068e = i5;
        this.f68069f = str;
        this.f68070g = str3;
        this.f68071h = str4;
        this.f68072i = str5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_NATIVE_CPU_IMPRESSION);
            jSONObject.put("uid", this.f68064a);
            jSONObject.put("sid", this.f68065b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68066c);
            jSONObject.put("usedChannel", this.f68067d);
            jSONObject.put("currencyType", this.f68068e);
            jSONObject.put(IAdRequestParam.SEQ, this.f68069f);
            jSONObject.put("purchaseData", this.f68070g);
            jSONObject.put("purchaseSign", this.f68071h);
            jSONObject.put("expand", this.f68072i);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("ReportPurchaseRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
