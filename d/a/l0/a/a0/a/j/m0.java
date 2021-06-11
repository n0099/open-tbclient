package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Path f44319a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44319a != null) {
            int alpha = bVar.f44264g.getAlpha();
            bVar.d(bVar.f44264g);
            canvas.drawPath(this.f44319a, bVar.f44264g);
            bVar.f44264g.setAlpha(alpha);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
                int g4 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
                int g5 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3));
                Path path = new Path();
                this.f44319a = path;
                path.addRect(new RectF(g2, g3, g2 + g4, g3 + g5), Path.Direction.CW);
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
