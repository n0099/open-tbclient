package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f47022a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47022a != null) {
            int alpha = bVar.f46969f.getAlpha();
            bVar.d(bVar.f46969f);
            canvas.drawRect(this.f47022a, bVar.f46969f);
            bVar.f46969f.setAlpha(alpha);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47022a = new Rect(f2, f3, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
