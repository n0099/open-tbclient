package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f40642a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40642a != null) {
            int alpha = bVar.f40587f.getAlpha();
            bVar.d(bVar.f40587f);
            canvas.drawRect(this.f40642a, bVar.f40587f);
            bVar.f40587f.setAlpha(alpha);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f40642a = new Rect(g2, g3, d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2)) + g2, d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3)) + g3);
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }
}
