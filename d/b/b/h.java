package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65027e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65028f;

    public h(Context context, i iVar) {
        super(false, false);
        this.f65027e = context;
        this.f65028f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.9-embed");
        jSONObject.put("channel", this.f65028f.G());
        j.f(jSONObject, "aid", this.f65028f.F());
        j.f(jSONObject, "release_build", this.f65028f.W());
        j.f(jSONObject, "app_region", this.f65028f.J());
        j.f(jSONObject, "app_language", this.f65028f.I());
        j.f(jSONObject, com.alipay.sdk.cons.b.f1825b, this.f65028f.a());
        j.f(jSONObject, "ab_sdk_version", this.f65028f.L());
        j.f(jSONObject, "ab_version", this.f65028f.P());
        j.f(jSONObject, "aliyun_uuid", this.f65028f.q());
        String H = this.f65028f.H();
        if (TextUtils.isEmpty(H)) {
            H = n0.a(this.f65027e, this.f65028f);
        }
        if (!TextUtils.isEmpty(H)) {
            j.f(jSONObject, "google_aid", H);
        }
        String V = this.f65028f.V();
        if (!TextUtils.isEmpty(V)) {
            try {
                jSONObject.put("app_track", new JSONObject(V));
            } catch (Throwable th) {
                r0.b(th);
            }
        }
        String K = this.f65028f.K();
        if (K != null && K.length() > 0) {
            jSONObject.put(SchedulerSupport.CUSTOM, new JSONObject(K));
        }
        j.f(jSONObject, "user_unique_id", this.f65028f.M());
        return true;
    }
}
