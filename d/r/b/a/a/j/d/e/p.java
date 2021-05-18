package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public long f68008a;

    /* renamed from: b  reason: collision with root package name */
    public int f68009b;

    /* renamed from: c  reason: collision with root package name */
    public int f68010c;

    /* renamed from: d  reason: collision with root package name */
    public int f68011d;

    /* renamed from: e  reason: collision with root package name */
    public String f68012e;

    /* renamed from: f  reason: collision with root package name */
    public long f68013f;

    /* renamed from: g  reason: collision with root package name */
    public String f68014g;

    public p(long j, int i2, int i3, int i4, String str, String str2, long j2) {
        this(j, i2, i3, i4, str, str2, j2, "");
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", SDKLogTypeConstants.TYPE_DL_DIALOG_CLICK);
            jSONObject.put("uid", this.f68008a);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68009b);
            jSONObject.put("usedChannel", this.f68010c);
            jSONObject.put("currencyType", this.f68011d);
            jSONObject.put(IAdRequestParam.SEQ, this.f68012e);
            jSONObject.put("lastId", this.f68013f);
            jSONObject.put("expand", this.f68014g);
            return jSONObject.toString();
        } catch (JSONException e2) {
            d.r.b.a.a.f.d.d.d("GetUserAccountHistoryRequest", "constructPSCIMessageRequest", e2);
            return "";
        }
    }

    public p(long j, int i2, int i3, int i4, String str, String str2, long j2, String str3) {
        this.f68010c = 10002;
        this.f68008a = j;
        this.f68009b = i2;
        this.f68010c = i3;
        this.f68011d = i4;
        this.f68012e = str;
        this.f68013f = j2;
        this.f68014g = str3;
    }
}
