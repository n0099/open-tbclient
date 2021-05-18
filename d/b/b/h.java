package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64984e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64985f;

    public h(Context context, i iVar) {
        super(false, false);
        this.f64984e = context;
        this.f64985f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.9-embed");
        jSONObject.put("channel", this.f64985f.G());
        j.f(jSONObject, "aid", this.f64985f.F());
        j.f(jSONObject, "release_build", this.f64985f.W());
        j.f(jSONObject, "app_region", this.f64985f.J());
        j.f(jSONObject, "app_language", this.f64985f.I());
        j.f(jSONObject, com.alipay.sdk.cons.b.f1825b, this.f64985f.a());
        j.f(jSONObject, "ab_sdk_version", this.f64985f.L());
        j.f(jSONObject, "ab_version", this.f64985f.P());
        j.f(jSONObject, "aliyun_uuid", this.f64985f.q());
        String H = this.f64985f.H();
        if (TextUtils.isEmpty(H)) {
            H = n0.a(this.f64984e, this.f64985f);
        }
        if (!TextUtils.isEmpty(H)) {
            j.f(jSONObject, "google_aid", H);
        }
        String V = this.f64985f.V();
        if (!TextUtils.isEmpty(V)) {
            try {
                jSONObject.put("app_track", new JSONObject(V));
            } catch (Throwable th) {
                r0.b(th);
            }
        }
        String K = this.f64985f.K();
        if (K != null && K.length() > 0) {
            jSONObject.put(SchedulerSupport.CUSTOM, new JSONObject(K));
        }
        j.f(jSONObject, "user_unique_id", this.f64985f.M());
        return true;
    }
}
