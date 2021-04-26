package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f45178a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f45178a != null) {
            int alpha = bVar.f45123f.getAlpha();
            bVar.d(bVar.f45123f);
            canvas.drawRect(this.f45178a, bVar.f45123f);
            bVar.f45123f.setAlpha(alpha);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f45178a = new Rect(f2, f3, d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
