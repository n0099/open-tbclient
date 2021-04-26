package d.a.h0.a.v1.c.i;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends h<JSONObject> {
    public String l;
    public final Context m;

    public c(Context context, String str) {
        this.l = str;
        this.m = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.v1.c.b
    /* renamed from: I */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        return d.a.h0.a.v1.c.c.c(jSONObject);
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.cons.b.f1831h, this.l);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", d.a.h0.a.v1.c.c.g());
            String j = d.a.h0.a.w0.a.l().j();
            if (!TextUtils.isEmpty(j)) {
                jSONObject.put("host_api_key", j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.h0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.a.h0.a.w0.a.l().a(this.m, hVar.A());
    }
}
