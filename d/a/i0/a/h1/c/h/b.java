package d.a.i0.a.h1.c.h;

import android.text.TextUtils;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.i0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f42495e;

    /* renamed from: f  reason: collision with root package name */
    public String f42496f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f42497g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f42498h;

    static {
        boolean z = k.f43025a;
    }

    @Override // d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f42495e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f42495e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f42498h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f42496f = jSONObject.optString("iconPath");
            this.f42497g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.i0.a.l1.a
    public boolean isValid() {
        g gVar = this.f42498h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f42496f)) ? false : true;
    }
}
