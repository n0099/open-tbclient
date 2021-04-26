package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f45156a;

    /* renamed from: b  reason: collision with root package name */
    public float f45157b;

    /* renamed from: c  reason: collision with root package name */
    public float f45158c;

    /* renamed from: d  reason: collision with root package name */
    public float f45159d;

    /* renamed from: e  reason: collision with root package name */
    public int f45160e;

    /* renamed from: f  reason: collision with root package name */
    public int f45161f;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f45156a, this.f45158c, this.f45160e, this.f45157b, this.f45159d, this.f45161f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f45156a = (float) jSONArray.optDouble(0);
                this.f45157b = (float) jSONArray.optDouble(1);
                this.f45158c = (float) jSONArray.optDouble(2);
                this.f45159d = (float) jSONArray.optDouble(3);
                this.f45160e = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f45161f = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
