package d.a.h0.a.a1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements d.a.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f41169e;

    /* renamed from: f  reason: collision with root package name */
    public int f41170f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f41171g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f41172h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f41173i = 0.0f;

    @Override // d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f41169e = cVar;
            cVar.a(jSONObject);
            if (this.f41169e.isValid()) {
                this.f41170f = d.a.h0.a.a1.c.d.a(jSONObject.optString("color"), 0);
                this.f41171g = d.a.h0.a.a1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f41172h = jSONObject.optInt("radius", -1);
                this.f41173i = Math.abs(d.a.h0.a.a1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.a.h0.a.e1.a
    public boolean isValid() {
        c cVar = this.f41169e;
        return (cVar == null || !cVar.isValid() || this.f41172h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f41169e + "color ->" + this.f41170f + "fillColor ->" + this.f41171g + "radius ->" + this.f41172h + "strokeWidth ->" + this.f41173i;
    }
}
