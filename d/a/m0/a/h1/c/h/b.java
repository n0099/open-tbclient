package d.a.m0.a.h1.c.h;

import android.text.TextUtils;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f46453e;

    /* renamed from: f  reason: collision with root package name */
    public String f46454f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f46455g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f46456h;

    static {
        boolean z = k.f46983a;
    }

    @Override // d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f46453e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f46453e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f46456h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f46454f = jSONObject.optString("iconPath");
            this.f46455g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.m0.a.l1.a
    public boolean isValid() {
        g gVar = this.f46456h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f46454f)) ? false : true;
    }
}
