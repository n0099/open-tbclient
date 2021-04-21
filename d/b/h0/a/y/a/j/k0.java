package d.b.h0.a.y.a.j;

import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f47740e;

    /* renamed from: f  reason: collision with root package name */
    public int f47741f;

    /* renamed from: g  reason: collision with root package name */
    public int f47742g;

    /* renamed from: h  reason: collision with root package name */
    public i f47743h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f47743h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f47740e = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                this.f47741f = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47742g = jSONArray.optInt(2);
                this.f47743h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
