package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f47695a;

    /* renamed from: b  reason: collision with root package name */
    public float f47696b;

    /* renamed from: c  reason: collision with root package name */
    public float f47697c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47698d;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f47695a != null) {
            if (!this.f47698d && Math.abs(this.f47697c) >= 360.0f) {
                Path path = bVar.j;
                RectF rectF = this.f47695a;
                float f2 = rectF.bottom;
                float f3 = rectF.top;
                path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
                bVar.j.arcTo(this.f47695a, 0.0f, this.f47696b);
                return;
            }
            float f4 = this.f47697c % 360.0f;
            if (f4 < 0.0f && !this.f47698d) {
                f4 += 360.0f;
            } else if (f4 > 0.0f && this.f47698d) {
                f4 -= 360.0f;
            }
            bVar.j.arcTo(this.f47695a, this.f47696b, f4);
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int f2 = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            int f3 = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
            int f4 = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
            this.f47695a = new RectF(f2 - f4, f3 - f4, f2 + f4, f3 + f4);
            this.f47696b = degrees;
            this.f47697c = degrees2 - degrees;
        }
        if (jSONArray.length() > 5) {
            this.f47698d = jSONArray.optBoolean(5);
        }
    }
}
