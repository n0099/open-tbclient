package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67977a;

    /* renamed from: b  reason: collision with root package name */
    public long f67978b;

    /* renamed from: c  reason: collision with root package name */
    public long f67979c;

    /* renamed from: d  reason: collision with root package name */
    public int f67980d;

    /* renamed from: e  reason: collision with root package name */
    public int f67981e;

    /* renamed from: f  reason: collision with root package name */
    public String f67982f;

    /* renamed from: g  reason: collision with root package name */
    public String f67983g;

    public l(String str, long j, long j2, int i2, int i3, String str2, String str3) {
        this.f67979c = 0L;
        this.f67981e = 10002;
        this.f67977a = str;
        this.f67978b = j;
        this.f67979c = j2;
        this.f67980d = i2;
        this.f67981e = i3;
        this.f67982f = str2;
        this.f67983g = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1061);
            jSONObject.put("uid", this.f67978b);
            jSONObject.put("sid", this.f67979c);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67980d);
            jSONObject.put("usedChannel", this.f67981e);
            jSONObject.put(IAdRequestParam.SEQ, this.f67982f);
            jSONObject.put("orderId", this.f67977a);
            jSONObject.put("expand", this.f67983g);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeOrderStatusRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
