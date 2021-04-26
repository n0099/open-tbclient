package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f67322a;

    /* renamed from: b  reason: collision with root package name */
    public int f67323b;

    /* renamed from: c  reason: collision with root package name */
    public int f67324c;

    /* renamed from: d  reason: collision with root package name */
    public int f67325d;

    /* renamed from: e  reason: collision with root package name */
    public String f67326e;

    /* renamed from: f  reason: collision with root package name */
    public long f67327f;

    /* renamed from: g  reason: collision with root package name */
    public String f67328g;

    public p(long j, int i2, int i3, int i4, String str, String str2, long j2) {
        this(j, i2, i3, i4, str, str2, j2, "");
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_DL_DIALOG_CLICK);
            jSONObject.put("uid", this.f67322a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67323b);
            jSONObject.put("usedChannel", this.f67324c);
            jSONObject.put("currencyType", this.f67325d);
            jSONObject.put(IAdRequestParam.SEQ, this.f67326e);
            jSONObject.put("lastId", this.f67327f);
            jSONObject.put("expand", this.f67328g);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountHistoryRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }

    public p(long j, int i2, int i3, int i4, String str, String str2, long j2, String str3) {
        this.f67324c = 10002;
        this.f67322a = j;
        this.f67323b = i2;
        this.f67324c = i3;
        this.f67325d = i4;
        this.f67326e = str;
        this.f67327f = j2;
        this.f67328g = str3;
    }
}
