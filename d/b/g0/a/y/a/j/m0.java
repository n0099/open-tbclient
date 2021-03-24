package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class m0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Path f47023a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47023a != null) {
            int alpha = bVar.f46970g.getAlpha();
            bVar.d(bVar.f46970g);
            canvas.drawPath(this.f47023a, bVar.f46970g);
            bVar.f46970g.setAlpha(alpha);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                int f4 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
                int f5 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
                Path path = new Path();
                this.f47023a = path;
                path.addRect(new RectF(f2, f3, f2 + f4, f3 + f5), Path.Direction.CW);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
