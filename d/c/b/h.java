package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65000e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65001f;

    public h(Context context, i iVar) {
        super(false, false);
        this.f65000e = context;
        this.f65001f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.9-embed");
        jSONObject.put("channel", this.f65001f.G());
        j.f(jSONObject, "aid", this.f65001f.F());
        j.f(jSONObject, "release_build", this.f65001f.W());
        j.f(jSONObject, "app_region", this.f65001f.J());
        j.f(jSONObject, "app_language", this.f65001f.I());
        j.f(jSONObject, com.alipay.sdk.cons.b.f1852b, this.f65001f.a());
        j.f(jSONObject, "ab_sdk_version", this.f65001f.L());
        j.f(jSONObject, "ab_version", this.f65001f.P());
        j.f(jSONObject, "aliyun_uuid", this.f65001f.q());
        String H = this.f65001f.H();
        if (TextUtils.isEmpty(H)) {
            H = n0.a(this.f65000e, this.f65001f);
        }
        if (!TextUtils.isEmpty(H)) {
            j.f(jSONObject, "google_aid", H);
        }
        String V = this.f65001f.V();
        if (!TextUtils.isEmpty(V)) {
            try {
                jSONObject.put("app_track", new JSONObject(V));
            } catch (Throwable th) {
                r0.b(th);
            }
        }
        String K = this.f65001f.K();
        if (K != null && K.length() > 0) {
            jSONObject.put("custom", new JSONObject(K));
        }
        j.f(jSONObject, "user_unique_id", this.f65001f.M());
        return true;
    }
}
