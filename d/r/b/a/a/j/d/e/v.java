package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f68046a;

    /* renamed from: b  reason: collision with root package name */
    public int f68047b;

    /* renamed from: c  reason: collision with root package name */
    public int f68048c;

    /* renamed from: d  reason: collision with root package name */
    public int f68049d;

    /* renamed from: e  reason: collision with root package name */
    public String f68050e;

    /* renamed from: f  reason: collision with root package name */
    public int f68051f;

    public v(long j, int i2, int i3, int i4, String str, int i5) {
        this.f68048c = 20;
        this.f68046a = j;
        this.f68047b = i2;
        this.f68048c = i3;
        this.f68049d = i4;
        this.f68050e = str;
        this.f68051f = i5;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1068);
            jSONObject.put("uid", this.f68046a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68047b);
            jSONObject.put("pagesize", this.f68048c);
            jSONObject.put(IAdRequestParam.SEQ, this.f68050e);
            jSONObject.put("page", this.f68049d);
            jSONObject.put("usedChannel", this.f68051f);
            return jSONObject.toString().replaceAll("", "");
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserYbDetailsRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }
}
