package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47723a;

    /* renamed from: b  reason: collision with root package name */
    public float f47724b;

    /* renamed from: c  reason: collision with root package name */
    public float f47725c;

    /* renamed from: d  reason: collision with root package name */
    public float f47726d;

    /* renamed from: e  reason: collision with root package name */
    public int f47727e;

    /* renamed from: f  reason: collision with root package name */
    public int f47728f;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47723a, this.f47725c, this.f47727e, this.f47724b, this.f47726d, this.f47728f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47723a = (float) jSONArray.optDouble(0);
                this.f47724b = (float) jSONArray.optDouble(1);
                this.f47725c = (float) jSONArray.optDouble(2);
                this.f47726d = (float) jSONArray.optDouble(3);
                this.f47727e = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47728f = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
