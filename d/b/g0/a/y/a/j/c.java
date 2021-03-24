package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f46973a;

    /* renamed from: b  reason: collision with root package name */
    public float f46974b;

    /* renamed from: c  reason: collision with root package name */
    public float f46975c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46976d;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f46973a != null) {
            if (!this.f46976d && Math.abs(this.f46975c) >= 360.0f) {
                Path path = bVar.j;
                RectF rectF = this.f46973a;
                float f2 = rectF.bottom;
                float f3 = rectF.top;
                path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
                bVar.j.arcTo(this.f46973a, 0.0f, this.f46974b);
                return;
            }
            float f4 = this.f46975c % 360.0f;
            if (f4 < 0.0f && !this.f46976d) {
                f4 += 360.0f;
            } else if (f4 > 0.0f && this.f46976d) {
                f4 -= 360.0f;
            }
            bVar.j.arcTo(this.f46973a, this.f46974b, f4);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
            int f4 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
            this.f46973a = new RectF(f2 - f4, f3 - f4, f2 + f4, f3 + f4);
            this.f46974b = degrees;
            this.f46975c = degrees2 - degrees;
        }
        if (jSONArray.length() > 5) {
            this.f46976d = jSONArray.optBoolean(5);
        }
    }
}
