package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class l0 extends a {
    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f46970g.getAlpha();
        bVar.d(bVar.f46970g);
        canvas.drawPath(bVar.j, bVar.f46970g);
        bVar.f46970g.setAlpha(alpha);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
