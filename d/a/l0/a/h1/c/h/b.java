package d.a.l0.a.h1.c.h;

import android.text.TextUtils;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f42669e;

    /* renamed from: f  reason: collision with root package name */
    public String f42670f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f42671g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f42672h;

    static {
        boolean z = k.f43199a;
    }

    @Override // d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f42669e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f42669e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f42672h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f42670f = jSONObject.optString("iconPath");
            this.f42671g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.l0.a.l1.a
    public boolean isValid() {
        g gVar = this.f42672h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f42670f)) ? false : true;
    }
}
