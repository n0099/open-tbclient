package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f44426a;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44426a != null) {
            int alpha = bVar.f44371f.getAlpha();
            bVar.d(bVar.f44371f);
            canvas.drawRect(this.f44426a, bVar.f44371f);
            bVar.f44371f.setAlpha(alpha);
        }
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f44426a = new Rect(g2, g3, d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(2)) + g2, d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(3)) + g3);
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
