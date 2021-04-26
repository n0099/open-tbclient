package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67360a;

    /* renamed from: b  reason: collision with root package name */
    public int f67361b;

    /* renamed from: c  reason: collision with root package name */
    public int f67362c;

    /* renamed from: d  reason: collision with root package name */
    public int f67363d;

    /* renamed from: e  reason: collision with root package name */
    public String f67364e;

    /* renamed from: f  reason: collision with root package name */
    public int f67365f;

    public v(long j, int i2, int i3, int i4, String str, int i5) {
        this.f67362c = 20;
        this.f67360a = j;
        this.f67361b = i2;
        this.f67362c = i3;
        this.f67363d = i4;
        this.f67364e = str;
        this.f67365f = i5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1068);
            jSONObject.put("uid", this.f67360a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67361b);
            jSONObject.put("pagesize", this.f67362c);
            jSONObject.put(IAdRequestParam.SEQ, this.f67364e);
            jSONObject.put("page", this.f67363d);
            jSONObject.put("usedChannel", this.f67365f);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
