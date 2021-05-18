package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class y extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f40506a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2 = this.f40506a;
        if (i2 > 0) {
            bVar.f40416i.setTextSize(i2);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                this.f40506a = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
