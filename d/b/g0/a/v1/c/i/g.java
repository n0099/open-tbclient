package d.b.g0.a.v1.c.i;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends h<JSONObject> {
    public static final boolean p = k.f45051a;
    public final Activity l;
    public final String m;
    public final String n;
    public boolean o;

    public g(Activity activity, String str, String str2, boolean z) {
        this.l = activity;
        this.m = str;
        this.n = str2;
        this.o = z;
    }

    public JSONObject I() {
        JSONObject jSONObject = new JSONObject();
        try {
            d.b.g0.a.r1.e G = G();
            jSONObject.put("ma_id", G.f45740f);
            jSONObject.put("scope", this.m);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", d.b.g0.a.v1.c.c.g());
            jSONObject.put(com.alipay.sdk.cons.b.f1858h, G.B());
            if (G.L() != null && G.L().S() != null) {
                jSONObject.put("scene", G.L().S());
            }
            if (this.o) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String x = d.b.g0.a.w0.a.l().x();
            if (!TextUtils.isEmpty(x)) {
                jSONObject.put("host_api_key", x);
            }
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("provider_appkey", this.n);
            }
        } catch (JSONException e2) {
            if (p) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.v1.c.b
    /* renamed from: J */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.b.g0.a.v1.c.c.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt == 0) {
            return c2;
        }
        throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
    }

    @Override // d.b.g0.a.v1.c.b
    public boolean k() {
        w("data", I().toString());
        return true;
    }

    @Override // d.b.g0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.b.g0.a.w0.a.l().Q(this.l, hVar.A());
    }
}
