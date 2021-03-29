package d.b.g0.a.y.a.j;

import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f47019e;

    /* renamed from: f  reason: collision with root package name */
    public int f47020f;

    /* renamed from: g  reason: collision with root package name */
    public int f47021g;

    /* renamed from: h  reason: collision with root package name */
    public i f47022h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f47022h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f47019e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                this.f47020f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47021g = jSONArray.optInt(2);
                this.f47022h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
