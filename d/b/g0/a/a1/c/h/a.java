package d.b.g0.a.a1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f43182e;

    /* renamed from: f  reason: collision with root package name */
    public int f43183f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f43184g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f43185h = -1;
    public float i = 0.0f;

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f43182e = cVar;
            cVar.a(jSONObject);
            if (this.f43182e.isValid()) {
                this.f43183f = d.b.g0.a.a1.c.d.a(jSONObject.optString("color"), 0);
                this.f43184g = d.b.g0.a.a1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f43185h = jSONObject.optInt("radius", -1);
                this.i = Math.abs(d.b.g0.a.a1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        c cVar = this.f43182e;
        return (cVar == null || !cVar.isValid() || this.f43185h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f43182e + "color ->" + this.f43183f + "fillColor ->" + this.f43184g + "radius ->" + this.f43185h + "strokeWidth ->" + this.i;
    }
}
