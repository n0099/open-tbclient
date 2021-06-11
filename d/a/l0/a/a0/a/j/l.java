package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l extends a {
    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f44263f.getAlpha();
        bVar.d(bVar.f44263f);
        canvas.drawPath(bVar.j, bVar.f44263f);
        bVar.f44263f.setAlpha(alpha);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
