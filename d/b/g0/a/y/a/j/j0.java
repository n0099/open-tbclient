package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class j0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f47002a;

    /* renamed from: b  reason: collision with root package name */
    public float f47003b;

    /* renamed from: c  reason: collision with root package name */
    public float f47004c;

    /* renamed from: d  reason: collision with root package name */
    public float f47005d;

    /* renamed from: e  reason: collision with root package name */
    public int f47006e;

    /* renamed from: f  reason: collision with root package name */
    public int f47007f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        } else {
            canvas.restoreToCount(bVar.b());
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f47002a, this.f47004c, this.f47006e, this.f47003b, this.f47005d, this.f47007f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f47002a = (float) jSONArray.optDouble(0);
                this.f47003b = (float) jSONArray.optDouble(1);
                this.f47004c = (float) jSONArray.optDouble(2);
                this.f47005d = (float) jSONArray.optDouble(3);
                this.f47006e = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f47007f = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
