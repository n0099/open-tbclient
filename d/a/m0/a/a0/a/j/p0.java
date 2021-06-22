package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44444a;

    /* renamed from: b  reason: collision with root package name */
    public float f44445b;

    /* renamed from: c  reason: collision with root package name */
    public float f44446c;

    /* renamed from: d  reason: collision with root package name */
    public float f44447d;

    /* renamed from: e  reason: collision with root package name */
    public int f44448e;

    /* renamed from: f  reason: collision with root package name */
    public int f44449f;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{this.f44444a, this.f44446c, this.f44448e, this.f44445b, this.f44447d, this.f44449f, 0.0f, 0.0f, 1.0f});
        canvas.concat(matrix);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 6) {
                this.f44444a = (float) jSONArray.optDouble(0);
                this.f44445b = (float) jSONArray.optDouble(1);
                this.f44446c = (float) jSONArray.optDouble(2);
                this.f44447d = (float) jSONArray.optDouble(3);
                this.f44448e = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(4));
                this.f44449f = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(5));
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
