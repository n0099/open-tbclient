package d.a.o0.w2.c.k.a;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f66479a = false;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && "ok".equals(jSONObject.optString("status"))) {
            this.f66479a = true;
        }
    }
}
