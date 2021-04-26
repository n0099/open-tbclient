package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l0 extends a {
    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f45124g.getAlpha();
        bVar.d(bVar.f45124g);
        canvas.drawPath(bVar.j, bVar.f45124g);
        bVar.f45124g.setAlpha(alpha);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
