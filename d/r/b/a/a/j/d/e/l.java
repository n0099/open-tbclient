package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67291a;

    /* renamed from: b  reason: collision with root package name */
    public long f67292b;

    /* renamed from: c  reason: collision with root package name */
    public long f67293c;

    /* renamed from: d  reason: collision with root package name */
    public int f67294d;

    /* renamed from: e  reason: collision with root package name */
    public int f67295e;

    /* renamed from: f  reason: collision with root package name */
    public String f67296f;

    /* renamed from: g  reason: collision with root package name */
    public String f67297g;

    public l(String str, long j, long j2, int i2, int i3, String str2, String str3) {
        this.f67293c = 0L;
        this.f67295e = 10002;
        this.f67291a = str;
        this.f67292b = j;
        this.f67293c = j2;
        this.f67294d = i2;
        this.f67295e = i3;
        this.f67296f = str2;
        this.f67297g = str3;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1061);
            jSONObject.put("uid", this.f67292b);
            jSONObject.put("sid", this.f67293c);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67294d);
            jSONObject.put("usedChannel", this.f67295e);
            jSONObject.put(IAdRequestParam.SEQ, this.f67296f);
            jSONObject.put("orderId", this.f67291a);
            jSONObject.put("expand", this.f67297g);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetChargeOrderStatusRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
