package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public String f67335a;

    /* renamed from: b  reason: collision with root package name */
    public long f67336b;

    /* renamed from: c  reason: collision with root package name */
    public int f67337c;

    /* renamed from: d  reason: collision with root package name */
    public int f67338d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67339e;

    public r(String str, long j, int i2, int i3, boolean z) {
        this.f67335a = str;
        this.f67336b = j;
        this.f67337c = i2;
        this.f67338d = i3;
        this.f67339e = z;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1005);
            jSONObject.put(IAdRequestParam.SEQ, this.f67335a);
            jSONObject.put("uid", this.f67336b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67337c);
            jSONObject.put("usedChannel", this.f67338d);
            jSONObject.put("returnYb", this.f67339e);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountRequest", "constructPSCIMessageRequest error.", e2);
            return "";
        }
    }
}
