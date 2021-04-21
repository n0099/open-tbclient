package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65940e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65941f;

    public h(Context context, i iVar) {
        super(false, false);
        this.f65940e = context;
        this.f65941f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.9-embed");
        jSONObject.put("channel", this.f65941f.G());
        j.f(jSONObject, "aid", this.f65941f.F());
        j.f(jSONObject, "release_build", this.f65941f.W());
        j.f(jSONObject, "app_region", this.f65941f.J());
        j.f(jSONObject, "app_language", this.f65941f.I());
        j.f(jSONObject, com.alipay.sdk.cons.b.f1877b, this.f65941f.a());
        j.f(jSONObject, "ab_sdk_version", this.f65941f.L());
        j.f(jSONObject, "ab_version", this.f65941f.P());
        j.f(jSONObject, "aliyun_uuid", this.f65941f.q());
        String H = this.f65941f.H();
        if (TextUtils.isEmpty(H)) {
            H = n0.a(this.f65940e, this.f65941f);
        }
        if (!TextUtils.isEmpty(H)) {
            j.f(jSONObject, "google_aid", H);
        }
        String V = this.f65941f.V();
        if (!TextUtils.isEmpty(V)) {
            try {
                jSONObject.put("app_track", new JSONObject(V));
            } catch (Throwable th) {
                r0.b(th);
            }
        }
        String K = this.f65941f.K();
        if (K != null && K.length() > 0) {
            jSONObject.put("custom", new JSONObject(K));
        }
        j.f(jSONObject, "user_unique_id", this.f65941f.M());
        return true;
    }
}
