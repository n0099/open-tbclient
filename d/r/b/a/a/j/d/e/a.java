package d.r.b.a.a.j.d.e;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67214a;

    /* renamed from: b  reason: collision with root package name */
    public int f67215b;

    /* renamed from: c  reason: collision with root package name */
    public int f67216c;

    /* renamed from: d  reason: collision with root package name */
    public int f67217d;

    /* renamed from: e  reason: collision with root package name */
    public int f67218e;

    /* renamed from: f  reason: collision with root package name */
    public String f67219f;

    /* renamed from: g  reason: collision with root package name */
    public String f67220g;

    /* renamed from: h  reason: collision with root package name */
    public String f67221h;

    /* renamed from: i  reason: collision with root package name */
    public double f67222i;
    public int j;
    public boolean k;
    public String l;
    public String m;
    public String n;

    public a(long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, double d2, int i6, boolean z, String str4, String str5, String str6, String str7) {
        this.f67215b = 0;
        this.f67217d = 10002;
        this.j = 0;
        this.k = true;
        this.l = "";
        this.m = "";
        this.n = "";
        this.f67214a = j;
        this.f67215b = i2;
        this.f67216c = i3;
        this.f67217d = i4;
        this.f67218e = i5;
        this.f67219f = str;
        this.f67220g = str2;
        this.f67221h = str3;
        this.f67222i = d2;
        this.j = i6;
        this.k = z;
        this.l = str4;
        this.m = str5;
        this.n = str6;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1022);
            jSONObject.put("uid", this.f67214a);
            jSONObject.put("sid", this.f67215b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67216c);
            jSONObject.put("usedChannel", this.f67217d);
            jSONObject.put("currencyType", this.f67218e);
            jSONObject.put(IAdRequestParam.SEQ, this.f67219f);
            jSONObject.put("payChannel", this.f67220g);
            jSONObject.put("payMethod", this.f67221h);
            jSONObject.put("amount", this.f67222i);
            jSONObject.put("chargeCurrencyConfigId", this.j);
            jSONObject.put("needUnicast", this.k);
            jSONObject.put("returnUrl", this.l);
            jSONObject.put("clientVersion", this.n);
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.put("expand", this.m);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("ChargeCurrencyRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
