package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f47744a;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47744a != null) {
            int alpha = bVar.f47691f.getAlpha();
            bVar.d(bVar.f47691f);
            canvas.drawRect(this.f47744a, bVar.f47691f);
            bVar.f47691f.setAlpha(alpha);
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47744a = new Rect(f2, f3, d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
