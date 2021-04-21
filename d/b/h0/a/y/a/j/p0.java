package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47762a;

    /* renamed from: b  reason: collision with root package name */
    public float f47763b;

    /* renamed from: c  reason: collision with root package name */
    public float f47764c;

    /* renamed from: d  reason: collision with root package name */
    public float f47765d;

    /* renamed from: e  reason: collision with root package name */
    public int f47766e;

    /* renamed from: f  reason: collision with root package name */
    public int f47767f;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47762a, this.f47764c, this.f47766e, this.f47763b, this.f47765d, this.f47767f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47762a = (float) jSONArray.optDouble(0);
                this.f47763b = (float) jSONArray.optDouble(1);
                this.f47764c = (float) jSONArray.optDouble(2);
                this.f47765d = (float) jSONArray.optDouble(3);
                this.f47766e = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47767f = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
