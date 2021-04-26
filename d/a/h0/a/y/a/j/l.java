package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class l extends a {
    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int alpha = bVar.f45123f.getAlpha();
        bVar.d(bVar.f45123f);
        canvas.drawPath(bVar.j, bVar.f45123f);
        bVar.f45123f.setAlpha(alpha);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
