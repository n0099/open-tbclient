package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f45204a;

    /* renamed from: b  reason: collision with root package name */
    public int f45205b;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.translate(this.f45204a, this.f45205b);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f45204a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f45205b = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
        }
    }
}
