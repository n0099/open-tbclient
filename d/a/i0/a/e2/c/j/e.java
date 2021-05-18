package d.a.i0.a.e2.c.j;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends h<JSONObject> {
    public final Context m;

    public e(Context context) {
        this.m = context;
    }

    @Override // d.a.i0.a.e2.c.j.h
    public SwanInterfaceType A() {
        return SwanInterfaceType.SWAN_ID;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.e2.c.c
    /* renamed from: Q */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        return d.a.i0.a.e2.c.d.c(jSONObject);
    }

    @Override // d.a.i0.a.e2.c.c
    public boolean k() {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", i2.D());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            w("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    @Override // d.a.i0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        return d.a.i0.a.c1.a.n().g(this.m, hVar.C());
    }
}
