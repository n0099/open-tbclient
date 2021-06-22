package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Path f44427a;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44427a != null) {
            int alpha = bVar.f44372g.getAlpha();
            bVar.d(bVar.f44372g);
            canvas.drawPath(this.f44427a, bVar.f44372g);
            bVar.f44372g.setAlpha(alpha);
        }
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(1));
                int g4 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(2));
                int g5 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(3));
                Path path = new Path();
                this.f44427a = path;
                path.addRect(new RectF(g2, g3, g2 + g4, g3 + g5), Path.Direction.CW);
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
