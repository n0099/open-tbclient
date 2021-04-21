package d.b.h0.a.a1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements d.b.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f43904e;

    /* renamed from: f  reason: collision with root package name */
    public int f43905f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f43906g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f43907h = -1;
    public float i = 0.0f;

    @Override // d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f43904e = cVar;
            cVar.a(jSONObject);
            if (this.f43904e.isValid()) {
                this.f43905f = d.b.h0.a.a1.c.d.a(jSONObject.optString("color"), 0);
                this.f43906g = d.b.h0.a.a1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f43907h = jSONObject.optInt("radius", -1);
                this.i = Math.abs(d.b.h0.a.a1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.b.h0.a.e1.a
    public boolean isValid() {
        c cVar = this.f43904e;
        return (cVar == null || !cVar.isValid() || this.f43907h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f43904e + "color ->" + this.f43905f + "fillColor ->" + this.f43906g + "radius ->" + this.f43907h + "strokeWidth ->" + this.i;
    }
}
