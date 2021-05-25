package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l0 extends a {
    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f40588g.getAlpha();
        bVar.d(bVar.f40588g);
        canvas.drawPath(bVar.j, bVar.f40588g);
        bVar.f40588g.setAlpha(alpha);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
