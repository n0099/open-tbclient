package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f45196a;

    /* renamed from: b  reason: collision with root package name */
    public float f45197b;

    /* renamed from: c  reason: collision with root package name */
    public float f45198c;

    /* renamed from: d  reason: collision with root package name */
    public float f45199d;

    /* renamed from: e  reason: collision with root package name */
    public int f45200e;

    /* renamed from: f  reason: collision with root package name */
    public int f45201f;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f45196a, this.f45198c, this.f45200e, this.f45197b, this.f45199d, this.f45201f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f45196a = (float) jSONArray.optDouble(0);
                this.f45197b = (float) jSONArray.optDouble(1);
                this.f45198c = (float) jSONArray.optDouble(2);
                this.f45199d = (float) jSONArray.optDouble(3);
                this.f45200e = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(4));
                this.f45201f = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
