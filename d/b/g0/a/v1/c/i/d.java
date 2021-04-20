package d.b.g0.a.v1.c.i;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends h<JSONObject> {
    public final Context l;

    public d(Context context) {
        this.l = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.v1.c.b
    /* renamed from: I */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        return d.b.g0.a.v1.c.c.c(jSONObject);
    }

    @Override // d.b.g0.a.v1.c.b
    public boolean k() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", y.f46132f);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            w("data", jSONObject.toString());
            return true;
        }
        return true;
    }

    @Override // d.b.g0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.b.g0.a.w0.a.l().N(this.l, hVar.A());
    }
}
