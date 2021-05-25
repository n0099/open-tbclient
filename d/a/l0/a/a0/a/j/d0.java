package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f40597a = -1;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2 = this.f40597a;
        if (i2 >= 0) {
            bVar.f40588g.setStrokeWidth(i2);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40597a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
        }
    }
}
