package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47441a;

    /* renamed from: b  reason: collision with root package name */
    public int f47442b;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.translate(this.f47441a, this.f47442b);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f47441a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            this.f47442b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
        }
    }
}
