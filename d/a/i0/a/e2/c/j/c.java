package d.a.i0.a.e2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends h<JSONObject> {
    public String m;
    public final Context n;

    public c(Context context, String str) {
        this.m = str;
        this.n = context;
    }

    @Override // d.a.i0.a.e2.c.j.h
    public SwanInterfaceType A() {
        return SwanInterfaceType.CHECK_SESSION;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.e2.c.c
    /* renamed from: Q */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        return d.a.i0.a.e2.c.d.c(jSONObject);
    }

    @Override // d.a.i0.a.e2.c.c
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", this.m);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", d.a.i0.a.e2.c.d.g());
            String l = d.a.i0.a.c1.a.n().l();
            if (!TextUtils.isEmpty(l)) {
                jSONObject.put("host_api_key", l);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.i0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        return d.a.i0.a.c1.a.n().a(this.n, hVar.C());
    }
}
