package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44296a;

    /* renamed from: b  reason: collision with root package name */
    public float f44297b;

    /* renamed from: c  reason: collision with root package name */
    public float f44298c;

    /* renamed from: d  reason: collision with root package name */
    public float f44299d;

    /* renamed from: e  reason: collision with root package name */
    public int f44300e;

    /* renamed from: f  reason: collision with root package name */
    public int f44301f;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f44296a, this.f44298c, this.f44300e, this.f44297b, this.f44299d, this.f44301f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f44296a = (float) jSONArray.optDouble(0);
                this.f44297b = (float) jSONArray.optDouble(1);
                this.f44298c = (float) jSONArray.optDouble(2);
                this.f44299d = (float) jSONArray.optDouble(3);
                this.f44300e = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f44301f = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
