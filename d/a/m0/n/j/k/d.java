package d.a.m0.n.j.k;

import com.baidu.webkit.internal.ETAG;
import d.a.m0.n.h.h;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.m0.n.j.b {
    @Override // d.a.m0.n.j.b
    public JSONArray c() {
        List<h> n;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "bbasp_core");
            jSONObject.put("version_name", d.a.m0.n.c.b().F(0));
            jSONObject.put("version_code", d.a.m0.n.c.b().w(0));
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "bbasp_game");
            jSONObject2.put("version_name", d.a.m0.n.c.b().F(1));
            jSONObject2.put("version_code", d.a.m0.n.c.b().w(1));
            jSONArray.put(jSONObject2);
        } catch (JSONException e3) {
            if (d.a.m0.n.c.f51766a) {
                e3.printStackTrace();
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("type", ETAG.KEY_EXTENSION);
            jSONObject3.put("version_name", d.a.m0.n.c.b().u(0));
            jSONObject3.put("version_code", d.a.m0.n.c.b().k(0));
            jSONArray.put(jSONObject3);
        } catch (JSONException e4) {
            if (d.a.m0.n.c.f51766a) {
                e4.printStackTrace();
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("type", "extension_game");
            jSONObject4.put("version_name", d.a.m0.n.c.b().u(1));
            jSONObject4.put("version_code", d.a.m0.n.c.b().k(1));
            jSONArray.put(jSONObject4);
        } catch (JSONException e5) {
            if (d.a.m0.n.c.f51766a) {
                e5.printStackTrace();
            }
        }
        try {
            n = d.a.m0.n.g.a.h().n(10);
        } catch (JSONException e6) {
            if (d.a.m0.n.c.f51766a) {
                e6.printStackTrace();
            }
        }
        if (n == null) {
            return jSONArray;
        }
        for (h hVar : n) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("type", "ddl");
            jSONObject5.put("bundle_id", hVar.f51794g);
            jSONObject5.put("version_code", hVar.f51796i);
            jSONObject5.put("version_name", hVar.j);
            jSONArray.put(jSONObject5);
        }
        return jSONArray;
    }
}
