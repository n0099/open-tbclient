package d.a.h0.a.y.a.j;

import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k0 implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f45174e;

    /* renamed from: f  reason: collision with root package name */
    public int f45175f;

    /* renamed from: g  reason: collision with root package name */
    public int f45176g;

    /* renamed from: h  reason: collision with root package name */
    public i f45177h;

    public k0(JSONArray jSONArray) {
        c(jSONArray);
    }

    public boolean b() {
        i iVar = this.f45177h;
        return iVar != null && iVar.d();
    }

    public void c(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 3) {
                this.f45174e = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                this.f45175f = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f45176g = jSONArray.optInt(2);
                this.f45177h = new i(jSONArray.optJSONArray(3));
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
