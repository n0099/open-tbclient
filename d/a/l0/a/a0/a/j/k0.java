package d.a.l0.a.a0.a.j;

import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f40638e;

    /* renamed from: f  reason: collision with root package name */
    public int f40639f;

    /* renamed from: g  reason: collision with root package name */
    public int f40640g;

    /* renamed from: h  reason: collision with root package name */
    public i f40641h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f40641h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f40638e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
                this.f40639f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f40640g = jSONArray.optInt(2);
                this.f40641h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }
}
