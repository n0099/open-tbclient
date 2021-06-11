package d.a.l0.a.a0.a.j;

import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f44314e;

    /* renamed from: f  reason: collision with root package name */
    public int f44315f;

    /* renamed from: g  reason: collision with root package name */
    public int f44316g;

    /* renamed from: h  reason: collision with root package name */
    public i f44317h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f44317h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f44314e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
                this.f44315f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f44316g = jSONArray.optInt(2);
                this.f44317h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
