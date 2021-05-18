package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40446a;

    /* renamed from: b  reason: collision with root package name */
    public float f40447b;

    /* renamed from: c  reason: collision with root package name */
    public float f40448c;

    /* renamed from: d  reason: collision with root package name */
    public float f40449d;

    /* renamed from: e  reason: collision with root package name */
    public int f40450e;

    /* renamed from: f  reason: collision with root package name */
    public int f40451f;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f40446a, this.f40448c, this.f40450e, this.f40447b, this.f40449d, this.f40451f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f40446a = (float) jSONArray.optDouble(0);
                this.f40447b = (float) jSONArray.optDouble(1);
                this.f40448c = (float) jSONArray.optDouble(2);
                this.f40449d = (float) jSONArray.optDouble(3);
                this.f40450e = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f40451f = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
