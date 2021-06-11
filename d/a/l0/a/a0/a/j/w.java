package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44353a;

    /* renamed from: b  reason: collision with root package name */
    public float f44354b;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.scale(this.f44353a, this.f44354b);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f44353a = (float) jSONArray.optDouble(0);
            this.f44354b = (float) jSONArray.optDouble(1);
        }
    }
}
