package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f40468a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40468a != null) {
            int alpha = bVar.f40413f.getAlpha();
            bVar.d(bVar.f40413f);
            canvas.drawRect(this.f40468a, bVar.f40413f);
            bVar.f40413f.setAlpha(alpha);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f40468a = new Rect(g2, g3, d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(2)) + g2, d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(3)) + g3);
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
