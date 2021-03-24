package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47057a;

    /* renamed from: b  reason: collision with root package name */
    public float f47058b;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.scale(this.f47057a, this.f47058b);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f47057a = (float) jSONArray.optDouble(0);
            this.f47058b = (float) jSONArray.optDouble(1);
        }
    }
}
