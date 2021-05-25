package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40620a;

    /* renamed from: b  reason: collision with root package name */
    public float f40621b;

    /* renamed from: c  reason: collision with root package name */
    public float f40622c;

    /* renamed from: d  reason: collision with root package name */
    public float f40623d;

    /* renamed from: e  reason: collision with root package name */
    public int f40624e;

    /* renamed from: f  reason: collision with root package name */
    public int f40625f;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f40620a, this.f40622c, this.f40624e, this.f40621b, this.f40623d, this.f40625f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f40620a = (float) jSONArray.optDouble(0);
                this.f40621b = (float) jSONArray.optDouble(1);
                this.f40622c = (float) jSONArray.optDouble(2);
                this.f40623d = (float) jSONArray.optDouble(3);
                this.f40624e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f40625f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }
}
