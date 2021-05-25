package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f40660a;

    /* renamed from: b  reason: collision with root package name */
    public float f40661b;

    /* renamed from: c  reason: collision with root package name */
    public float f40662c;

    /* renamed from: d  reason: collision with root package name */
    public float f40663d;

    /* renamed from: e  reason: collision with root package name */
    public int f40664e;

    /* renamed from: f  reason: collision with root package name */
    public int f40665f;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f40660a, this.f40662c, this.f40664e, this.f40661b, this.f40663d, this.f40665f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f40660a = (float) jSONArray.optDouble(0);
                this.f40661b = (float) jSONArray.optDouble(1);
                this.f40662c = (float) jSONArray.optDouble(2);
                this.f40663d = (float) jSONArray.optDouble(3);
                this.f40664e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f40665f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }
}
