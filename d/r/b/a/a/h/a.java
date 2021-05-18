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
    public long f67739b;

    /* renamed from: c  reason: collision with root package name */
    public int f67740c;

    /* renamed from: d  reason: collision with root package name */
    public String f67741d;

    /* renamed from: e  reason: collision with root package name */
    public String f67742e;

    public a(long j, int i2, String str, String str2) {
        this.f67739b = j;
        this.f67740c = i2;
        this.f67741d = str;
        this.f67742e = str2;
    }

    @Override // d.r.b.a.a.f.e.a
    public void a() {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 1050);
            jSONObject.put("uid", this.f67739b);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f67740c);
            jSONObject.put(IAdRequestParam.SEQ, this.f67741d);
            jSONObject.put("ticket", this.f67742e);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jMsg.toString()");
            str = new Regex("").replace(jSONObject2, "");
        } catch (JSONException e2) {
            d.d("HeartBeatRequest", "constructPSCIMessageRequest", e2);
        }
        this.f67680a = new c(1050, this.f67740c, 0, this.f67742e, "", str);
    }
}
