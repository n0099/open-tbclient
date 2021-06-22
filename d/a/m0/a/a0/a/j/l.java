package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l extends a {
    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f44371f.getAlpha();
        bVar.d(bVar.f44371f);
        canvas.drawPath(bVar.j, bVar.f44371f);
        bVar.f44371f.setAlpha(alpha);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
