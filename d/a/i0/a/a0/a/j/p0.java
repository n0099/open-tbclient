package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40486a;

    /* renamed from: b  reason: collision with root package name */
    public float f40487b;

    /* renamed from: c  reason: collision with root package name */
    public float f40488c;

    /* renamed from: d  reason: collision with root package name */
    public float f40489d;

    /* renamed from: e  reason: collision with root package name */
    public int f40490e;

    /* renamed from: f  reason: collision with root package name */
    public int f40491f;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f40486a, this.f40488c, this.f40490e, this.f40487b, this.f40489d, this.f40491f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f40486a = (float) jSONArray.optDouble(0);
                this.f40487b = (float) jSONArray.optDouble(1);
                this.f40488c = (float) jSONArray.optDouble(2);
                this.f40489d = (float) jSONArray.optDouble(3);
                this.f40490e = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f40491f = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
