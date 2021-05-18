package d.a.i0.a.h1.c.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public c f42490e;

    /* renamed from: f  reason: collision with root package name */
    public int f42491f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f42492g = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f42493h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f42494i = 0.0f;

    @Override // d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f42490e = cVar;
            cVar.a(jSONObject);
            if (this.f42490e.isValid()) {
                this.f42491f = d.a.i0.a.h1.c.d.a(jSONObject.optString("color"), 0);
                this.f42492g = d.a.i0.a.h1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f42493h = jSONObject.optInt("radius", -1);
                this.f42494i = Math.abs(d.a.i0.a.h1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.a.i0.a.l1.a
    public boolean isValid() {
        c cVar = this.f42490e;
        return (cVar == null || !cVar.isValid() || this.f42493h == -1) ? false : true;
    }

    public String toString() {
        return "coordinate ->" + this.f42490e + "color ->" + this.f42491f + "fillColor ->" + this.f42492g + "radius ->" + this.f42493h + "strokeWidth ->" + this.f42494i;
    }
}
