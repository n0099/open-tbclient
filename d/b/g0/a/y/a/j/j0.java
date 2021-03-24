package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47001a;

    /* renamed from: b  reason: collision with root package name */
    public float f47002b;

    /* renamed from: c  reason: collision with root package name */
    public float f47003c;

    /* renamed from: d  reason: collision with root package name */
    public float f47004d;

    /* renamed from: e  reason: collision with root package name */
    public int f47005e;

    /* renamed from: f  reason: collision with root package name */
    public int f47006f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47001a, this.f47003c, this.f47005e, this.f47002b, this.f47004d, this.f47006f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47001a = (float) jSONArray.optDouble(0);
                this.f47002b = (float) jSONArray.optDouble(1);
                this.f47003c = (float) jSONArray.optDouble(2);
                this.f47004d = (float) jSONArray.optDouble(3);
                this.f47005e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47006f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
