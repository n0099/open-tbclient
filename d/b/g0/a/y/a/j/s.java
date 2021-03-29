package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class s extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f47056a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        RectF rectF = this.f47056a;
        if (rectF != null) {
            bVar.j.addRect(rectF, Path.Direction.CW);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47056a = new RectF(f2, f3, f2 + d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2)), f3 + d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
