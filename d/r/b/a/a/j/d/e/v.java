package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f68089a;

    /* renamed from: b  reason: collision with root package name */
    public int f68090b;

    /* renamed from: c  reason: collision with root package name */
    public int f68091c;

    /* renamed from: d  reason: collision with root package name */
    public int f68092d;

    /* renamed from: e  reason: collision with root package name */
    public String f68093e;

    /* renamed from: f  reason: collision with root package name */
    public int f68094f;

    public v(long j, int i2, int i3, int i4, String str, int i5) {
        this.f68091c = 20;
        this.f68089a = j;
        this.f68090b = i2;
        this.f68091c = i3;
        this.f68092d = i4;
        this.f68093e = str;
        this.f68094f = i5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1068);
            jSONObject.put("uid", this.f68089a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68090b);
            jSONObject.put("pagesize", this.f68091c);
            jSONObject.put(IAdRequestParam.SEQ, this.f68093e);
            jSONObject.put("page", this.f68092d);
            jSONObject.put("usedChannel", this.f68094f);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
