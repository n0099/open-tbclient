package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44404a;

    /* renamed from: b  reason: collision with root package name */
    public float f44405b;

    /* renamed from: c  reason: collision with root package name */
    public float f44406c;

    /* renamed from: d  reason: collision with root package name */
    public float f44407d;

    /* renamed from: e  reason: collision with root package name */
    public int f44408e;

    /* renamed from: f  reason: collision with root package name */
    public int f44409f;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f44404a, this.f44406c, this.f44408e, this.f44405b, this.f44407d, this.f44409f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f44404a = (float) jSONArray.optDouble(0);
                this.f44405b = (float) jSONArray.optDouble(1);
                this.f44406c = (float) jSONArray.optDouble(2);
                this.f44407d = (float) jSONArray.optDouble(3);
                this.f44408e = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f44409f = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
