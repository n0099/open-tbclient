package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f40418a;

    /* renamed from: b  reason: collision with root package name */
    public float f40419b;

    /* renamed from: c  reason: collision with root package name */
    public float f40420c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40421d;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f40418a != null) {
            if (!this.f40421d && Math.abs(this.f40420c) >= 360.0f) {
                Path path = bVar.j;
                RectF rectF = this.f40418a;
                float f2 = rectF.bottom;
                float f3 = rectF.top;
                path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
                bVar.j.arcTo(this.f40418a, 0.0f, this.f40419b);
                return;
            }
            float f4 = this.f40420c % 360.0f;
            if (f4 < 0.0f && !this.f40421d) {
                f4 += 360.0f;
            } else if (f4 > 0.0f && this.f40421d) {
                f4 -= 360.0f;
            }
            bVar.j.arcTo(this.f40418a, this.f40419b, f4);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int g2 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(0));
            int g3 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(1));
            int g4 = d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
            this.f40418a = new RectF(g2 - g4, g3 - g4, g2 + g4, g3 + g4);
            this.f40419b = degrees;
            this.f40420c = degrees2 - degrees;
        }
        if (jSONArray.length() > 5) {
            this.f40421d = jSONArray.optBoolean(5);
        }
    }
}
