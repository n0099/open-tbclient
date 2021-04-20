package d.b.i0.v2.c.k.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f63142a = false;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && "ok".equals(jSONObject.optString("status"))) {
            this.f63142a = true;
        }
    }
}
