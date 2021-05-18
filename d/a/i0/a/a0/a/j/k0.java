package d.a.i0.a.a0.a.j;

import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f40464e;

    /* renamed from: f  reason: collision with root package name */
    public int f40465f;

    /* renamed from: g  reason: collision with root package name */
    public int f40466g;

    /* renamed from: h  reason: collision with root package name */
    public i f40467h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f40467h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f40464e = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
                this.f40465f = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f40466g = jSONArray.optInt(2);
                this.f40467h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
