package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f68064a;

    /* renamed from: b  reason: collision with root package name */
    public long f68065b;

    /* renamed from: c  reason: collision with root package name */
    public int f68066c;

    /* renamed from: d  reason: collision with root package name */
    public int f68067d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68068e;

    public r(String str, long j, int i2, int i3, boolean z) {
        this.f68064a = str;
        this.f68065b = j;
        this.f68066c = i2;
        this.f68067d = i3;
        this.f68068e = z;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1005);
            jSONObject.put(IAdRequestParam.SEQ, this.f68064a);
            jSONObject.put("uid", this.f68065b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68066c);
            jSONObject.put("usedChannel", this.f68067d);
            jSONObject.put("returnYb", this.f68068e);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
