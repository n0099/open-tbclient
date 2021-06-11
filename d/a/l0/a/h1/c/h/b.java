package d.a.l0.a.h1.c.h;

import android.text.TextUtils;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f46345e;

    /* renamed from: f  reason: collision with root package name */
    public String f46346f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f46347g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f46348h;

    static {
        boolean z = k.f46875a;
    }

    @Override // d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f46345e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f46345e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f46348h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f46346f = jSONObject.optString("iconPath");
            this.f46347g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.l0.a.l1.a
    public boolean isValid() {
        g gVar = this.f46348h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f46346f)) ? false : true;
    }
}
