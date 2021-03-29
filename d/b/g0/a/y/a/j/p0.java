package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47041a;

    /* renamed from: b  reason: collision with root package name */
    public float f47042b;

    /* renamed from: c  reason: collision with root package name */
    public float f47043c;

    /* renamed from: d  reason: collision with root package name */
    public float f47044d;

    /* renamed from: e  reason: collision with root package name */
    public int f47045e;

    /* renamed from: f  reason: collision with root package name */
    public int f47046f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47041a, this.f47043c, this.f47045e, this.f47042b, this.f47044d, this.f47046f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47041a = (float) jSONArray.optDouble(0);
                this.f47042b = (float) jSONArray.optDouble(1);
                this.f47043c = (float) jSONArray.optDouble(2);
                this.f47044d = (float) jSONArray.optDouble(3);
                this.f47045e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47046f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
