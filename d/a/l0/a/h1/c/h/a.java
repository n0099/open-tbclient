package d.a.l0.a.h1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f42664e;

    /* renamed from: f  reason: collision with root package name */
    public int f42665f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f42666g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f42667h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f42668i = 0.0f;

    @Override // d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f42664e = cVar;
            cVar.a(jSONObject);
            if (this.f42664e.isValid()) {
                this.f42665f = d.a.l0.a.h1.c.d.a(jSONObject.optString("color"), 0);
                this.f42666g = d.a.l0.a.h1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f42667h = jSONObject.optInt("radius", -1);
                this.f42668i = Math.abs(d.a.l0.a.h1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.a.l0.a.l1.a
    public boolean isValid() {
        c cVar = this.f42664e;
        return (cVar == null || !cVar.isValid() || this.f42667h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f42664e + "color ->" + this.f42665f + "fillColor ->" + this.f42666g + "radius ->" + this.f42667h + "strokeWidth ->" + this.f42668i;
    }
}
