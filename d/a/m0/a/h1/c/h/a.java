package d.a.m0.a.h1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f46448e;

    /* renamed from: f  reason: collision with root package name */
    public int f46449f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f46450g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f46451h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f46452i = 0.0f;

    @Override // d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f46448e = cVar;
            cVar.a(jSONObject);
            if (this.f46448e.isValid()) {
                this.f46449f = d.a.m0.a.h1.c.d.a(jSONObject.optString("color"), 0);
                this.f46450g = d.a.m0.a.h1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f46451h = jSONObject.optInt("radius", -1);
                this.f46452i = Math.abs(d.a.m0.a.h1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.a.m0.a.l1.a
    public boolean isValid() {
        c cVar = this.f46448e;
        return (cVar == null || !cVar.isValid() || this.f46451h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f46448e + "color ->" + this.f46449f + "fillColor ->" + this.f46450g + "radius ->" + this.f46451h + "strokeWidth ->" + this.f46452i;
    }
}
