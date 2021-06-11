package d.a.l0.a.h1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f46340e;

    /* renamed from: f  reason: collision with root package name */
    public int f46341f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f46342g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f46343h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f46344i = 0.0f;

    @Override // d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f46340e = cVar;
            cVar.a(jSONObject);
            if (this.f46340e.isValid()) {
                this.f46341f = d.a.l0.a.h1.c.d.a(jSONObject.optString("color"), 0);
                this.f46342g = d.a.l0.a.h1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f46343h = jSONObject.optInt("radius", -1);
                this.f46344i = Math.abs(d.a.l0.a.h1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.a.l0.a.l1.a
    public boolean isValid() {
        c cVar = this.f46340e;
        return (cVar == null || !cVar.isValid() || this.f46343h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f46340e + "color ->" + this.f46341f + "fillColor ->" + this.f46342g + "radius ->" + this.f46343h + "strokeWidth ->" + this.f46344i;
    }
}
