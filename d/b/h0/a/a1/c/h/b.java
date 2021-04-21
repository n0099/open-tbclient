package d.b.h0.a.a1.c.h;

import android.text.TextUtils;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements d.b.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public String f43908e;

    /* renamed from: f  reason: collision with root package name */
    public String f43909f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f43910g = false;

    /* renamed from: h  reason: collision with root package name */
    public g f43911h;

    static {
        boolean z = k.f45772a;
    }

    @Override // d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f43908e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f43908e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f43911h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f43909f = jSONObject.optString("iconPath");
            this.f43910g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.b.h0.a.e1.a
    public boolean isValid() {
        g gVar = this.f43911h;
        return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f43909f)) ? false : true;
    }
}
