package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class t extends a {
    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.f();
        try {
            canvas.restore();
        } catch (IllegalStateException e2) {
            d.a.h0.a.c0.c.c("Canvas", "Underflow in restore - more restores than saves, please check", e2);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
    }
}
