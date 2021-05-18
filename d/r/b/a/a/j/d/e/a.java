package d.r.b.a.a.j.d.e;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67900a;

    /* renamed from: b  reason: collision with root package name */
    public int f67901b;

    /* renamed from: c  reason: collision with root package name */
    public int f67902c;

    /* renamed from: d  reason: collision with root package name */
    public int f67903d;

    /* renamed from: e  reason: collision with root package name */
    public int f67904e;

    /* renamed from: f  reason: collision with root package name */
    public String f67905f;

    /* renamed from: g  reason: collision with root package name */
    public String f67906g;

    /* renamed from: h  reason: collision with root package name */
    public String f67907h;

    /* renamed from: i  reason: collision with root package name */
    public double f67908i;
    public int j;
    public boolean k;
    public String l;
    public String m;
    public String n;

    public a(long j, int i2, int i3, int i4, int i5, String str, String str2, String str3, double d2, int i6, boolean z, String str4, String str5, String str6, String str7) {
        this.f67901b = 0;
        this.f67903d = 10002;
        this.j = 0;
        this.k = true;
        this.l = "";
        this.m = "";
        this.n = "";
        this.f67900a = j;
        this.f67901b = i2;
        this.f67902c = i3;
        this.f67903d = i4;
        this.f67904e = i5;
        this.f67905f = str;
        this.f67906g = str2;
        this.f67907h = str3;
        this.f67908i = d2;
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
            jSONObject.put("uid", this.f67900a);
            jSONObject.put("sid", this.f67901b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67902c);
            jSONObject.put("usedChannel", this.f67903d);
            jSONObject.put("currencyType", this.f67904e);
            jSONObject.put(IAdRequestParam.SEQ, this.f67905f);
            jSONObject.put("payChannel", this.f67906g);
            jSONObject.put("payMethod", this.f67907h);
            jSONObject.put("amount", this.f67908i);
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
