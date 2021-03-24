package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47040a;

    /* renamed from: b  reason: collision with root package name */
    public float f47041b;

    /* renamed from: c  reason: collision with root package name */
    public float f47042c;

    /* renamed from: d  reason: collision with root package name */
    public float f47043d;

    /* renamed from: e  reason: collision with root package name */
    public int f47044e;

    /* renamed from: f  reason: collision with root package name */
    public int f47045f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47040a, this.f47042c, this.f47044e, this.f47041b, this.f47043d, this.f47045f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47040a = (float) jSONArray.optDouble(0);
                this.f47041b = (float) jSONArray.optDouble(1);
                this.f47042c = (float) jSONArray.optDouble(2);
                this.f47043d = (float) jSONArray.optDouble(3);
                this.f47044e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47045f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
