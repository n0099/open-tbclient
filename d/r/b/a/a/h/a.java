package d.r.b.a.a.h;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.f.e.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.f.e.a {

    /* renamed from: b  reason: collision with root package name */
    public long f67053b;

    /* renamed from: c  reason: collision with root package name */
    public int f67054c;

    /* renamed from: d  reason: collision with root package name */
    public String f67055d;

    /* renamed from: e  reason: collision with root package name */
    public String f67056e;

    public a(long j, int i2, String str, String str2) {
        this.f67053b = j;
        this.f67054c = i2;
        this.f67055d = str;
        this.f67056e = str2;
    }

    @Override // d.r.b.a.a.f.e.a
    public void a() {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1050);
            jSONObject.put("uid", this.f67053b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67054c);
            jSONObject.put(IAdRequestParam.SEQ, this.f67055d);
            jSONObject.put("ticket", this.f67056e);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jMsg.toString()");
            str = new Regex("").replace(jSONObject2, "");
        } catch (JSONException e2) {
            d.d("HeartBeatRequest", "constructPSCIMessageRequest", e2);
        }
        this.f66994a = new c(1050, this.f67054c, 0, this.f67056e, "", str);
    }
}
