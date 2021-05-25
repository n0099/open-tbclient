package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f68020a;

    /* renamed from: b  reason: collision with root package name */
    public long f68021b;

    /* renamed from: c  reason: collision with root package name */
    public long f68022c;

    /* renamed from: d  reason: collision with root package name */
    public int f68023d;

    /* renamed from: e  reason: collision with root package name */
    public int f68024e;

    /* renamed from: f  reason: collision with root package name */
    public String f68025f;

    /* renamed from: g  reason: collision with root package name */
    public String f68026g;

    public l(String str, long j, long j2, int i2, int i3, String str2, String str3) {
        this.f68022c = 0L;
        this.f68024e = 10002;
        this.f68020a = str;
        this.f68021b = j;
        this.f68022c = j2;
        this.f68023d = i2;
        this.f68024e = i3;
        this.f68025f = str2;
        this.f68026g = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1061);
            jSONObject.put("uid", this.f68021b);
            jSONObject.put("sid", this.f68022c);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68023d);
            jSONObject.put("usedChannel", this.f68024e);
            jSONObject.put(IAdRequestParam.SEQ, this.f68025f);
            jSONObject.put("orderId", this.f68020a);
            jSONObject.put("expand", this.f68026g);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeOrderStatusRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
