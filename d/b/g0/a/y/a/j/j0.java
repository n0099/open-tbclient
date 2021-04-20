package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47394a;

    /* renamed from: b  reason: collision with root package name */
    public float f47395b;

    /* renamed from: c  reason: collision with root package name */
    public float f47396c;

    /* renamed from: d  reason: collision with root package name */
    public float f47397d;

    /* renamed from: e  reason: collision with root package name */
    public int f47398e;

    /* renamed from: f  reason: collision with root package name */
    public int f47399f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47394a, this.f47396c, this.f47398e, this.f47395b, this.f47397d, this.f47399f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47394a = (float) jSONArray.optDouble(0);
                this.f47395b = (float) jSONArray.optDouble(1);
                this.f47396c = (float) jSONArray.optDouble(2);
                this.f47397d = (float) jSONArray.optDouble(3);
                this.f47398e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47399f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45443a) {
                e2.printStackTrace();
            }
        }
    }
}
