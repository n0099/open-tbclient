package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f47415a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47415a != null) {
            int alpha = bVar.f47362f.getAlpha();
            bVar.d(bVar.f47362f);
            canvas.drawRect(this.f47415a, bVar.f47362f);
            bVar.f47362f.setAlpha(alpha);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47415a = new Rect(f2, f3, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45443a) {
                e2.printStackTrace();
            }
        }
    }
}
