package d.a.h0.a.v1.c.i;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends h<JSONObject> {
    public final Context l;

    public e(Context context) {
        this.l = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.v1.c.b
    /* renamed from: I */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        return d.a.h0.a.v1.c.c.c(jSONObject);
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean k() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", h2.f43823f);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            w("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    @Override // d.a.h0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.a.h0.a.w0.a.l().e(this.l, hVar.A());
    }
}
