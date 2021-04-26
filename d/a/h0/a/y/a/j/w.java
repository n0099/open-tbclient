package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f45213a;

    /* renamed from: b  reason: collision with root package name */
    public float f45214b;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.scale(this.f45213a, this.f45214b);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f45213a = (float) jSONArray.optDouble(0);
            this.f45214b = (float) jSONArray.optDouble(1);
        }
    }
}
