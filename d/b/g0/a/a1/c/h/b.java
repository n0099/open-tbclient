package d.b.g0.a.a1.c.h;

import android.text.TextUtils;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f43579e;

    /* renamed from: f  reason: collision with root package name */
    public String f43580f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f43581g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f43582h;

    static {
        boolean z = k.f45443a;
    }

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f43579e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f43579e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f43582h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f43580f = jSONObject.optString("iconPath");
            this.f43581g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        g gVar = this.f43582h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f43580f)) ? false : true;
    }
}
