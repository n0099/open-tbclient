package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class u extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40502a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.rotate(this.f40502a);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            float optDouble = (float) jSONArray.optDouble(0);
            this.f40502a = optDouble;
            this.f40502a = (float) Math.toDegrees(optDouble);
        }
    }
}
