package d.b.g0.a.y.a.j;

import org.json.JSONArray;
/* loaded from: classes3.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f47018e;

    /* renamed from: f  reason: collision with root package name */
    public int f47019f;

    /* renamed from: g  reason: collision with root package name */
    public int f47020g;

    /* renamed from: h  reason: collision with root package name */
    public i f47021h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f47021h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f47018e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                this.f47019f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47020g = jSONArray.optInt(2);
                this.f47021h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
