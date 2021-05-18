package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f68021a;

    /* renamed from: b  reason: collision with root package name */
    public long f68022b;

    /* renamed from: c  reason: collision with root package name */
    public int f68023c;

    /* renamed from: d  reason: collision with root package name */
    public int f68024d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68025e;

    public r(String str, long j, int i2, int i3, boolean z) {
        this.f68021a = str;
        this.f68022b = j;
        this.f68023c = i2;
        this.f68024d = i3;
        this.f68025e = z;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1005);
            jSONObject.put(IAdRequestParam.SEQ, this.f68021a);
            jSONObject.put("uid", this.f68022b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68023c);
            jSONObject.put("usedChannel", this.f68024d);
            jSONObject.put("returnYb", this.f68025e);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
