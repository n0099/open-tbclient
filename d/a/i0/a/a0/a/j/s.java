package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class s extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f40501a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        RectF rectF = this.f40501a;
        if (rectF != null) {
            bVar.j.addRect(rectF, Path.Direction.CW);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f40501a = new RectF(g2, g3, g2 + d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(2)), g3 + d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
