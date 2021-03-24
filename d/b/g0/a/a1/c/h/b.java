package d.b.g0.a.a1.c.h;

import android.text.TextUtils;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f43186e;

    /* renamed from: f  reason: collision with root package name */
    public String f43187f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f43188g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f43189h;

    static {
        boolean z = k.f45050a;
    }

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f43186e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f43186e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f43189h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f43187f = jSONObject.optString("iconPath");
            this.f43188g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        g gVar = this.f43189h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f43187f)) ? false : true;
    }
}
