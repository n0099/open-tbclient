package d.a.h0.a.a1.c.h;

import android.text.TextUtils;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements d.a.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f41174e;

    /* renamed from: f  reason: collision with root package name */
    public String f41175f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f41176g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f41177h;

    static {
        boolean z = k.f43101a;
    }

    @Override // d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f41174e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f41174e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f41177h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f41175f = jSONObject.optString("iconPath");
            this.f41176g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.h0.a.e1.a
    public boolean isValid() {
        g gVar = this.f41177h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f41175f)) ? false : true;
    }
}
