package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47779a;

    /* renamed from: b  reason: collision with root package name */
    public float f47780b;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.scale(this.f47779a, this.f47780b);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f47779a = (float) jSONArray.optDouble(0);
            this.f47780b = (float) jSONArray.optDouble(1);
        }
    }
}
