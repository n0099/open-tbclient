package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l0 extends a {
    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f46971g.getAlpha();
        bVar.d(bVar.f46971g);
        canvas.drawPath(bVar.j, bVar.f46971g);
        bVar.f46971g.setAlpha(alpha);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
