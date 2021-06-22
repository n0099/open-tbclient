package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l0 extends a {
    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f44372g.getAlpha();
        bVar.d(bVar.f44372g);
        canvas.drawPath(bVar.j, bVar.f44372g);
        bVar.f44372g.setAlpha(alpha);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
