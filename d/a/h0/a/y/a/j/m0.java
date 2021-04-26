package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Path f45179a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f45179a != null) {
            int alpha = bVar.f45124g.getAlpha();
            bVar.d(bVar.f45124g);
            canvas.drawPath(this.f45179a, bVar.f45124g);
            bVar.f45124g.setAlpha(alpha);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                int f4 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
                int f5 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3));
                Path path = new Path();
                this.f45179a = path;
                path.addRect(new RectF(f2, f3, f2 + f4, f3 + f5), Path.Direction.CW);
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
