package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44336a;

    /* renamed from: b  reason: collision with root package name */
    public float f44337b;

    /* renamed from: c  reason: collision with root package name */
    public float f44338c;

    /* renamed from: d  reason: collision with root package name */
    public float f44339d;

    /* renamed from: e  reason: collision with root package name */
    public int f44340e;

    /* renamed from: f  reason: collision with root package name */
    public int f44341f;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f44336a, this.f44338c, this.f44340e, this.f44337b, this.f44339d, this.f44341f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f44336a = (float) jSONArray.optDouble(0);
                this.f44337b = (float) jSONArray.optDouble(1);
                this.f44338c = (float) jSONArray.optDouble(2);
                this.f44339d = (float) jSONArray.optDouble(3);
                this.f44340e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f44341f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
